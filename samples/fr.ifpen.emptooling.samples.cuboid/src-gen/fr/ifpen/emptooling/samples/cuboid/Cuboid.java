/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cuboid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Cuboid#getLength <em>Length</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Cuboid#getHeight <em>Height</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Cuboid#getDepth <em>Depth</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getCuboid()
 * @model
 * @generated
 */
public interface Cuboid extends SceneObj {
    /**
     * Returns the value of the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Length</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Length</em>' attribute.
     * @see #setLength(int)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getCuboid_Length()
     * @model required="true"
     * @generated
     */
    int getLength();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Cuboid#getLength <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Length</em>' attribute.
     * @see #getLength()
     * @generated
     */
    void setLength(int value);

    /**
     * Returns the value of the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Height</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Height</em>' attribute.
     * @see #setHeight(int)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getCuboid_Height()
     * @model required="true"
     * @generated
     */
    int getHeight();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Cuboid#getHeight <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
    void setHeight(int value);

    /**
     * Returns the value of the '<em><b>Depth</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Depth</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Depth</em>' attribute.
     * @see #setDepth(int)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getCuboid_Depth()
     * @model required="true"
     * @generated
     */
    int getDepth();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Cuboid#getDepth <em>Depth</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Depth</em>' attribute.
     * @see #getDepth()
     * @generated
     */
    void setDepth(int value);

} // Cuboid
