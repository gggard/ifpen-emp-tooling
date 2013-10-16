/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid.util;

import fr.ifpen.emptooling.samples.cuboid.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage
 * @generated
 */
public class CuboidModelerAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static CuboidModelerPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CuboidModelerAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = CuboidModelerPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CuboidModelerSwitch<Adapter> modelSwitch =
        new CuboidModelerSwitch<Adapter>() {
            @Override
            public Adapter caseScene(Scene object) {
                return createSceneAdapter();
            }
            @Override
            public Adapter caseCuboid(Cuboid object) {
                return createCuboidAdapter();
            }
            @Override
            public Adapter caseSceneObj(SceneObj object) {
                return createSceneObjAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link fr.ifpen.emptooling.samples.cuboid.Scene <em>Scene</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene
     * @generated
     */
    public Adapter createSceneAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.ifpen.emptooling.samples.cuboid.Cuboid <em>Cuboid</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see fr.ifpen.emptooling.samples.cuboid.Cuboid
     * @generated
     */
    public Adapter createCuboidAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj <em>Scene Obj</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj
     * @generated
     */
    public Adapter createSceneObjAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //CuboidModelerAdapterFactory
