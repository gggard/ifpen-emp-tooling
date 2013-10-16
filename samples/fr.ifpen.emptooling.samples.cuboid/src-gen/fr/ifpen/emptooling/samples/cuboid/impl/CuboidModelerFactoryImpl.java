/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid.impl;

import fr.ifpen.emptooling.samples.cuboid.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CuboidModelerFactoryImpl extends EFactoryImpl implements CuboidModelerFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CuboidModelerFactory init() {
        try {
            CuboidModelerFactory theCuboidModelerFactory = (CuboidModelerFactory)EPackage.Registry.INSTANCE.getEFactory("http://fr.ifpen.emptooling.samples.cuboid/1.0/"); 
            if (theCuboidModelerFactory != null) {
                return theCuboidModelerFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CuboidModelerFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CuboidModelerFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case CuboidModelerPackage.SCENE: return createScene();
            case CuboidModelerPackage.CUBOID: return createCuboid();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Scene createScene() {
        SceneImpl scene = new SceneImpl();
        return scene;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cuboid createCuboid() {
        CuboidImpl cuboid = new CuboidImpl();
        return cuboid;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CuboidModelerPackage getCuboidModelerPackage() {
        return (CuboidModelerPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CuboidModelerPackage getPackage() {
        return CuboidModelerPackage.eINSTANCE;
    }

} //CuboidModelerFactoryImpl
