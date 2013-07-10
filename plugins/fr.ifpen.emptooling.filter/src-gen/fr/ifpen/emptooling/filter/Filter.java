/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.ifpen.emptooling.filter;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.ifpen.emptooling.filter.Filter#getTarget <em>Target</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.filter.Filter#getSubFilters <em>Sub Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.ifpen.emptooling.filter.FilterPackage#getFilter()
 * @model
 * @generated
 */
public interface Filter extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EObject)
	 * @see fr.ifpen.emptooling.filter.FilterPackage#getFilter_Target()
	 * @model required="true"
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link fr.ifpen.emptooling.filter.Filter#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

	/**
	 * Returns the value of the '<em><b>Sub Filters</b></em>' containment reference list.
	 * The list contents are of type {@link fr.ifpen.emptooling.filter.Filter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Filters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Filters</em>' containment reference list.
	 * @see fr.ifpen.emptooling.filter.FilterPackage#getFilter_SubFilters()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Filter> getSubFilters();

} // Filter
