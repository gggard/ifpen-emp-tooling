/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid.impl;

import fr.ifpen.emptooling.samples.cuboid.Cuboid;
import fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage;
import fr.ifpen.emptooling.samples.cuboid.Scene;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scene</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#getCubes <em>Cubes</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#getRotationX <em>Rotation X</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#getTranslationX <em>Translation X</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#getTranslationY <em>Translation Y</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#getTranslationZ <em>Translation Z</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#getRotationY <em>Rotation Y</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#getRotationZ <em>Rotation Z</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#isRotate <em>Rotate</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#isShowWires <em>Show Wires</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl#isShowFaces <em>Show Faces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SceneImpl extends EObjectImpl implements Scene {
    /**
     * The cached value of the '{@link #getCubes() <em>Cubes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCubes()
     * @generated
     * @ordered
     */
    protected EList<Cuboid> cubes;

    /**
     * The default value of the '{@link #getRotationX() <em>Rotation X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRotationX()
     * @generated
     * @ordered
     */
    protected static final float ROTATION_X_EDEFAULT = 0.0F;

    /**
     * The cached value of the '{@link #getRotationX() <em>Rotation X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRotationX()
     * @generated
     * @ordered
     */
    protected float rotationX = ROTATION_X_EDEFAULT;

    /**
     * The default value of the '{@link #getTranslationX() <em>Translation X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTranslationX()
     * @generated
     * @ordered
     */
    protected static final int TRANSLATION_X_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getTranslationX() <em>Translation X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTranslationX()
     * @generated
     * @ordered
     */
    protected int translationX = TRANSLATION_X_EDEFAULT;

    /**
     * The default value of the '{@link #getTranslationY() <em>Translation Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTranslationY()
     * @generated
     * @ordered
     */
    protected static final int TRANSLATION_Y_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getTranslationY() <em>Translation Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTranslationY()
     * @generated
     * @ordered
     */
    protected int translationY = TRANSLATION_Y_EDEFAULT;

    /**
     * The default value of the '{@link #getTranslationZ() <em>Translation Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTranslationZ()
     * @generated
     * @ordered
     */
    protected static final int TRANSLATION_Z_EDEFAULT = -10;

    /**
     * The cached value of the '{@link #getTranslationZ() <em>Translation Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTranslationZ()
     * @generated
     * @ordered
     */
    protected int translationZ = TRANSLATION_Z_EDEFAULT;

    /**
     * The default value of the '{@link #getRotationY() <em>Rotation Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRotationY()
     * @generated
     * @ordered
     */
    protected static final float ROTATION_Y_EDEFAULT = 0.0F;

    /**
     * The cached value of the '{@link #getRotationY() <em>Rotation Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRotationY()
     * @generated
     * @ordered
     */
    protected float rotationY = ROTATION_Y_EDEFAULT;

    /**
     * The default value of the '{@link #getRotationZ() <em>Rotation Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRotationZ()
     * @generated
     * @ordered
     */
    protected static final float ROTATION_Z_EDEFAULT = 0.0F;

    /**
     * The cached value of the '{@link #getRotationZ() <em>Rotation Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRotationZ()
     * @generated
     * @ordered
     */
    protected float rotationZ = ROTATION_Z_EDEFAULT;

    /**
     * The default value of the '{@link #isRotate() <em>Rotate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRotate()
     * @generated
     * @ordered
     */
    protected static final boolean ROTATE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isRotate() <em>Rotate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRotate()
     * @generated
     * @ordered
     */
    protected boolean rotate = ROTATE_EDEFAULT;

    /**
     * The default value of the '{@link #isShowWires() <em>Show Wires</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowWires()
     * @generated
     * @ordered
     */
    protected static final boolean SHOW_WIRES_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isShowWires() <em>Show Wires</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowWires()
     * @generated
     * @ordered
     */
    protected boolean showWires = SHOW_WIRES_EDEFAULT;

    /**
     * The default value of the '{@link #isShowFaces() <em>Show Faces</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowFaces()
     * @generated
     * @ordered
     */
    protected static final boolean SHOW_FACES_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isShowFaces() <em>Show Faces</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowFaces()
     * @generated
     * @ordered
     */
    protected boolean showFaces = SHOW_FACES_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SceneImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CuboidModelerPackage.Literals.SCENE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Cuboid> getCubes() {
        if (cubes == null) {
            cubes = new EObjectContainmentEList<Cuboid>(Cuboid.class, this, CuboidModelerPackage.SCENE__CUBES);
        }
        return cubes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public float getRotationX() {
        return rotationX;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRotationX(float newRotationX) {
        float oldRotationX = rotationX;
        rotationX = newRotationX;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE__ROTATION_X, oldRotationX, rotationX));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTranslationX() {
        return translationX;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTranslationX(int newTranslationX) {
        int oldTranslationX = translationX;
        translationX = newTranslationX;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE__TRANSLATION_X, oldTranslationX, translationX));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTranslationY() {
        return translationY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTranslationY(int newTranslationY) {
        int oldTranslationY = translationY;
        translationY = newTranslationY;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE__TRANSLATION_Y, oldTranslationY, translationY));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTranslationZ() {
        return translationZ;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTranslationZ(int newTranslationZ) {
        int oldTranslationZ = translationZ;
        translationZ = newTranslationZ;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE__TRANSLATION_Z, oldTranslationZ, translationZ));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public float getRotationY() {
        return rotationY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRotationY(float newRotationY) {
        float oldRotationY = rotationY;
        rotationY = newRotationY;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE__ROTATION_Y, oldRotationY, rotationY));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public float getRotationZ() {
        return rotationZ;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRotationZ(float newRotationZ) {
        float oldRotationZ = rotationZ;
        rotationZ = newRotationZ;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE__ROTATION_Z, oldRotationZ, rotationZ));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isRotate() {
        return rotate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRotate(boolean newRotate) {
        boolean oldRotate = rotate;
        rotate = newRotate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE__ROTATE, oldRotate, rotate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isShowWires() {
        return showWires;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShowWires(boolean newShowWires) {
        boolean oldShowWires = showWires;
        showWires = newShowWires;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE__SHOW_WIRES, oldShowWires, showWires));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isShowFaces() {
        return showFaces;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShowFaces(boolean newShowFaces) {
        boolean oldShowFaces = showFaces;
        showFaces = newShowFaces;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE__SHOW_FACES, oldShowFaces, showFaces));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CuboidModelerPackage.SCENE__CUBES:
                return ((InternalEList<?>)getCubes()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CuboidModelerPackage.SCENE__CUBES:
                return getCubes();
            case CuboidModelerPackage.SCENE__ROTATION_X:
                return getRotationX();
            case CuboidModelerPackage.SCENE__TRANSLATION_X:
                return getTranslationX();
            case CuboidModelerPackage.SCENE__TRANSLATION_Y:
                return getTranslationY();
            case CuboidModelerPackage.SCENE__TRANSLATION_Z:
                return getTranslationZ();
            case CuboidModelerPackage.SCENE__ROTATION_Y:
                return getRotationY();
            case CuboidModelerPackage.SCENE__ROTATION_Z:
                return getRotationZ();
            case CuboidModelerPackage.SCENE__ROTATE:
                return isRotate();
            case CuboidModelerPackage.SCENE__SHOW_WIRES:
                return isShowWires();
            case CuboidModelerPackage.SCENE__SHOW_FACES:
                return isShowFaces();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CuboidModelerPackage.SCENE__CUBES:
                getCubes().clear();
                getCubes().addAll((Collection<? extends Cuboid>)newValue);
                return;
            case CuboidModelerPackage.SCENE__ROTATION_X:
                setRotationX((Float)newValue);
                return;
            case CuboidModelerPackage.SCENE__TRANSLATION_X:
                setTranslationX((Integer)newValue);
                return;
            case CuboidModelerPackage.SCENE__TRANSLATION_Y:
                setTranslationY((Integer)newValue);
                return;
            case CuboidModelerPackage.SCENE__TRANSLATION_Z:
                setTranslationZ((Integer)newValue);
                return;
            case CuboidModelerPackage.SCENE__ROTATION_Y:
                setRotationY((Float)newValue);
                return;
            case CuboidModelerPackage.SCENE__ROTATION_Z:
                setRotationZ((Float)newValue);
                return;
            case CuboidModelerPackage.SCENE__ROTATE:
                setRotate((Boolean)newValue);
                return;
            case CuboidModelerPackage.SCENE__SHOW_WIRES:
                setShowWires((Boolean)newValue);
                return;
            case CuboidModelerPackage.SCENE__SHOW_FACES:
                setShowFaces((Boolean)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case CuboidModelerPackage.SCENE__CUBES:
                getCubes().clear();
                return;
            case CuboidModelerPackage.SCENE__ROTATION_X:
                setRotationX(ROTATION_X_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE__TRANSLATION_X:
                setTranslationX(TRANSLATION_X_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE__TRANSLATION_Y:
                setTranslationY(TRANSLATION_Y_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE__TRANSLATION_Z:
                setTranslationZ(TRANSLATION_Z_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE__ROTATION_Y:
                setRotationY(ROTATION_Y_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE__ROTATION_Z:
                setRotationZ(ROTATION_Z_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE__ROTATE:
                setRotate(ROTATE_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE__SHOW_WIRES:
                setShowWires(SHOW_WIRES_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE__SHOW_FACES:
                setShowFaces(SHOW_FACES_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case CuboidModelerPackage.SCENE__CUBES:
                return cubes != null && !cubes.isEmpty();
            case CuboidModelerPackage.SCENE__ROTATION_X:
                return rotationX != ROTATION_X_EDEFAULT;
            case CuboidModelerPackage.SCENE__TRANSLATION_X:
                return translationX != TRANSLATION_X_EDEFAULT;
            case CuboidModelerPackage.SCENE__TRANSLATION_Y:
                return translationY != TRANSLATION_Y_EDEFAULT;
            case CuboidModelerPackage.SCENE__TRANSLATION_Z:
                return translationZ != TRANSLATION_Z_EDEFAULT;
            case CuboidModelerPackage.SCENE__ROTATION_Y:
                return rotationY != ROTATION_Y_EDEFAULT;
            case CuboidModelerPackage.SCENE__ROTATION_Z:
                return rotationZ != ROTATION_Z_EDEFAULT;
            case CuboidModelerPackage.SCENE__ROTATE:
                return rotate != ROTATE_EDEFAULT;
            case CuboidModelerPackage.SCENE__SHOW_WIRES:
                return showWires != SHOW_WIRES_EDEFAULT;
            case CuboidModelerPackage.SCENE__SHOW_FACES:
                return showFaces != SHOW_FACES_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (rotationX: ");
        result.append(rotationX);
        result.append(", translationX: ");
        result.append(translationX);
        result.append(", translationY: ");
        result.append(translationY);
        result.append(", translationZ: ");
        result.append(translationZ);
        result.append(", rotationY: ");
        result.append(rotationY);
        result.append(", rotationZ: ");
        result.append(rotationZ);
        result.append(", rotate: ");
        result.append(rotate);
        result.append(", showWires: ");
        result.append(showWires);
        result.append(", showFaces: ");
        result.append(showFaces);
        result.append(')');
        return result.toString();
    }

} //SceneImpl
