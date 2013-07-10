/*******************************************************************************
 * Copyright (c) 2013 IFPen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IFPen - initial API and implementation
 *******************************************************************************/
package fr.ifpen.emptooling.filter.presentation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;

/**
 * Wizard page to select the first element to filter.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class FirstFilteredElementPage extends WizardPage {

	/**
	 * Resource set.
	 */
	private ResourceSetImpl resourceSet;

	/**
	 * Tree viewer
	 */
	private TreeViewer treeViewer;
	
	/**
	 * First filtered element.
	 */
	private EObject firstFilteredElement;

	/**
	 * Default constructor.
	 * @param selection 
	 * 
	 */
	protected FirstFilteredElementPage() {
		super("First filtered element selection");
		setTitle("Select the model element to filter.");
		setDescription("Select the first filtered element model.");
		resourceSet = new ResourceSetImpl();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));

		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		label.setText("Filtered element.");

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		composite.setLayout(new TreeColumnLayout());

		treeViewer = new TreeViewer(composite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(false);
		tree.setLinesVisible(false);

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory));
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		treeViewer.setUseHashlookup(true);

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection
						&& ((IStructuredSelection) selection).size() == 1
						&& ((IStructuredSelection) selection).getFirstElement() instanceof EObject) {
					firstFilteredElement = (EObject) ((IStructuredSelection) selection).getFirstElement();
					setPageComplete(true);
				} else {
					setPageComplete(false);
				}
			}
		});
		setPageComplete(false);

	}

	public void setUri(URI uri) {
		if (!treeViewer.getControl().isDisposed()) {
			try {
				Resource resource = resourceSet.getResource(uri, true);
				treeViewer.setInput(resource);
			} catch (RuntimeException exception) {
				// should never happen : check done in previous wizard
				setErrorMessage("Resource '" + uri.toString()
						+ "' does not exist.");
				// FilterEditorPlugin.INSTANCE.log(exception);
			}
			setErrorMessage(null);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#dispose()
	 */
	@Override
	public void dispose() {
		resourceSet = null;
		super.dispose();
	}
	
	/**
	 * @return the first filtered element
	 */
	public EObject getFirstFilteredElement() {
		return firstFilteredElement;
	}
}
