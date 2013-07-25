/**
 * <copyright>
 *
 * Copyright (c) 2013 IFPEN and Obeo.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   Obeo - Initial API and implementation.
 *
 * </copyright>
 *
 */
package fr.ifpen.emptooling.reverse.ui.handlers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import fr.ifpen.emptooling.reverse.JavaToEcore;
import fr.ifpen.emptooling.reverse.ReverseSettings;
import fr.ifpen.emptooling.reverse.ui.ReverseUIPlugin;
import fr.ifpen.emptooling.reverse.ui.wizards.ReverseToEcoreWizard;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 * 
 */
public class ReverseToEcoreHandler extends AbstractHandler {

	private IJavaProject javaProject;
	private List<IPackageFragment> javaPackages = new ArrayList<IPackageFragment>();

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		Shell activeShell = HandlerUtil.getActiveShell(event);
		StructuredSelection sSelection = (StructuredSelection) window.getSelectionService().getSelection();
		if (!sSelection.isEmpty()) {
			Object selection = sSelection.getFirstElement();
			if (selection instanceof IJavaProject) {
				javaProject = (IJavaProject) selection;
				if (javaPackages.isEmpty()) {
					try {
						for (IPackageFragment pf : javaProject.getPackageFragments()) {
							if (pf.getKind() == IPackageFragmentRoot.K_SOURCE && pf.hasChildren()) {
								javaPackages.add(pf);
							}
						}
					} catch (JavaModelException e) {
						e.printStackTrace();
					}
				}
			} else {
				if (selection instanceof IPackageFragment
						&& ((IPackageFragment) selection).getElementType() == IJavaElement.PACKAGE_FRAGMENT) {
					this.javaPackages.add((IPackageFragment) selection);
					this.javaProject = ((IPackageFragment) selection).getJavaProject();
				}
			}	
			ReverseToEcoreWizard wizard = new ReverseToEcoreWizard();
			WizardDialog dialog = new WizardDialog(activeShell, wizard);
			wizard.setWindowTitle("Reverse configuration");

			if (dialog.open() == Window.OK) {
				final ReverseSettings reverseSettings = new ReverseSettings();
				reverseSettings.rootNsPrefix = wizard.getBaseNSPrefix();
				reverseSettings.rootNsURI = wizard.getBaseURI();
				reverseSettings.rootPackageName = javaProject.getElementName();
				final IContainer target = wizard.getTargetContainer();
				IRunnableWithProgress operation = new ReverseToEcoreRunnable(javaProject, javaPackages, reverseSettings, target);
				try {
					PlatformUI.getWorkbench().getProgressService().run(true, true, operation);
				}
				catch (InvocationTargetException e) {
					IStatus status = new Status(IStatus.ERROR, ReverseUIPlugin.PLUGIN_ID, e.getMessage(), e);
					ReverseUIPlugin.getPlugin().getLog().log(status);
				}
				catch (InterruptedException e) {
					IStatus status = new Status(IStatus.ERROR, ReverseUIPlugin.PLUGIN_ID, e.getMessage(), e);
					ReverseUIPlugin.getPlugin().getLog().log(status);
				}

			}

		}
		return null;
	}


	private static class ReverseToEcoreRunnable implements IRunnableWithProgress {

		private IJavaProject javaProject;
		private List<IPackageFragment> javaPackages = new ArrayList<IPackageFragment>();
		private ReverseSettings reverseSettings;
		private IContainer target;


		public ReverseToEcoreRunnable(IJavaProject javaProject, List<IPackageFragment> javaPackages, ReverseSettings reverseSettings, IContainer target) {
			this.javaProject = javaProject;
			this.javaPackages = javaPackages;
			this.reverseSettings = reverseSettings;
			this.target = target;
		}

		/**
		 * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
		 */
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			try {
				JavaToEcore javaToEcore = null;
				if (!javaPackages.isEmpty() && javaProject != null) {
					javaToEcore = new JavaToEcore(javaProject, javaPackages, reverseSettings);
				}
				// process a whole java project
				else if (javaProject != null) {
					javaToEcore = new JavaToEcore(javaProject, reverseSettings);
				}
				if (javaToEcore != null) {
					javaToEcore.setBaseURI(reverseSettings.rootNsURI);
					javaToEcore.setBaseNSPrefix(reverseSettings.rootNsPrefix);
					EPackage reverse = javaToEcore.reverse(monitor);
					if (reverse != null) {
						String modelFilename = "reverse";
						// write logs
						String NL = System.getProperty("line.separator");
						List<String> log = javaToEcore.getErrorLog();
						IFile parsingLogFile = target.getFile(new Path(modelFilename + "ParsingLog.csv"));
						Writer w = new BufferedWriter(new FileWriter(parsingLogFile.getLocation().toOSString()));
						for (String s : log) {
							w.write(s);
							w.write(NL);
						}
						w.close();
						log = javaToEcore.getGetterLog();
						IFile gettingLogFile = target.getFile(new Path(modelFilename + "GetterLog.csv"));
						w = new BufferedWriter(new FileWriter(gettingLogFile.getLocation().toOSString()));
						for (String s : log) {
							w.write(s);
							w.write(NL);
						}
						w.close();
						// write model
						IFile file = target.getFile(new Path(modelFilename + ".ecore"));
						URI uri = URI.createFileURI(file.getLocation().toOSString());
						Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
						resource.getContents().add(reverse);
						resource.save(Collections.EMPTY_MAP);
						target.refreshLocal(IResource.DEPTH_INFINITE, monitor);
					}
				}
			}
			catch (Exception e) {
				IStatus status = new Status(IStatus.ERROR, ReverseUIPlugin.PLUGIN_ID, e.getMessage(),e);
				ReverseUIPlugin.getPlugin().getLog().log(status);
			}
		}


	}
}
