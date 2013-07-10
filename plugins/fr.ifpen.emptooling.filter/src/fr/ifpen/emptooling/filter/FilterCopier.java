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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * Specific EcoreUtil.copier to copy filtered model elements.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class FilterCopier extends EcoreUtil.Copier {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7312310113677219619L;

	/**
	 * Creates an instance that resolves proxies or not as specified.
	 * 
	 * @param resolveProxies
	 *            whether proxies should be resolved while copying.
	 */
	public FilterCopier(boolean resolveProxies) {
		super(resolveProxies, false);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.util.EcoreUtil.Copier#copy(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public EObject copy(EObject eObject) {
		if (eObject == null) {
			return null;
		} else {
			EObject copyEObject = createCopy(eObject);
			put(eObject, copyEObject);
			EClass eClass = eObject.eClass();
			for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
				EStructuralFeature eStructuralFeature = eClass
						.getEStructuralFeature(i);
				if (eStructuralFeature.isChangeable()
						&& !eStructuralFeature.isDerived()) {
					if (eStructuralFeature instanceof EAttribute) {
						copyAttribute((EAttribute) eStructuralFeature, eObject,
								copyEObject);
					}
				}
			}
			copyProxyURI(eObject, copyEObject);
			return copyEObject;
		}
	}

	/**
	 * Copy the eObject and all its contents
	 * 
	 * @param eObject
	 *            EObject
	 * @return copied object
	 */
	public EObject copyAllContents(EObject eObject) {
		return super.copy(eObject);
	}

	/**
	 * Copy the target Filter in copyEObject in the eReference.
	 * 
	 * @param eReference
	 *            EReference
	 * @param eObject
	 *            EObject
	 * @param copyEObject
	 *            EObject
	 * @param targetFilter
	 *            EObject
	 */
	protected void copyContainment(EReference eReference, EObject eObject,
			EObject copyEObject, EObject targetFilter) {
		if (eObject.eIsSet(eReference)) {
			if (eReference.isMany()) {
				@SuppressWarnings("unchecked")
				List<EObject> source = (List<EObject>) eObject.eGet(eReference);
				@SuppressWarnings("unchecked")
				List<EObject> target = (List<EObject>) copyEObject
						.eGet(getTarget(eReference));
				if (source.isEmpty()) {
					target.clear();
				} else {
					if (source.contains(targetFilter)) {
						target.add(copy(targetFilter));
					}

				}
			} else {
				EObject childEObject = (EObject) eObject.eGet(eReference);
				copyEObject.eSet(getTarget(eReference),
						childEObject == null ? null : copy(childEObject));
			}
		}
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.EcoreUtil.Copier#copyReference(org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected void copyReference(EReference eReference, EObject eObject,
			EObject copyEObject) {
		if (eObject.eIsSet(eReference)) {
			if (eReference.isMany()) {
				@SuppressWarnings("unchecked")
				InternalEList<EObject> source = (InternalEList<EObject>) eObject
						.eGet(eReference);
				@SuppressWarnings("unchecked")
				InternalEList<EObject> target = (InternalEList<EObject>) copyEObject
						.eGet(getTarget(eReference));
				if (source.isEmpty()) {
					target.clear();
				} else {
					boolean isBidirectional = eReference.getEOpposite() != null;
					int index = 0;
					for (Iterator<EObject> k = resolveProxies ? source
							.iterator() : source.basicIterator(); k.hasNext();) {
						EObject referencedEObject = k.next();
						EObject copyReferencedEObject = get(referencedEObject);
						if (copyReferencedEObject == null) {
							if (referencedEObject instanceof EDataType
									&& ((EDataType) referencedEObject)
											.getEPackage()
											.getNsURI()
											.equals("http://www.eclipse.org/emf/2002/Ecore")) {
								target.addUnique(index, referencedEObject);
								++index;
							} else
							if (useOriginalReferences && !isBidirectional) {
								target.addUnique(index, referencedEObject);
								++index;
							}
						} else {
							if (isBidirectional) {
								int position = target
										.indexOf(copyReferencedEObject);
								if (position == -1) {
									target.addUnique(index,
											copyReferencedEObject);
								} else if (index != position) {
									target.move(index, copyReferencedEObject);
								}
							} else {
								target.addUnique(index, copyReferencedEObject);
							}
							++index;
						}
					}
				}
			} else {
				Object referencedEObject = eObject.eGet(eReference,
						resolveProxies);
				if (referencedEObject == null) {
					copyEObject.eSet(getTarget(eReference), null);
				} else {
					Object copyReferencedEObject = get(referencedEObject);
					if (copyReferencedEObject == null) {
						if (referencedEObject instanceof EDataType
								&& ((EDataType) referencedEObject)
										.getEPackage()
										.getNsURI()
										.equals("http://www.eclipse.org/emf/2002/Ecore")) {
							copyEObject.eSet(getTarget(eReference),
									referencedEObject);
						} else {
							if (useOriginalReferences
									&& eReference.getEOpposite() == null) {
								copyEObject.eSet(getTarget(eReference),
										referencedEObject);
							}
						}
					} else {
						copyEObject.eSet(getTarget(eReference),
								copyReferencedEObject);
					}
				}
			}
			
			// remove ref if EType is ignored
			if (copyEObject instanceof EReference && !copyEObject.eIsSet(eReference)) {
				EObject containerCopy = get(eObject.eContainer());
				if (containerCopy != null && copyEObject.eContainmentFeature() != null) {
					if (copyEObject.eContainmentFeature().isMany() && containerCopy.eGet(copyEObject.eContainmentFeature()) instanceof List) {
						((List)containerCopy.eGet(copyEObject.eContainmentFeature())).remove(copyEObject);
					} else {
						containerCopy.eUnset(copyEObject.eContainmentFeature());
					}
				}
				
			}
		}
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.EcoreUtil.Copier#copyAll(java.util.Collection)
	 */
	@Override
	public <T> Collection<T> copyAll(Collection<? extends T> eObjects) {
		 Collection<T> result = new ArrayList<T>(eObjects.size());
	      for (Object object : eObjects)
	      {
	        @SuppressWarnings("unchecked") T t = (T)super.copy((EObject)object);
	        result.add(t);
	      }
	      return result;
	}

	
}
