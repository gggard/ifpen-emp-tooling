/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid.impl;

import fr.ifpen.emptooling.samples.cuboid.Cuboid;
import fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cuboid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.CuboidImpl#getLength <em>Length</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.CuboidImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link fr.ifpen.emptooling.samples.cuboid.impl.CuboidImpl#getDepth <em>Depth</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CuboidImpl extends SceneObjImpl implements Cuboid {
    /**
     * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
    protected static final int LENGTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
    protected int length = LENGTH_EDEFAULT;

    /**
     * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected static final int HEIGHT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected int height = HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #getDepth() <em>Depth</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDepth()
     * @generated
     * @ordered
     */
    protected static final int DEPTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDepth() <em>Depth</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDepth()
     * @generated
     * @ordered
     */
    protected int depth = DEPTH_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CuboidImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CuboidModelerPackage.Literals.CUBOID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getLength() {
        return length;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLength(int newLength) {
        int oldLength = length;
        length = newLength;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.CUBOID__LENGTH, oldLength, length));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getHeight() {
        return height;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHeight(int newHeight) {
        int oldHeight = height;
        height = newHeight;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.CUBOID__HEIGHT, oldHeight, height));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getDepth() {
        return depth;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDepth(int newDepth) {
        int oldDepth = depth;
        depth = newDepth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CuboidModelerPackage.CUBOID__DEPTH, oldDepth, depth));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CuboidModelerPackage.CUBOID__LENGTH:
                return getLength();
            case CuboidModelerPackage.CUBOID__HEIGHT:
                return getHeight();
            case CuboidModelerPackage.CUBOID__DEPTH:
                return getDepth();
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
            case CuboidModelerPackage.CUBOID__LENGTH:
                setLength((Integer)newValue);
                return;
            case CuboidModelerPackage.CUBOID__HEIGHT:
                setHeight((Integer)newValue);
                return;
            case CuboidModelerPackage.CUBOID__DEPTH:
                setDepth((Integer)newValue);
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
            case CuboidModelerPackage.CUBOID__LENGTH:
                setLength(LENGTH_EDEFAULT);
                return;
            case CuboidModelerPackage.CUBOID__HEIGHT:
                setHeight(HEIGHT_EDEFAULT);
                return;
            case CuboidModelerPackage.CUBOID__DEPTH:
                setDepth(DEPTH_EDEFAULT);
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
            case CuboidModelerPackage.CUBOID__LENGTH:
                return length != LENGTH_EDEFAULT;
            case CuboidModelerPackage.CUBOID__HEIGHT:
                return height != HEIGHT_EDEFAULT;
            case CuboidModelerPackage.CUBOID__DEPTH:
                return depth != DEPTH_EDEFAULT;
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
        result.append(" (length: ");
        result.append(length);
        result.append(", height: ");
        result.append(height);
        result.append(", depth: ");
        result.append(depth);
        result.append(')');
        return result.toString();
    }

} //CuboidImpl
