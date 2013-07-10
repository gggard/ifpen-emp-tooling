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
package fr.ifpen.emptooling.filter.presentation.editor.property;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * Property descritor to make read only properties view for result viewer.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class IFPEditorPropertyDescriptor extends PropertyDescriptor {

	/**
	 * Is property view read only ?
	 */
	private final boolean isReadonly;

	/**
	 * @param object Object
	 * @param itemPropertyDescriptor IItemPropertyDescriptor
	 * @param isReadonly
	 */
	public IFPEditorPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor, boolean isReadonly) {
		super(object, itemPropertyDescriptor);
		this.isReadonly = isReadonly;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.edit.ui.provider.PropertyDescriptor#createPropertyEditor(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public CellEditor createPropertyEditor(Composite composite) {
		if (!isReadonly) {
			return super.createPropertyEditor(composite);
		}
		return null;
	}

}
