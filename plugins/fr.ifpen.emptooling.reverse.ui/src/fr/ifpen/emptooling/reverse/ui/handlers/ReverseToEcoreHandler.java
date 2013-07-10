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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import fr.ifpen.emptooling.reverse.JavaToEcore;
import fr.ifpen.emptooling.reverse.ReverseSettings;
import fr.ifpen.emptooling.reverse.ui.ReverseUIPlugin;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ReverseToEcoreHandler extends AbstractHandler {

	private List<IPackageFragment> javaPackages = new ArrayList<IPackageFragment>();

	/**
	 * The constructor.
	 */
	public ReverseToEcoreHandler() {
	}

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
				final IJavaProject javaProject = (IJavaProject) selection;
				if (javaPackages.isEmpty()) {
					try {
						for (IPackageFragment pf : javaProject.getPackageFragments()) {
							if (pf.getKind() == IPackageFragmentRoot.K_SOURCE && pf.hasChildren()) {
								javaPackages.add(pf);
							}
						}
						final ReverseSettings reverseSettings = new ReverseSettings();
						reverseSettings.rootNsPrefix = "demo";
						reverseSettings.rootNsURI = "http://www.demo.com/model";
						reverseSettings.rootPackageName = "demo";

						ContainerSelectionDialog selectionDialog = new ContainerSelectionDialog(activeShell, javaProject.getProject().getParent(), false, "Select target directory");
						if (selectionDialog.open() == Window.OK) {
							final IFolder target = javaProject.getProject().getWorkspace().getRoot().getFolder((IPath) selectionDialog.getResult()[0]);
							IRunnableWithProgress operation = new IRunnableWithProgress() {
								public void run(IProgressMonitor monitor) {
									try {
										JavaToEcore javaToEcore = null;
										// create a new plugin to host the generated Ecore model
										// process packages per packages
										if (!javaPackages.isEmpty() && javaProject != null) {
											javaToEcore = new JavaToEcore(javaProject, javaPackages, reverseSettings);
										}
										// process a whole java project
										else if (javaProject != null) {
											javaToEcore = new JavaToEcore(javaProject, reverseSettings);
										}
										if (javaToEcore != null) {
											EPackage reverse = javaToEcore.reverse(monitor);
											if (reverse != null) {
												String modelFilename = "reverse";
												// write logs
												String NL = System.getProperty("line.separator");
												List<String> log = javaToEcore.getErrorLog();
												IFile parsingLogFile = target.getFile(modelFilename + "ParsingLog.csv");
												Writer w = new BufferedWriter(new FileWriter(parsingLogFile.getFullPath().toOSString()));
												for (String s : log) {
													w.write(s);
													w.write(NL);
												}
												w.close();
												log = javaToEcore.getGetterLog();
												IFile gettingLogFile = target.getFile(modelFilename + "GetterLog.csv");
												w = new BufferedWriter(new FileWriter(gettingLogFile.getFullPath().toOSString()));
												for (String s : log) {
													w.write(s);
													w.write(NL);
												}
												w.close();
												// write model
												IFile file = target.getFile(modelFilename + ".ecore");
												URI uri = URI.createFileURI(file.getFullPath().toOSString());
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
							};
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

					} catch (JavaModelException e) {
						e.printStackTrace();
					}
				}


				MessageDialog.openInformation(
						window.getShell(),
						"UI plugin for Java to Ecore reverse tooling",
						"Reversed " + javaProject.getElementName());
			}

		}
		return null;
	}
}
