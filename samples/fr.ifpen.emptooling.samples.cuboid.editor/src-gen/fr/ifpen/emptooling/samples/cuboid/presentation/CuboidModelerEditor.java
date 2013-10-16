/**
 * <copyright>
 * </copyright>
 *
 */
package fr.ifpen.emptooling.samples.cuboid.presentation;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.eef.runtime.ui.EEFExtendedRuntime;

import org.eclipse.emf.eef.runtime.ui.editor.InteractiveEEFEditor;

import org.eclipse.emf.eef.runtime.ui.editors.pages.tree.EEFTreeMDFormPage;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.PartInitException;
/**
 * This is an example of a cuboid model editor.
 * 
 */
public class CuboidModelerEditor extends InteractiveEEFEditor {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.editor.InteractiveEEFEditor#contributePages()
	 */
	protected void contributePages() {
		try {
			{
				Object input = getEditingDomain().getResourceSet();
				
				{
					final EEFTreeMDFormPage page = new EEFTreeMDFormPage(CuboidModelerEditor.this, "main") {
					
						/**
						 * {@inheritDoc}
						 * @see org.eclipse.ui.forms.editor.FormPage#createPartControl(org.eclipse.swt.widgets.Composite)
						 */
						public void createPartControl(Composite parent) {
							super.createPartControl(parent);
							getModelViewer().addSelectionChangedListener(new ISelectionChangedListener() {
								// This just notifies those things that are affected by the section.
								//
								public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
									CuboidModelerEditor.this.setSelection(selectionChangedEvent.getSelection());
								}
							}
						
							);
						}
						
					};
					page.setInitialMasterPartToolBarVisibility(false);
					page.setAdapterFactory(adapterFactory);
					page.setEditingDomain(editingDomain);
					page.setInput(input);
					addPage(page);
				}
			}
		} catch (PartInitException e) {
			EEFExtendedRuntime.getPlugin().log(e);
		}
	}
	
	

}
	
