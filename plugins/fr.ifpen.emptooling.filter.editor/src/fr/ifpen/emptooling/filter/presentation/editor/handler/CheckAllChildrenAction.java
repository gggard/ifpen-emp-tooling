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
package fr.ifpen.emptooling.filter.presentation.editor.handler;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import fr.ifpen.emptooling.filter.presentation.editor.AbstractFilterEditor;
import fr.ifpen.emptooling.filter.presentation.editor.IFPFilterEditor;
import fr.ifpen.emptooling.filter.presentation.editor.viewer.IFPContainerCheckedTreeViewer;

/**
 * Action to to check all children of a tree item.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class CheckAllChildrenAction extends Action {

	private final IFPFilterEditor editor;

	public static final ImageDescriptor DEFAULT_DESC = AbstractUIPlugin
			.imageDescriptorFromPlugin(AbstractFilterEditor.EDITOR_PATH,
					"/icons/check.gif"); //$NON-NLS-1$

	public CheckAllChildrenAction(IFPFilterEditor editor) {
		super();
		this.editor = editor;
		setId("fr.ifpen.emptooling.filter.editor.checkAllChildren");
		setText("Check all children");
		setToolTipText("Check all children");
		setImageDescriptor(DEFAULT_DESC);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		Viewer currentViewer = editor.getViewer();
		IFPContainerCheckedTreeViewer checkViewer = editor.getCheckViewer();
		if (currentViewer != null && checkViewer != null
				&& currentViewer.equals(checkViewer)) {
			ISelection currentSelection = checkViewer.getSelection();
			if (currentSelection instanceof StructuredSelection) {
				for (Object selectedElement : ((StructuredSelection) currentSelection)
						.toList()) {
					CompoundCommand command = checkViewer.setSubtreeChecked2(
							selectedElement, true);
					if (command != null && !command.isEmpty()) {
						editor.getEditingDomain().getCommandStack()
								.execute(command);
					}
				}
			}
		}
	}

}
