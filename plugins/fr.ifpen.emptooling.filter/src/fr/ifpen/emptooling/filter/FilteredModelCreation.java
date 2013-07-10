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
package fr.ifpen.emptooling.filter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.ifpen.emptooling.filter.Filter;

/**
 * From a filter model, create the filtered model.
 * Use a specific EcoreUtil.Copier.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class FilteredModelCreation {

	/**
	 * Specific EcoreUtil.Copier
	 */
	private FilterCopier copier;
	
	/**
	 * Filter resource
	 */
	private Resource filterResource;
	
	/**
	 * Filtered Resource
	 */
	private Resource filteredResource;

	/**
	 * Resource set
	 */
	private ResourceSetImpl resourceSet;

	/**
	 * Constructor
	 */
	public FilteredModelCreation() {
		copier = new FilterCopier(true);
	}

	/**
	 * Create filtered model from the filter model URI.
	 * 
	 * @param modelURI filter model URI
	 * 
	 * @return the filtered model root
	 */
	public EObject createFilteredModel(URI modelURI) {
		// load filter model
		resourceSet = new ResourceSetImpl();
		filterResource = resourceSet.getResource(modelURI, true);
		EcoreUtil.resolveAll(resourceSet);
		
		// create the filtered model
		filteredResource = createFilteredResource(filterResource);

		// return filtered model root if exists
		if (filteredResource != null && !filteredResource.getContents().isEmpty()) {
			return filteredResource.getContents().get(0);
		}
		return null;
	}
	
	/**
	 * Create filtered model from the filter model URI.
	 * 
	 * @param modelURI filter model URI
	 * 
	 * @return the filtered model root
	 */
	public EObject createFilteredModel(EObject eobject) {
		// load filter model
		resourceSet = new ResourceSetImpl();
		filterResource = resourceSet.createResource(URI.createURI(eobject.toString()));
		filterResource.getContents().add(eobject);
		EcoreUtil.resolveAll(resourceSet);
		
		// create the filtered model
		filteredResource = createFilteredResource(filterResource);

		// return filtered model root if exists
		if (filteredResource != null && !filteredResource.getContents().isEmpty()) {
			return filteredResource.getContents().get(0);
		}
		return null;
	}

	/**
	 * Create the filtered resource
	 * 
	 * @param filterResource filter model
	 * 
	 * @return filtered resource
	 */
	protected Resource createFilteredResource(Resource filterResource) {
		Resource newResource = null;
		if (filterResource != null && !filterResource.getContents().isEmpty()
				&& filterResource.getContents().get(0) instanceof Filter) {
			Filter rootFilter = (Filter) filterResource.getContents().get(0);
			if (rootFilter != null) {
				EObject target = rootFilter.getTarget();
				if (target != null && target.eResource() != null) {
					String extension = target.eResource().getURI().fileExtension();
					URI filteredModelURI = filterResource.getURI().appendFileExtension(extension);
					if (resourceSet == null) {
						resourceSet = new ResourceSetImpl();
					}
					newResource = resourceSet.createResource(filteredModelURI);
					visit(rootFilter, newResource);
					copier.copyReferences();
				}
			}
		}
		return newResource;
	}

	/**
	 * Visit filter model element to create the filtered appropriate element.
	 * If a filter has no sub filters, all its content is copied in the filtered element
	 * Else only the sub filtered features are copied.
	 * 
	 * @param rootFilter Filter
	 * @param filteredResource Resource
	 */
	public void visit(Filter rootFilter, Resource filteredResource) {
		EObject target = rootFilter.getTarget();
		if (copier == null) {
			copier = new FilterCopier(true);
		}
		if (target != null) {
//			if (hasSubFilter(rootFilter)) {
				EObject copyEObject = copier.copy(target);
				filteredResource.getContents().add(copyEObject);
				// filter sub content
				for (Filter subFilter : rootFilter.getSubFilters()) {
					visit(subFilter, target, copyEObject);
				}
//			} 
			// no need with check box editor
//			else {
//				// all sub content is filtered
//				EObject copy = EcoreUtil.copy(target);
//				filteredResource.getContents().add(copy);
//			}

		}
	}

	/**
	 * @param filter Filter
	 * @return if the filter has sub filters
	 */
	public boolean hasSubFilter(Filter filter) {
		return !filter.getSubFilters().isEmpty();
	}

	/**
	 * Visit filter model element to create the filtered appropriate element.
	 * 
	 * @param filter Filter
	 * @param target filter target EObject
	 * @param copyEObject EObject
	 */
	private void visit(Filter filter, EObject target, EObject copyEObject) {
		EObject targetFilter = filter.getTarget();
		if (targetFilter.eIsProxy()) {
			EcoreUtil.resolve(targetFilter, resourceSet);
		}
		EReference eStructuralFeature = targetFilter.eContainmentFeature();
//		if (hasSubFilter(filter)) {
			if (eStructuralFeature instanceof EStructuralFeature) {
				if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived()) {
//					if (eStructuralFeature instanceof EAttribute) {
//						copier.copyAttribute((EAttribute) targetFilter, target,
//								copyEObject);
//					} else 
					if (eStructuralFeature instanceof EReference && eStructuralFeature.isContainment()) {
						copier.copyContainment(((EReference) eStructuralFeature), target, copyEObject, targetFilter);
					}
				} 
			}
			for (Filter subFilter : filter.getSubFilters()) {
				visit(subFilter, targetFilter, copier.get(targetFilter));
			}
			// no need with check box editor
//		} else {
//			// all sub content is filtered
//		    EObject copy = copier.copyAllContents(targetFilter);
//			if (eStructuralFeature.isMany() && copyEObject.eGet(eStructuralFeature) instanceof List) {
//				((List)copyEObject.eGet(eStructuralFeature)).add(copy);
//			} else {
//				copyEObject.eSet(eStructuralFeature, copy);
//			}
//		}
	}

	/**
	 * @return FilterCopier
	 */
	public FilterCopier getCopier() {
		return copier;
	}

	/**
	 * @return filterResource
	 */
	public Resource getFilterResource() {
		return filterResource;
	}

	/**
	 * @return filteredResource
	 */
	public Resource getFilteredResource() {
		return filteredResource;
	}
}
