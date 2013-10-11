/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid.impl;

import fr.ifpen.emptooling.samples.cuboid.Cuboid;
import fr.ifpen.emptooling.samples.cuboid.CuboidModelerFactory;
import fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage;
import fr.ifpen.emptooling.samples.cuboid.Scene;
import fr.ifpen.emptooling.samples.cuboid.SceneObj;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CuboidModelerPackageImpl extends EPackageImpl implements CuboidModelerPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sceneEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cuboidEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sceneObjEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CuboidModelerPackageImpl() {
        super(eNS_URI, CuboidModelerFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link CuboidModelerPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CuboidModelerPackage init() {
        if (isInited) return (CuboidModelerPackage)EPackage.Registry.INSTANCE.getEPackage(CuboidModelerPackage.eNS_URI);

        // Obtain or create and register package
        CuboidModelerPackageImpl theCuboidModelerPackage = (CuboidModelerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CuboidModelerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CuboidModelerPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theCuboidModelerPackage.createPackageContents();

        // Initialize created meta-data
        theCuboidModelerPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCuboidModelerPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(CuboidModelerPackage.eNS_URI, theCuboidModelerPackage);
        return theCuboidModelerPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScene() {
        return sceneEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScene_Cubes() {
        return (EReference)sceneEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_RotationX() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_TranslationX() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_TranslationY() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_TranslationZ() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_RotationY() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_RotationZ() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_Rotate() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_ShowWires() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScene_ShowFaces() {
        return (EAttribute)sceneEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCuboid() {
        return cuboidEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCuboid_Length() {
        return (EAttribute)cuboidEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCuboid_Height() {
        return (EAttribute)cuboidEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCuboid_Depth() {
        return (EAttribute)cuboidEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSceneObj() {
        return sceneObjEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSceneObj_PosX() {
        return (EAttribute)sceneObjEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSceneObj_PosY() {
        return (EAttribute)sceneObjEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSceneObj_PosZ() {
        return (EAttribute)sceneObjEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSceneObj_Red() {
        return (EAttribute)sceneObjEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSceneObj_Green() {
        return (EAttribute)sceneObjEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSceneObj_Blue() {
        return (EAttribute)sceneObjEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSceneObj_Name() {
        return (EAttribute)sceneObjEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSceneObj_Opacity() {
        return (EAttribute)sceneObjEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CuboidModelerFactory getCuboidModelerFactory() {
        return (CuboidModelerFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        sceneEClass = createEClass(SCENE);
        createEReference(sceneEClass, SCENE__CUBES);
        createEAttribute(sceneEClass, SCENE__ROTATION_X);
        createEAttribute(sceneEClass, SCENE__TRANSLATION_X);
        createEAttribute(sceneEClass, SCENE__TRANSLATION_Y);
        createEAttribute(sceneEClass, SCENE__TRANSLATION_Z);
        createEAttribute(sceneEClass, SCENE__ROTATION_Y);
        createEAttribute(sceneEClass, SCENE__ROTATION_Z);
        createEAttribute(sceneEClass, SCENE__ROTATE);
        createEAttribute(sceneEClass, SCENE__SHOW_WIRES);
        createEAttribute(sceneEClass, SCENE__SHOW_FACES);

        cuboidEClass = createEClass(CUBOID);
        createEAttribute(cuboidEClass, CUBOID__LENGTH);
        createEAttribute(cuboidEClass, CUBOID__HEIGHT);
        createEAttribute(cuboidEClass, CUBOID__DEPTH);

        sceneObjEClass = createEClass(SCENE_OBJ);
        createEAttribute(sceneObjEClass, SCENE_OBJ__POS_X);
        createEAttribute(sceneObjEClass, SCENE_OBJ__POS_Y);
        createEAttribute(sceneObjEClass, SCENE_OBJ__POS_Z);
        createEAttribute(sceneObjEClass, SCENE_OBJ__RED);
        createEAttribute(sceneObjEClass, SCENE_OBJ__GREEN);
        createEAttribute(sceneObjEClass, SCENE_OBJ__BLUE);
        createEAttribute(sceneObjEClass, SCENE_OBJ__NAME);
        createEAttribute(sceneObjEClass, SCENE_OBJ__OPACITY);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        cuboidEClass.getESuperTypes().add(this.getSceneObj());

        // Initialize classes and features; add operations and parameters
        initEClass(sceneEClass, Scene.class, "Scene", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getScene_Cubes(), this.getCuboid(), null, "cubes", null, 0, -1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScene_RotationX(), ecorePackage.getEFloat(), "rotationX", null, 1, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScene_TranslationX(), ecorePackage.getEInt(), "translationX", null, 1, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScene_TranslationY(), ecorePackage.getEInt(), "translationY", null, 1, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScene_TranslationZ(), ecorePackage.getEInt(), "translationZ", "-10", 1, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScene_RotationY(), ecorePackage.getEFloat(), "rotationY", null, 1, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScene_RotationZ(), ecorePackage.getEFloat(), "rotationZ", null, 1, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScene_Rotate(), ecorePackage.getEBoolean(), "rotate", "true", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScene_ShowWires(), ecorePackage.getEBoolean(), "showWires", "true", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScene_ShowFaces(), ecorePackage.getEBoolean(), "showFaces", "true", 0, 1, Scene.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(cuboidEClass, Cuboid.class, "Cuboid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCuboid_Length(), ecorePackage.getEInt(), "length", null, 1, 1, Cuboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCuboid_Height(), ecorePackage.getEInt(), "height", null, 1, 1, Cuboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCuboid_Depth(), ecorePackage.getEInt(), "depth", null, 1, 1, Cuboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(sceneObjEClass, SceneObj.class, "SceneObj", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSceneObj_PosX(), ecorePackage.getEInt(), "posX", null, 1, 1, SceneObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSceneObj_PosY(), ecorePackage.getEInt(), "posY", null, 1, 1, SceneObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSceneObj_PosZ(), ecorePackage.getEInt(), "posZ", null, 1, 1, SceneObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSceneObj_Red(), ecorePackage.getEInt(), "red", null, 1, 1, SceneObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSceneObj_Green(), ecorePackage.getEInt(), "green", null, 1, 1, SceneObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSceneObj_Blue(), ecorePackage.getEInt(), "blue", null, 1, 1, SceneObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSceneObj_Name(), ecorePackage.getEString(), "name", null, 1, 1, SceneObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSceneObj_Opacity(), ecorePackage.getEInt(), "opacity", null, 1, 1, SceneObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //CuboidModelerPackageImpl
