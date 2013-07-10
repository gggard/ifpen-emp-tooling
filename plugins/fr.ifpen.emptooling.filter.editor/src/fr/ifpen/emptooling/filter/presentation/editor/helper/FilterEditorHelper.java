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
package fr.ifpen.emptooling.filter.presentation.editor.helper;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.ifpen.emptooling.filter.FilteredModelCreation;

/**
 *@author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class FilterEditorHelper {

	/**
	 * @return filtered model from filter model uri.
	 */
	public static Resource createTemporaryFilteredModel(Resource resource) {
		if (resource.getContents().isEmpty()) {
			return null;
		}
		FilteredModelCreation filteredModelCreation = new FilteredModelCreation();
		EObject filteredModelRoot = filteredModelCreation
				.createFilteredModel(EcoreUtil.copy(resource.getContents().get(0)));
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource filteredModel =  resourceSet.createResource(URI.createURI("temp"));
		filteredModel.getContents().add(filteredModelRoot);
		return filteredModel;
	}
}
