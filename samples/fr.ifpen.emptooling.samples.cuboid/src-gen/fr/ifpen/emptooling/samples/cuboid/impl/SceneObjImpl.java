/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid.impl;

import fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage;
import fr.ifpen.emptooling.samples.cuboid.SceneObj;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scene Obj</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl#getPosX <em>Pos X</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl#getPosY <em>Pos Y</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl#getPosZ <em>Pos Z</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl#getRed <em>Red</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl#getGreen <em>Green</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl#getBlue <em>Blue</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl#getOpacity <em>Opacity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SceneObjImpl extends EObjectImpl implements SceneObj {
    /**
     * The default value of the '{@link #getPosX() <em>Pos X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPosX()
     * @generated
     * @ordered
     */
    protected static final int POS_X_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPosX() <em>Pos X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPosX()
     * @generated
     * @ordered
     */
    protected int posX = POS_X_EDEFAULT;

    /**
     * The default value of the '{@link #getPosY() <em>Pos Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPosY()
     * @generated
     * @ordered
     */
    protected static final int POS_Y_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPosY() <em>Pos Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPosY()
     * @generated
     * @ordered
     */
    protected int posY = POS_Y_EDEFAULT;

    /**
     * The default value of the '{@link #getPosZ() <em>Pos Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPosZ()
     * @generated
     * @ordered
     */
    protected static final int POS_Z_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPosZ() <em>Pos Z</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPosZ()
     * @generated
     * @ordered
     */
    protected int posZ = POS_Z_EDEFAULT;

    /**
     * The default value of the '{@link #getRed() <em>Red</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRed()
     * @generated
     * @ordered
     */
    protected static final int RED_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getRed() <em>Red</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRed()
     * @generated
     * @ordered
     */
    protected int red = RED_EDEFAULT;

    /**
     * The default value of the '{@link #getGreen() <em>Green</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGreen()
     * @generated
     * @ordered
     */
    protected static final int GREEN_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getGreen() <em>Green</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGreen()
     * @generated
     * @ordered
     */
    protected int green = GREEN_EDEFAULT;

    /**
     * The default value of the '{@link #getBlue() <em>Blue</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlue()
     * @generated
     * @ordered
     */
    protected static final int BLUE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getBlue() <em>Blue</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlue()
     * @generated
     * @ordered
     */
    protected int blue = BLUE_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getOpacity() <em>Opacity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOpacity()
     * @generated
     * @ordered
     */
    protected static final int OPACITY_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getOpacity() <em>Opacity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOpacity()
     * @generated
     * @ordered
     */
    protected int opacity = OPACITY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SceneObjImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CuboidModelerPackage.Literals.SCENE_OBJ;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPosX() {
        return posX;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPosX(int newPosX) {
        int oldPosX = posX;
        posX = newPosX;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE_OBJ__POS_X, oldPosX, posX));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPosY() {
        return posY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPosY(int newPosY) {
        int oldPosY = posY;
        posY = newPosY;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE_OBJ__POS_Y, oldPosY, posY));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPosZ() {
        return posZ;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPosZ(int newPosZ) {
        int oldPosZ = posZ;
        posZ = newPosZ;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE_OBJ__POS_Z, oldPosZ, posZ));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getRed() {
        return red;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRed(int newRed) {
        int oldRed = red;
        red = newRed;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE_OBJ__RED, oldRed, red));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getGreen() {
        return green;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGreen(int newGreen) {
        int oldGreen = green;
        green = newGreen;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE_OBJ__GREEN, oldGreen, green));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getBlue() {
        return blue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBlue(int newBlue) {
        int oldBlue = blue;
        blue = newBlue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE_OBJ__BLUE, oldBlue, blue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE_OBJ__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getOpacity() {
        return opacity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOpacity(int newOpacity) {
        int oldOpacity = opacity;
        opacity = newOpacity;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.SCENE_OBJ__OPACITY, oldOpacity, opacity));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CuboidModelerPackage.SCENE_OBJ__POS_X:
                return getPosX();
            case CuboidModelerPackage.SCENE_OBJ__POS_Y:
                return getPosY();
            case CuboidModelerPackage.SCENE_OBJ__POS_Z:
                return getPosZ();
            case CuboidModelerPackage.SCENE_OBJ__RED:
                return getRed();
            case CuboidModelerPackage.SCENE_OBJ__GREEN:
                return getGreen();
            case CuboidModelerPackage.SCENE_OBJ__BLUE:
                return getBlue();
            case CuboidModelerPackage.SCENE_OBJ__NAME:
                return getName();
            case CuboidModelerPackage.SCENE_OBJ__OPACITY:
                return getOpacity();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CuboidModelerPackage.SCENE_OBJ__POS_X:
                setPosX((Integer)newValue);
                return;
            case CuboidModelerPackage.SCENE_OBJ__POS_Y:
                setPosY((Integer)newValue);
                return;
            case CuboidModelerPackage.SCENE_OBJ__POS_Z:
                setPosZ((Integer)newValue);
                return;
            case CuboidModelerPackage.SCENE_OBJ__RED:
                setRed((Integer)newValue);
                return;
            case CuboidModelerPackage.SCENE_OBJ__GREEN:
                setGreen((Integer)newValue);
                return;
            case CuboidModelerPackage.SCENE_OBJ__BLUE:
                setBlue((Integer)newValue);
                return;
            case CuboidModelerPackage.SCENE_OBJ__NAME:
                setName((String)newValue);
                return;
            case CuboidModelerPackage.SCENE_OBJ__OPACITY:
                setOpacity((Integer)newValue);
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
            case CuboidModelerPackage.SCENE_OBJ__POS_X:
                setPosX(POS_X_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE_OBJ__POS_Y:
                setPosY(POS_Y_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE_OBJ__POS_Z:
                setPosZ(POS_Z_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE_OBJ__RED:
                setRed(RED_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE_OBJ__GREEN:
                setGreen(GREEN_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE_OBJ__BLUE:
                setBlue(BLUE_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE_OBJ__NAME:
                setName(NAME_EDEFAULT);
                return;
            case CuboidModelerPackage.SCENE_OBJ__OPACITY:
                setOpacity(OPACITY_EDEFAULT);
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
            case CuboidModelerPackage.SCENE_OBJ__POS_X:
                return posX != POS_X_EDEFAULT;
            case CuboidModelerPackage.SCENE_OBJ__POS_Y:
                return posY != POS_Y_EDEFAULT;
            case CuboidModelerPackage.SCENE_OBJ__POS_Z:
                return posZ != POS_Z_EDEFAULT;
            case CuboidModelerPackage.SCENE_OBJ__RED:
                return red != RED_EDEFAULT;
            case CuboidModelerPackage.SCENE_OBJ__GREEN:
                return green != GREEN_EDEFAULT;
            case CuboidModelerPackage.SCENE_OBJ__BLUE:
                return blue != BLUE_EDEFAULT;
            case CuboidModelerPackage.SCENE_OBJ__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case CuboidModelerPackage.SCENE_OBJ__OPACITY:
                return opacity != OPACITY_EDEFAULT;
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
        result.append(" (posX: ");
        result.append(posX);
        result.append(", posY: ");
        result.append(posY);
        result.append(", posZ: ");
        result.append(posZ);
        result.append(", red: ");
        result.append(red);
        result.append(", green: ");
        result.append(green);
        result.append(", blue: ");
        result.append(blue);
        result.append(", name: ");
        result.append(name);
        result.append(", opacity: ");
        result.append(opacity);
        result.append(')');
        return result.toString();
    }

} //SceneObjImpl
