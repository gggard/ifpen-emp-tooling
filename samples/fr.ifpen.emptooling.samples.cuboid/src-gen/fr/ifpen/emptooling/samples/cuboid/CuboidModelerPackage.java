/**
 * Copyright IFP Energies nouvelles (c) 2012
 */
package fr.ifpen.emptooling.samples.cuboid;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.ifpen.emptooling.samples.cuboid.CuboidModelerFactory
 * @model kind="package"
 * @generated
 */
public interface CuboidModelerPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "cuboid";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://fr.ifpen.emptooling.samples.cuboid/1.0/";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "Cuboid";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CuboidModelerPackage eINSTANCE = fr.ifpen.emptooling.samples.cuboid.impl.CuboidModelerPackageImpl.init();

    /**
     * The meta object id for the '{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl <em>Scene</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl
     * @see fr.ifpen.emptooling.samples.cuboid.impl.CuboidModelerPackageImpl#getScene()
     * @generated
     */
    int SCENE = 0;

    /**
     * The feature id for the '<em><b>Cubes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__CUBES = 0;

    /**
     * The feature id for the '<em><b>Rotation X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__ROTATION_X = 1;

    /**
     * The feature id for the '<em><b>Translation X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__TRANSLATION_X = 2;

    /**
     * The feature id for the '<em><b>Translation Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__TRANSLATION_Y = 3;

    /**
     * The feature id for the '<em><b>Translation Z</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__TRANSLATION_Z = 4;

    /**
     * The feature id for the '<em><b>Rotation Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__ROTATION_Y = 5;

    /**
     * The feature id for the '<em><b>Rotation Z</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__ROTATION_Z = 6;

    /**
     * The feature id for the '<em><b>Rotate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__ROTATE = 7;

    /**
     * The feature id for the '<em><b>Show Wires</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__SHOW_WIRES = 8;

    /**
     * The feature id for the '<em><b>Show Faces</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE__SHOW_FACES = 9;

    /**
     * The number of structural features of the '<em>Scene</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_FEATURE_COUNT = 10;

    /**
     * The meta object id for the '{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl <em>Scene Obj</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl
     * @see fr.ifpen.emptooling.samples.cuboid.impl.CuboidModelerPackageImpl#getSceneObj()
     * @generated
     */
    int SCENE_OBJ = 2;

    /**
     * The feature id for the '<em><b>Pos X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_OBJ__POS_X = 0;

    /**
     * The feature id for the '<em><b>Pos Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_OBJ__POS_Y = 1;

    /**
     * The feature id for the '<em><b>Pos Z</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_OBJ__POS_Z = 2;

    /**
     * The feature id for the '<em><b>Red</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_OBJ__RED = 3;

    /**
     * The feature id for the '<em><b>Green</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_OBJ__GREEN = 4;

    /**
     * The feature id for the '<em><b>Blue</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_OBJ__BLUE = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_OBJ__NAME = 6;

    /**
     * The feature id for the '<em><b>Opacity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_OBJ__OPACITY = 7;

    /**
     * The number of structural features of the '<em>Scene Obj</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCENE_OBJ_FEATURE_COUNT = 8;

    /**
     * The meta object id for the '{@link fr.ifpen.emptooling.samples.cuboid.impl.CuboidImpl <em>Cuboid</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.ifpen.emptooling.samples.cuboid.impl.CuboidImpl
     * @see fr.ifpen.emptooling.samples.cuboid.impl.CuboidModelerPackageImpl#getCuboid()
     * @generated
     */
    int CUBOID = 1;

    /**
     * The feature id for the '<em><b>Pos X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__POS_X = SCENE_OBJ__POS_X;

    /**
     * The feature id for the '<em><b>Pos Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__POS_Y = SCENE_OBJ__POS_Y;

    /**
     * The feature id for the '<em><b>Pos Z</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__POS_Z = SCENE_OBJ__POS_Z;

    /**
     * The feature id for the '<em><b>Red</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__RED = SCENE_OBJ__RED;

    /**
     * The feature id for the '<em><b>Green</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__GREEN = SCENE_OBJ__GREEN;

    /**
     * The feature id for the '<em><b>Blue</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__BLUE = SCENE_OBJ__BLUE;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__NAME = SCENE_OBJ__NAME;

    /**
     * The feature id for the '<em><b>Opacity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__OPACITY = SCENE_OBJ__OPACITY;

    /**
     * The feature id for the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__LENGTH = SCENE_OBJ_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__HEIGHT = SCENE_OBJ_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Depth</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID__DEPTH = SCENE_OBJ_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Cuboid</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUBOID_FEATURE_COUNT = SCENE_OBJ_FEATURE_COUNT + 3;


    /**
     * Returns the meta object for class '{@link fr.ifpen.emptooling.samples.cuboid.Scene <em>Scene</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Scene</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene
     * @generated
     */
    EClass getScene();

    /**
     * Returns the meta object for the containment reference list '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getCubes <em>Cubes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Cubes</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#getCubes()
     * @see #getScene()
     * @generated
     */
    EReference getScene_Cubes();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getRotationX <em>Rotation X</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rotation X</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#getRotationX()
     * @see #getScene()
     * @generated
     */
    EAttribute getScene_RotationX();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationX <em>Translation X</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Translation X</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationX()
     * @see #getScene()
     * @generated
     */
    EAttribute getScene_TranslationX();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationY <em>Translation Y</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Translation Y</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationY()
     * @see #getScene()
     * @generated
     */
    EAttribute getScene_TranslationY();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationZ <em>Translation Z</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Translation Z</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#getTranslationZ()
     * @see #getScene()
     * @generated
     */
    EAttribute getScene_TranslationZ();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getRotationY <em>Rotation Y</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rotation Y</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#getRotationY()
     * @see #getScene()
     * @generated
     */
    EAttribute getScene_RotationY();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Scene#getRotationZ <em>Rotation Z</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rotation Z</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#getRotationZ()
     * @see #getScene()
     * @generated
     */
    EAttribute getScene_RotationZ();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Scene#isRotate <em>Rotate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rotate</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#isRotate()
     * @see #getScene()
     * @generated
     */
    EAttribute getScene_Rotate();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Scene#isShowWires <em>Show Wires</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Show Wires</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#isShowWires()
     * @see #getScene()
     * @generated
     */
    EAttribute getScene_ShowWires();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Scene#isShowFaces <em>Show Faces</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Show Faces</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Scene#isShowFaces()
     * @see #getScene()
     * @generated
     */
    EAttribute getScene_ShowFaces();

    /**
     * Returns the meta object for class '{@link fr.ifpen.emptooling.samples.cuboid.Cuboid <em>Cuboid</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cuboid</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Cuboid
     * @generated
     */
    EClass getCuboid();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Cuboid#getLength <em>Length</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Length</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Cuboid#getLength()
     * @see #getCuboid()
     * @generated
     */
    EAttribute getCuboid_Length();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Cuboid#getHeight <em>Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Height</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Cuboid#getHeight()
     * @see #getCuboid()
     * @generated
     */
    EAttribute getCuboid_Height();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.Cuboid#getDepth <em>Depth</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Depth</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.Cuboid#getDepth()
     * @see #getCuboid()
     * @generated
     */
    EAttribute getCuboid_Depth();

    /**
     * Returns the meta object for class '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj <em>Scene Obj</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Scene Obj</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj
     * @generated
     */
    EClass getSceneObj();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj#getPosX <em>Pos X</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pos X</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj#getPosX()
     * @see #getSceneObj()
     * @generated
     */
    EAttribute getSceneObj_PosX();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj#getPosY <em>Pos Y</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pos Y</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj#getPosY()
     * @see #getSceneObj()
     * @generated
     */
    EAttribute getSceneObj_PosY();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj#getPosZ <em>Pos Z</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pos Z</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj#getPosZ()
     * @see #getSceneObj()
     * @generated
     */
    EAttribute getSceneObj_PosZ();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj#getRed <em>Red</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Red</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj#getRed()
     * @see #getSceneObj()
     * @generated
     */
    EAttribute getSceneObj_Red();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj#getGreen <em>Green</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Green</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj#getGreen()
     * @see #getSceneObj()
     * @generated
     */
    EAttribute getSceneObj_Green();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj#getBlue <em>Blue</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Blue</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj#getBlue()
     * @see #getSceneObj()
     * @generated
     */
    EAttribute getSceneObj_Blue();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj#getName()
     * @see #getSceneObj()
     * @generated
     */
    EAttribute getSceneObj_Name();

    /**
     * Returns the meta object for the attribute '{@link fr.ifpen.emptooling.samples.cuboid.SceneObj#getOpacity <em>Opacity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Opacity</em>'.
     * @see fr.ifpen.emptooling.samples.cuboid.SceneObj#getOpacity()
     * @see #getSceneObj()
     * @generated
     */
    EAttribute getSceneObj_Opacity();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CuboidModelerFactory getCuboidModelerFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl <em>Scene</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see fr.ifpen.emptooling.samples.cuboid.impl.SceneImpl
         * @see fr.ifpen.emptooling.samples.cuboid.impl.CuboidModelerPackageImpl#getScene()
         * @generated
         */
        EClass SCENE = eINSTANCE.getScene();

        /**
         * The meta object literal for the '<em><b>Cubes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCENE__CUBES = eINSTANCE.getScene_Cubes();

        /**
         * The meta object literal for the '<em><b>Rotation X</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE__ROTATION_X = eINSTANCE.getScene_RotationX();

        /**
         * The meta object literal for the '<em><b>Translation X</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE__TRANSLATION_X = eINSTANCE.getScene_TranslationX();

        /**
         * The meta object literal for the '<em><b>Translation Y</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE__TRANSLATION_Y = eINSTANCE.getScene_TranslationY();

        /**
         * The meta object literal for the '<em><b>Translation Z</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE__TRANSLATION_Z = eINSTANCE.getScene_TranslationZ();

        /**
         * The meta object literal for the '<em><b>Rotation Y</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE__ROTATION_Y = eINSTANCE.getScene_RotationY();

        /**
         * The meta object literal for the '<em><b>Rotation Z</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE__ROTATION_Z = eINSTANCE.getScene_RotationZ();

        /**
         * The meta object literal for the '<em><b>Rotate</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE__ROTATE = eINSTANCE.getScene_Rotate();

        /**
         * The meta object literal for the '<em><b>Show Wires</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE__SHOW_WIRES = eINSTANCE.getScene_ShowWires();

        /**
         * The meta object literal for the '<em><b>Show Faces</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE__SHOW_FACES = eINSTANCE.getScene_ShowFaces();

        /**
         * The meta object literal for the '{@link fr.ifpen.emptooling.samples.cuboid.impl.CuboidImpl <em>Cuboid</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see fr.ifpen.emptooling.samples.cuboid.impl.CuboidImpl
         * @see fr.ifpen.emptooling.samples.cuboid.impl.CuboidModelerPackageImpl#getCuboid()
         * @generated
         */
        EClass CUBOID = eINSTANCE.getCuboid();

        /**
         * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CUBOID__LENGTH = eINSTANCE.getCuboid_Length();

        /**
         * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CUBOID__HEIGHT = eINSTANCE.getCuboid_Height();

        /**
         * The meta object literal for the '<em><b>Depth</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CUBOID__DEPTH = eINSTANCE.getCuboid_Depth();

        /**
         * The meta object literal for the '{@link fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl <em>Scene Obj</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see fr.ifpen.emptooling.samples.cuboid.impl.SceneObjImpl
         * @see fr.ifpen.emptooling.samples.cuboid.impl.CuboidModelerPackageImpl#getSceneObj()
         * @generated
         */
        EClass SCENE_OBJ = eINSTANCE.getSceneObj();

        /**
         * The meta object literal for the '<em><b>Pos X</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE_OBJ__POS_X = eINSTANCE.getSceneObj_PosX();

        /**
         * The meta object literal for the '<em><b>Pos Y</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE_OBJ__POS_Y = eINSTANCE.getSceneObj_PosY();

        /**
         * The meta object literal for the '<em><b>Pos Z</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE_OBJ__POS_Z = eINSTANCE.getSceneObj_PosZ();

        /**
         * The meta object literal for the '<em><b>Red</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE_OBJ__RED = eINSTANCE.getSceneObj_Red();

        /**
         * The meta object literal for the '<em><b>Green</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE_OBJ__GREEN = eINSTANCE.getSceneObj_Green();

        /**
         * The meta object literal for the '<em><b>Blue</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE_OBJ__BLUE = eINSTANCE.getSceneObj_Blue();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE_OBJ__NAME = eINSTANCE.getSceneObj_Name();

        /**
         * The meta object literal for the '<em><b>Opacity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCENE_OBJ__OPACITY = eINSTANCE.getSceneObj_Opacity();

    }

} //CuboidModelerPackage
