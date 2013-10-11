/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage
 * @generated
 */
public interface CuboidModelerFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CuboidModelerFactory eINSTANCE = fr.ifpen.emptooling.samples.cuboid.impl.CuboidModelerFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Scene</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Scene</em>'.
     * @generated
     */
    Scene createScene();

    /**
     * Returns a new object of class '<em>Cuboid</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Cuboid</em>'.
     * @generated
     */
    Cuboid createCuboid();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    CuboidModelerPackage getCuboidModelerPackage();

} //CuboidModelerFactory
