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

package fr.ifpen.emptooling.filter.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 *  *@author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class FilterResource extends XMIResourceImpl {

	/**
	 * Constructor.
	 */
	public FilterResource() {
		super();
	}

	/**
	 * Constructor.
	 */
	public FilterResource(URI uri) {
		super(uri);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl#createXMLHelper()
	 */
	@Override
	protected XMLHelper createXMLHelper() {
		return new XMIHelperImpl(this) {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl#deresolve(org.eclipse.emf.common.util.URI)
			 */
			@Override
			public URI deresolve(URI uri) {
				return uri;
			}
	    	
	    };
	}

}
