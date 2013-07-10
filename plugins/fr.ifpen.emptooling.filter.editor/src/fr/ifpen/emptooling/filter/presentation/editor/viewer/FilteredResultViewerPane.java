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
package fr.ifpen.emptooling.filter.presentation.editor.viewer;

import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchPage;

import fr.ifpen.emptooling.filter.presentation.editor.IFPFilterEditor;
import fr.ifpen.emptooling.filter.presentation.editor.helper.FilterEditorHelper;

/**
 * ViewerPane for result viewer page.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class FilteredResultViewerPane extends ViewerPane {

	/**
	 * IFPFilterEditor
	 */
	private IFPFilterEditor editor;

	/**
	 * @param page IWorkbenchPage
	 * @param editor IFPFilterEditor
	 */
	public FilteredResultViewerPane(IWorkbenchPage page, IFPFilterEditor editor) {
		super(page, editor);
		this.editor = editor;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.common.ui.ViewerPane#createViewer(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public Viewer createViewer(Composite composite) {
		Tree tree = new Tree(composite, SWT.MULTI);
		TreeViewer newTreeViewer = new TreeViewer(tree);
		return newTreeViewer;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.common.ui.ViewerPane#requestActivation()
	 */
	@Override
	public void requestActivation() {
		super.requestActivation();
		editor.setCurrentViewerPane(this);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.common.ui.ViewerPane#setFocus()
	 */
	@Override
	public void setFocus() {
		super.setFocus();
		// refresh result viewer if needed
		if (editor.needRefresh()) {
			editor.getResultViewer().setInput(FilterEditorHelper.createTemporaryFilteredModel(editor.getFilterResource()));
			editor.setNeedRefresh(false);
		}
	}

}
