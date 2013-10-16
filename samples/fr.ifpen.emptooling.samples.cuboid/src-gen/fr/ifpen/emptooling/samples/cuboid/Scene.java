/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scene</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#getCubes <em>Cubes</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#getRotationX <em>Rotation X</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationX <em>Translation X</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationY <em>Translation Y</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationZ <em>Translation Z</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#getRotationY <em>Rotation Y</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#getRotationZ <em>Rotation Z</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#isRotate <em>Rotate</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#isShowWires <em>Show Wires</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.Scene#isShowFaces <em>Show Faces</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene()
 * @model
 * @generated
 */
public interface Scene extends EObject {
    /**
     * Returns the value of the '<em><b>Cubes</b></em>' containment reference list.
     * The list contents are of type {@link fr.ifpen.emptooling.samples.cuboid.Cuboid}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cubes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cubes</em>' containment reference list.
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_Cubes()
     * @model containment="true"
     * @generated
     */
    EList<Cuboid> getCubes();

    /**
     * Returns the value of the '<em><b>Rotation X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rotation X</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rotation X</em>' attribute.
     * @see #setRotationX(float)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_RotationX()
     * @model required="true"
     * @generated
     */
    float getRotationX();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getRotationX <em>Rotation X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rotation X</em>' attribute.
     * @see #getRotationX()
     * @generated
     */
    void setRotationX(float value);

    /**
     * Returns the value of the '<em><b>Translation X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Translation X</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Translation X</em>' attribute.
     * @see #setTranslationX(int)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_TranslationX()
     * @model required="true"
     * @generated
     */
    int getTranslationX();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationX <em>Translation X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Translation X</em>' attribute.
     * @see #getTranslationX()
     * @generated
     */
    void setTranslationX(int value);

    /**
     * Returns the value of the '<em><b>Translation Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Translation Y</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Translation Y</em>' attribute.
     * @see #setTranslationY(int)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_TranslationY()
     * @model required="true"
     * @generated
     */
    int getTranslationY();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationY <em>Translation Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Translation Y</em>' attribute.
     * @see #getTranslationY()
     * @generated
     */
    void setTranslationY(int value);

    /**
     * Returns the value of the '<em><b>Translation Z</b></em>' attribute.
     * The default value is <code>"-10"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Translation Z</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Translation Z</em>' attribute.
     * @see #setTranslationZ(int)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_TranslationZ()
     * @model default="-10" required="true"
     * @generated
     */
    int getTranslationZ();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationZ <em>Translation Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Translation Z</em>' attribute.
     * @see #getTranslationZ()
     * @generated
     */
    void setTranslationZ(int value);

    /**
     * Returns the value of the '<em><b>Rotation Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rotation Y</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rotation Y</em>' attribute.
     * @see #setRotationY(float)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_RotationY()
     * @model required="true"
     * @generated
     */
    float getRotationY();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getRotationY <em>Rotation Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rotation Y</em>' attribute.
     * @see #getRotationY()
     * @generated
     */
    void setRotationY(float value);

    /**
     * Returns the value of the '<em><b>Rotation Z</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rotation Z</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rotation Z</em>' attribute.
     * @see #setRotationZ(float)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_RotationZ()
     * @model required="true"
     * @generated
     */
    float getRotationZ();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getRotationZ <em>Rotation Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rotation Z</em>' attribute.
     * @see #getRotationZ()
     * @generated
     */
    void setRotationZ(float value);

    /**
     * Returns the value of the '<em><b>Rotate</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rotate</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rotate</em>' attribute.
     * @see #setRotate(boolean)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_Rotate()
     * @model default="true"
     * @generated
     */
    boolean isRotate();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Scene#isRotate <em>Rotate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rotate</em>' attribute.
     * @see #isRotate()
     * @generated
     */
    void setRotate(boolean value);

    /**
     * Returns the value of the '<em><b>Show Wires</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Show Wires</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Show Wires</em>' attribute.
     * @see #setShowWires(boolean)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_ShowWires()
     * @model default="true"
     * @generated
     */
    boolean isShowWires();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Scene#isShowWires <em>Show Wires</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Show Wires</em>' attribute.
     * @see #isShowWires()
     * @generated
     */
    void setShowWires(boolean value);

    /**
     * Returns the value of the '<em><b>Show Faces</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Show Faces</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Show Faces</em>' attribute.
     * @see #setShowFaces(boolean)
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#getScene_ShowFaces()
     * @model default="true"
     * @generated
     */
    boolean isShowFaces();

    /**
     * Sets the value of the '{@link fr.ifpen.emptooling.samples.cuboid.Scene#isShowFaces <em>Show Faces</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Show Faces</em>' attribute.
     * @see #isShowFaces()
     * @generated
     */
    void setShowFaces(boolean value);

} // Scene
