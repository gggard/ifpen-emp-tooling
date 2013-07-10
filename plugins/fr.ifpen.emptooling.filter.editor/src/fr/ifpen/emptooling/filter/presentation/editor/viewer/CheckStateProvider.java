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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ICheckStateProvider;

import fr.ifpen.emptooling.filter.Filter;
import fr.ifpen.emptooling.filter.presentation.editor.IFPFilterEditor;

/**
 * Check state provider for check box viewer.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
@SuppressWarnings("restriction")
public class CheckStateProvider implements ICheckStateProvider {

	/**
	 * IFPFilterEditor
	 */
	private final IFPFilterEditor editor;

	/**
	 * @param editor IFPFilterEditor
	 */
	public CheckStateProvider(IFPFilterEditor editor) {
		super();
		this.editor = editor;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.ui.internal.dialogs.TreeManager.CheckStateProvider#isChecked(java.lang.Object)
	 */
	public boolean isChecked(Object element) {
		if (editor.getRootTargetFilter().eIsProxy()
				|| editor.getRootTargetFilter().eResource() == null) {
			EcoreUtil.resolveAll(editor.getFilterResource());
			editor.initVariables();
		}
		if (editor.getRootTargetFilter().equals(element)) {
			return true;
		}

		Map<EObject, Filter> eObjectToFilters = editor.getCheckViewer()
				.getEObjectToFilters();
		Filter filter = eObjectToFilters.get(element);

		return filter != null;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.ui.internal.dialogs.TreeManager.CheckStateProvider#isGrayed(java.lang.Object)
	 */
	public boolean isGrayed(Object element) {
		if (editor.getRootTargetFilter().eIsProxy()
				|| editor.getRootTargetFilter().eResource() == null) {
			EcoreUtil.resolveAll(editor.getFilterResource());
			editor.initVariables();
		}
		if (editor.getRootTargetFilter().equals(element)) {
			return true;
		}
		return false;
	}
}
