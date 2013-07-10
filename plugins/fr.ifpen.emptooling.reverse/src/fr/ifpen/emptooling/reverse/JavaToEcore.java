/**
 * <copyright>
 *
 * Copyright (c) 2012-2013 IFPEN and Obeo.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   Obeo - Initial API and implementation.
 *   IFPEN - Extending Java Compliance.
 *
 * </copyright>
 *
 */
package fr.ifpen.emptooling.reverse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;

import fr.ifpen.emptooling.reverse.ReverseSettings.PackageSettings;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @author <a href="mailto:sebastien.schneider@ifpen.fr">Sebastien Schneider</a>
 */
public class JavaToEcore {

    private ReverseSettings params;

    private IJavaProject project;

    private List<IPackageFragment> packages;

    private Map<String, EClassifier> eClassesAdded = new HashMap<String, EClassifier>();

    private Map<IType, EClassifier> eTypesAdded = new HashMap<IType, EClassifier>();

    /* Map of own DataTypes already added to the metamodel */
    private Map<String, EDataType> eArrayDataTypesAdded = new HashMap<String, EDataType>();

    /* Mapping between JDT Basic Types and ECore Basic Data Types */
    private Map<String, EDataType> eBasicTypes = new HashMap<String, EDataType>();

    /* Mapping between JDT Types and Java Types */
    private Map<String, String> eJavaPrimitiveTypes = new HashMap<String, String>();

    private EPackage eProject;

    private List<String> errorLog = new ArrayList<String>();

    private List<String> getterLog = new ArrayList<String>();

    private List<String> enumLog = new ArrayList<String>();

    private ResourceSet resourceSetLibraries;

    private final EcorePackage ePackage;

    private final EcoreFactory eFactory;

    private final String packageDataTypesName = "dataTypes";

    public static final String MODEL_EXTENSION_POINT_ID = "fr.ifpen.atelier.model";

    /**
     * @param project
     * @throws IOException
     * @throws JavaModelException
     */
    public JavaToEcore(IJavaProject project, ReverseSettings params) throws IOException,
            JavaModelException {
        this(project, Collections.<IPackageFragment> emptyList(), params);
    }

    /**
     * @param javaProject
     * @param javaPackages
     * @throws IOException
     * @throws JavaModelException
     */
    public JavaToEcore(IJavaProject javaProject, List<IPackageFragment> javaPackages,
            ReverseSettings params) throws IOException, JavaModelException {
        this.params = params;
        project = javaProject;
        packages = javaPackages;
        ePackage = EcorePackage.eINSTANCE;
        eFactory = EcoreFactory.eINSTANCE;
        resourceSetLibraries = new ResourceSetImpl();

        IConfigurationElement[] configurationElementsFor = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(MODEL_EXTENSION_POINT_ID);
        for (IConfigurationElement element : configurationElementsFor) {
            URI uri = URI.createPlatformPluginURI(element.getAttribute("URI"), true);
            resourceSetLibraries.getResource(uri, true);
        }

        eBasicTypes.put("B", ePackage.getEByte());
        eBasicTypes.put("C", ePackage.getEChar());
        eBasicTypes.put("D", ePackage.getEDouble());
        eBasicTypes.put("F", ePackage.getEFloat());
        eBasicTypes.put("I", ePackage.getEInt());
        eBasicTypes.put("J", ePackage.getELong());
        eBasicTypes.put("S", ePackage.getEShort());
        eBasicTypes.put("Z", ePackage.getEBoolean());
        eBasicTypes.put("QString;", ePackage.getEString());
        eBasicTypes.put("String", ePackage.getEString());
        eBasicTypes.put("QObject;", ePackage.getEJavaObject());
        eBasicTypes.put("Object", ePackage.getEJavaObject());
        eBasicTypes.put("QClass;", ePackage.getEJavaClass());
        eBasicTypes.put("QClass<*>;", ePackage.getEJavaClass());
        eBasicTypes.put("QDate;", ePackage.getEDate());
        eBasicTypes.put("Date", ePackage.getEDate());
        eBasicTypes.put("QInteger;", ePackage.getEIntegerObject());
        eBasicTypes.put("Integer", ePackage.getEIntegerObject());
        eBasicTypes.put("QLong;", ePackage.getELongObject());
        eBasicTypes.put("Long", ePackage.getELongObject());
        eBasicTypes.put("QShort;", ePackage.getEShortObject());
        eBasicTypes.put("Short", ePackage.getEShortObject());
        eBasicTypes.put("QFloat;", ePackage.getEFloatObject());
        eBasicTypes.put("Float", ePackage.getEFloatObject());
        eBasicTypes.put("QDouble;", ePackage.getEDoubleObject());
        eBasicTypes.put("Double", ePackage.getEDoubleObject());
        eBasicTypes.put("QByte;", ePackage.getEByteObject());
        eBasicTypes.put("Byte", ePackage.getEByteObject());
        eBasicTypes.put("QBoolean;", ePackage.getEBooleanObject());
        eBasicTypes.put("Boolean", ePackage.getEBooleanObject());

        eJavaPrimitiveTypes.put("B", "byte");
        eJavaPrimitiveTypes.put("C", "char");
        eJavaPrimitiveTypes.put("D", "double");
        eJavaPrimitiveTypes.put("F", "float");
        eJavaPrimitiveTypes.put("I", "int");
        eJavaPrimitiveTypes.put("J", "long");
        eJavaPrimitiveTypes.put("S", "short");
        eJavaPrimitiveTypes.put("Z", "boolean");
    }

    /**
     * Reverse the java project into an EcoreModel.
     * 
     * @return the {@link EPackage} corresponding to the java project parsed.
     * @throws JavaModelException
     * @throws InterruptedException
     * @throws InvocationTargetException
     */
    public EPackage reverse(IProgressMonitor monitor) throws JavaModelException {
        monitor.beginTask("Java to Ecore reverse processing ...", IProgressMonitor.UNKNOWN);
        String projectName = project.getElementName();
        logEntry(errorLog, "[" + Calendar.getInstance().getTime() + "] " + "Start parsing for : "
                + projectName);
        logEntry(errorLog, "File Name;Field/Type Name;Error Type;Unresolved Type");
        logEntry(getterLog, "[" + Calendar.getInstance().getTime() + "] "
                + "List of getter annotations for : " + projectName);
        logEntry(getterLog, "File Name;Field Name");
        logEntry(enumLog, "[" + Calendar.getInstance().getTime() + "] "
                + "List of enum annotations for : " + projectName);
        logEntry(enumLog, "File Name;Field Name");

        eProject = eFactory.createEPackage();
        eProject.setName(params.rootPackageName);
        eProject.setNsPrefix(params.rootNsPrefix);
        eProject.setNsURI(params.rootNsURI);

        // IJavaProject project = JavaCore.create(project);
        if (packages.isEmpty()) {
            packages = Arrays.asList(project.getPackageFragments());
        }
        Collections.sort(packages, new Comparator<IPackageFragment>() {
            public int compare(IPackageFragment p1, IPackageFragment p2) {
                return p1.getElementName().compareTo(p2.getElementName());
            }
        });

        for (IPackageFragment mypackage : packages) {
            if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE && mypackage.hasChildren()) {
                EPackage processPackage = processPackage(mypackage);
                eProject.getESubpackages().add(processPackage);
            }
        }

        for (Entry<IType, EClassifier> entry : eTypesAdded.entrySet()) {
            IType iType = entry.getKey();
            EClassifier eClassifier = entry.getValue();
            if (eClassifier instanceof EClass) {
                /* Post-processing to resolve super-classes references */
                postProcessType(iType, (EClass) eClassifier);
                /* Process all fields of IType */
                processFields(iType, (EClass) eClassifier);
            }
            else if (eClassifier instanceof EEnum) {
                processLiterals(iType, (EEnum) eClassifier);
            }
        }

        logEntry(errorLog, "[" + Calendar.getInstance().getTime() + "] " + "End of parsing for : "
                + projectName);
        logEntry(getterLog, "[" + Calendar.getInstance().getTime() + "] "
                + "End of list of getter annotations for : " + projectName);
        monitor.done();
        return eProject;
    }

    /**
     * Process (creates {@link EPackage} and {@link EClass}) for all java packages and classes.
     * 
     * @param package_
     * @return
     * @throws JavaModelException
     */
    protected EPackage processPackage(IPackageFragment package_) throws JavaModelException {
        PackageSettings packageParams = params.packageParams.get(package_.getElementName());

        // create and configure sub-package
        EPackage subPackage = packageParams.createEcorePackage();
        // process java source file from this package
        ICompilationUnit[] compilationUnits = package_.getCompilationUnits();
        List<ICompilationUnit> listOfCUs = Arrays.asList(compilationUnits);
        Collections.sort(listOfCUs, new Comparator<ICompilationUnit>() {
            public int compare(ICompilationUnit c1, ICompilationUnit c2) {
                return c1.getElementName().compareTo(c2.getElementName());
            }
        });
        for (ICompilationUnit compilationUnit : compilationUnits) {
            IType[] allTypes = compilationUnit.getAllTypes();
            for (IType iType : allTypes) {
                // do not process nested classes
                if (/*iType.isMember() ||*/iType.isLocal()) {
                    continue;
                }
                EClassifier clazz = preProcessType(iType);
                if (!(clazz instanceof EEnum)) {
                    subPackage.getEClassifiers().add(clazz);
                }
                eClassesAdded.put(iType.getFullyQualifiedName(), clazz);
                eTypesAdded.put(iType, clazz);
            }

        }
        return subPackage;
    }

    /**
     * Process (resolve types of all fields) for the given {@link IType}.
     * 
     * @param iType the given {@link IType} (a java Class).
     * @param clazz the associated {@link EClass}.
     * @throws JavaModelException
     */
    protected void processFields(IType iType, EClass clazz) throws JavaModelException {
        IField[] fields = iType.getFields();

        for (IField iField : fields) {
            EStructuralFeature feature;
            EClassifier ecoreType = processAttributeType(iField);

            if (isListEReference(iField)) {
                feature = eFactory.createEReference();
                feature.setUpperBound(-1);
                feature.setUnique(false);
                feature.setOrdered(true);
            }
            else if (isSetEReference(iField)) {
                feature = eFactory.createEReference();
                feature.setUpperBound(-1);
                feature.setUnique(true);
                feature.setOrdered(false);
            }
            else if (isSortedSetEReference(iField)) {
                feature = eFactory.createEReference();
                feature.setUpperBound(-1);
                feature.setUnique(true);
                feature.setOrdered(true);
            }
            else if (ecoreType instanceof EClass) {
                feature = eFactory.createEReference();
                feature.setLowerBound(1);
                feature.setUpperBound(1);
                feature.setUnique(true);
            }
            else if (ecoreType instanceof EEnum) {
                feature = eFactory.createEAttribute();
                feature.setLowerBound(1);
                // replace EEnum type by an EINT type
                ecoreType = EcorePackage.Literals.EINT;

                setEnumAnnotation(iField, feature);

                // feature.setEType(ecoreType);//FP
                // getConstant on non final field return a null string !
                // feature.setDefaultValue(iField.getConstant());//FP
            }
            else if (ecoreType instanceof EDataType) {
                feature = eFactory.createEAttribute();
                feature.setLowerBound(1);
            }
            else {
                feature = eFactory.createEAttribute();
                feature.setLowerBound(1);
                System.err.println("Passage anormal pour le reverse !!!!");
            }
            feature.setName(iField.getElementName());
            feature.setEType(ecoreType);

            // check flags for final static fields and transient fields
            int flags = iField.getFlags();
            if (Flags.isFinal(flags) && Flags.isStatic(flags)) {
                // a constant is not persistent and not changeable
                feature.setTransient(true);
                feature.setChangeable(false);
                // retrieve the value of this constant and set it to default feature value
                try {
                    feature.setDefaultValue(iField.getConstant());
                }
                catch (IllegalStateException e) {
                    // Cannot serialize value to object without an EDataType eType
                    // nevermind: do nothing more
                    System.err.println(e.getMessage() + " for constant " + feature.getName()
                            + " from class " + clazz.getName());
                }
            }
            // transient field or no typed field or set to transient
            if (Flags.isTransient(flags) || feature.getEType() == null) {
                feature.setTransient(true);
            }
            clazz.getEStructuralFeatures().add(feature);

            /* Add generic parameters in case of EMap */
            manageEMapParameters(iField, feature);

            /* Manage annotations but ignore transient fields */
            if (!feature.isTransient()) {
                manageGetterAnnotation(iField, iType, feature);
            }

        }
    }

    /**
     * Return the {@link EClassifier} for an {@link IType}.
     * 
     * @param iType the given {@link IType} (a java Class).
     * @return the {@link EClassifier} corresponding to the {@link IType}.
     * @throws JavaModelException
     */
    protected EClassifier preProcessType(IType iType) throws JavaModelException {
        EClassifier clazz = null;
        if (iType.isEnum()) {
            clazz = eFactory.createEEnum();
        }
        else {
            clazz = eFactory.createEClass();
            if (iType.isInterface()) {
                ((EClass) clazz).setInterface(true);
            }
        }
        clazz.setName(iType.getElementName());
        return clazz;
    }

    /**
     * Resolve the super type and interfaces of the given {@link EClass} (corresponding to the given
     * {@link IType}).
     * 
     * @param iType the given {@link IType}).
     * @param clazz the given {@link EClass}.
     * @throws JavaModelException
     */
    protected void postProcessType(IType iType, EClass clazz) throws JavaModelException {
        ITypeHierarchy hierarchy = iType.newSupertypeHierarchy(new NullProgressMonitor());
        IType superType = hierarchy.getSuperclass(iType);
        if (superType != null) {
            String superTypeFQN = superType.getFullyQualifiedName();
            if (!("java.lang.Object".equals(superTypeFQN) || "java.lang.Enum".equals(superTypeFQN))) {
                if (eClassesAdded.containsKey(superTypeFQN)) {
                    clazz.getESuperTypes().add((EClass) eClassesAdded.get(superTypeFQN));
                }
                else {
                    EClassifier eClassifier = getEClassifierInLibraries(superType.getElementName());
                    if (eClassifier != null && eClassifier instanceof EClass) {
                        clazz.getESuperTypes().add((EClass) eClassifier);
                    }
                    else {
                        logEntry(errorLog, iType.getCompilationUnit().getElementName() + ";"
                                + iType.getElementName() + ";unresolved super type;" + superTypeFQN);
                    }
                }
            }
        }

        List<IType> superInterfaces = Arrays.asList(hierarchy.getSuperInterfaces(iType));
        for (IType superInterface : superInterfaces) {
            String superInterfaceFQN = superInterface.getFullyQualifiedName();
            if (eClassesAdded.containsKey(superInterfaceFQN)) {
                clazz.getESuperTypes().add((EClass) eClassesAdded.get(superInterfaceFQN));
            }
            else {
                EClassifier eClassifier = getEClassifierInLibraries(superInterface.getElementName());
                if (eClassifier != null && eClassifier instanceof EClass) {
                    clazz.getESuperTypes().add((EClass) eClassifier);
                }
                else {
                    logEntry(
                            errorLog,
                            iType.getCompilationUnit().getElementName() + ";"
                                    + iType.getElementName() + ";unresolved interface;"
                                    + superInterfaceFQN);
                }
            }
        }
    }

    /**
     * Resolve the type of the given {@link IField} (corresponding to an {@link EAttribute}).
     * 
     * @param iField the given {@link IField}.
     * @return the type ({@link EClassifier}) of the given {@link IField}.
     * @throws JavaModelException
     */
    protected EClassifier processAttributeType(IField iField) throws JavaModelException {
        String type = iField.getTypeSignature();

        String extractType = extractType(type);
        String typeFQN = "";

        if (type.contains(".")) {
            typeFQN = extractType;
        }
        else {
            typeFQN = searchTypeInImportAndPackage(iField, extractType);
        }

        if (eBasicTypes.containsKey(type)) {
            return eBasicTypes.get(type);
        }
        else if (isJDTArrayPrimitiveType(type)) {
            return manageJDTArrayPrimitiveType(type);
        }
        else if (isJDTArrayType(type)) {
            return manageJDTArrayType(type);
        }
        else if (isJavaList(extractType)) {
            return manageCollectionType(extractType, iField);
        }
        else if (isJavaSet(extractType)) {
            return manageCollectionType(extractType, iField);
        }
        else if (isJavaSortedSet(extractType)) {
            return manageCollectionType(extractType, iField);
        }
        else if (isJavaMap(extractType)) {
            return ePackage.getEMap();
        }
        else if (isJavaSortedMap(extractType)) {
            return ePackage.getEMap();
        }
        else if (isJavaEnum(iField)) {
            IType iType = iField.getDeclaringType();
            IType enumType = iType.getType(Signature.getSignatureSimpleName(type));
            return eClassesAdded.get(enumType.getFullyQualifiedName());
        }
        else if (eClassesAdded.containsKey(typeFQN)) {
            return eClassesAdded.get(typeFQN);
        }
        else {
            EClassifier eClassifier = getEClassifierInLibraries(extractType);
            if (eClassifier != null) {
                return eClassifier;
            }
            else {
                logEntry(
                        errorLog,
                        iField.getCompilationUnit().getElementName() + ";"
                                + iField.getElementName() + ";unresolved type;" + typeFQN);
            }
        }

        return null;
    }

    /**
     * Process (resolve all literals) for the given {@link IType}.
     * 
     * @param iType the given {@link IType} (a java Enum).
     * @param eEnum the associated {@link EEnum}.
     * @throws JavaModelException
     */
    protected void processLiterals(IType iType, EEnum eEnum) throws JavaModelException {
        IField[] fields = iType.getFields();
        int i = 0;
        for (IField iField : fields) {
            if (iField.isEnumConstant()) {
                EEnumLiteral literal = eFactory.createEEnumLiteral();
                literal.setName(iField.getElementName());
                literal.setValue(i++);
                eEnum.getELiterals().add(literal);

            }
        }

    }

    /**
     * Search in the libraries if an {@link EClassifier} correspond to the given type.
     * 
     * @param extractType the given type as a String.
     * @return the {@link EClassifier} corresponding to the given type if found, null otherwise.
     */
    private EClassifier getEClassifierInLibraries(String extractType) {
        for (Resource r : resourceSetLibraries.getResources()) {
            if (r != null && !r.getContents().isEmpty()) {
                EObject o = r.getContents().get(0);
                for (Iterator<EObject> iterator = o.eAllContents(); iterator.hasNext();) {
                    EObject eObject = iterator.next();
                    if (eObject instanceof EClassifier) {
                        String eObjectClassName = ((EClassifier) eObject).getName();
                        if (eObjectClassName.equals(extractType)) {
                            return (EClassifier) eObject;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Return the {@link EClassifier} corresponding to the parameter of the given {@link IField}
     * (the given {@link IField} must be a java {@link Collection}).
     * 
     * @param type the given type.
     * @param iField the given {@link IField}.
     * @return the {@link EClassifier} corresponding to the parameter of the given {@link IField}
     *         (the given {@link IField} must be a java {@link Collection}).
     * @throws JavaModelException
     */
    private EClassifier manageCollectionType(String type, IField iField) throws JavaModelException {
        String[] parts = type.split("<Q|<|;>|>|;Q");
        String typeOfCollection = extractType(parts[1]);

        if (eBasicTypes.containsKey(typeOfCollection)) {
            return eBasicTypes.get(typeOfCollection);
        }
        else if ("Map".equalsIgnoreCase(typeOfCollection)
                || "SortedMap".equalsIgnoreCase(typeOfCollection)) {
            return ePackage.getEMap();
        }
        else {
            String typeOfCollectionFQN = searchTypeInImportAndPackage(iField, typeOfCollection);
            if (eClassesAdded.containsKey(typeOfCollectionFQN)) {
                return eClassesAdded.get(typeOfCollectionFQN);
            }
            else {
                EClassifier eClassifier = getEClassifierInLibraries(typeOfCollection);
                if (eClassifier != null) {
                    return eClassifier;
                }
                else {
                    logEntry(
                            errorLog,
                            iField.getCompilationUnit().getElementName() + ";"
                                    + iField.getElementName() + ";unresolved collection type;"
                                    + typeOfCollectionFQN);
                }
            }
        }

        return null;
    }

    /**
     * Add generic parameters in case of EMap.
     * 
     * @param iField the given {@link IField}.
     * @param feature the corresponding {@link EStructuralFeature}.
     * @throws JavaModelException
     */
    private void manageEMapParameters(IField iField, EStructuralFeature feature)
            throws JavaModelException {
        String typeSignature = iField.getTypeSignature();
        if (isJavaMap(typeSignature) || isJavaSortedMap(typeSignature)
                || isCollectionOfMap(typeSignature)) {
            EGenericType mapGenericType = feature.getEGenericType();
            mapGenericType.setEClassifier(ePackage.getEMap());
            EGenericType key = eFactory.createEGenericType();
            key.setEClassifier(getKeyFromMap(iField, typeSignature));
            mapGenericType.getETypeArguments().add(key);
            EGenericType value = eFactory.createEGenericType();
            value.setEClassifier(getValueFromMap(iField, typeSignature));
            mapGenericType.getETypeArguments().add(value);
            if (isJavaMap(typeSignature)) {
                feature.setOrdered(false);
            }
            else {
                feature.setOrdered(true);
            }
        }
    }

    /**
     * Check if the given type is a collection of java map.
     * 
     * @param typeSignature the given type as a String.
     * @return true if the given type is a collection of java map, false otherwise.
     */
    private boolean isCollectionOfMap(String typeSignature) {
        if (isJavaList(typeSignature) || isJavaSet(typeSignature) || isJavaSortedSet(typeSignature)) {
            String[] parts = typeSignature.split("<Q|;Q|;>|;");
            String mapPart = extractType(parts[1]);
            if ("Map".equalsIgnoreCase(mapPart)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the {@link EClassifier} corresponding to the value parameter of the given
     * {@link IField} (the given {@link IField} must be a java {@link Map}).
     * 
     * @param iField the given {@link IField}.
     * @param type the given type.
     * @return the {@link EClassifier} corresponding to the value parameter of the given
     *         {@link IField} (the given {@link IField} must be a java {@link Map}).
     * @throws JavaModelException
     */
    private EClassifier getValueFromMap(IField iField, String type) throws JavaModelException {
        String[] parts = type.split("<Q|;Q|;>|;");
        String value = "";
        if (isCollectionOfMap(type)) {
            value = extractType(parts[3]);
        }
        else {
            value = extractType(parts[2]);
        }
        if (eBasicTypes.containsKey(value)) {
            return eBasicTypes.get(value);
        }
        else {
            String typeOfCollectionFQN = searchTypeInImportAndPackage(iField, value);
            if (eClassesAdded.containsKey(typeOfCollectionFQN)) {
                return eClassesAdded.get(typeOfCollectionFQN);
            }
            else {
                EClassifier eClassifier = getEClassifierInLibraries(value);
                if (eClassifier != null) {
                    return eClassifier;
                }
                else {
                    logEntry(
                            errorLog,
                            iField.getCompilationUnit().getElementName() + ";"
                                    + iField.getElementName() + ";unresolved Map value type;"
                                    + typeOfCollectionFQN);
                }
            }
        }
        return null;
    }

    /**
     * Return the {@link EClassifier} corresponding to the key parameter of the given {@link IField}
     * (the given {@link IField} must be a java {@link Map} ).
     * 
     * @param iField the given {@link IField}.
     * @param type the given type.
     * @return the {@link EClassifier} corresponding to the key parameter of the given
     *         {@link IField} (the given {@link IField} must be a java {@link Map}).
     * @throws JavaModelException
     */
    private EClassifier getKeyFromMap(IField iField, String type) throws JavaModelException {
        String[] parts = type.split("<Q|;Q|;>|;");
        String key = "";
        if (isCollectionOfMap(type)) {
            key = extractType(parts[2]);
        }
        else {
            key = extractType(parts[1]);
        }
        if (eBasicTypes.containsKey(key)) {
            return eBasicTypes.get(key);
        }
        else {
            String typeOfCollectionFQN = searchTypeInImportAndPackage(iField, key);
            if (eClassesAdded.containsKey(typeOfCollectionFQN)) {
                return eClassesAdded.get(typeOfCollectionFQN);
            }
            else {
                EClassifier eClassifier = getEClassifierInLibraries(key);
                if (eClassifier != null) {
                    return eClassifier;
                }
                else {
                    logEntry(
                            errorLog,
                            iField.getCompilationUnit().getElementName() + ";"
                                    + iField.getElementName() + ";unresolved Map key type;"
                                    + typeOfCollectionFQN);
                }
            }
        }
        return null;
    }

    /**
     * Search the given type in imports of the file containing the given {@link IField} and in the
     * classes of the same package.
     * 
     * @param iField the given {@link IField}
     * @param type the given type.
     * @return the fully qualified name of the given type.
     * @throws JavaModelException
     */
    private String searchTypeInImportAndPackage(IField iField, String type)
            throws JavaModelException {
        String typeFQN = "";
        for (IImportDeclaration import_ : iField.getCompilationUnit().getImports()) {
            String importFQN = import_.getElementName();
            String[] importElements = importFQN.split("\\.");
            String importN = importElements[importElements.length - 1];
            if (type.equals(importN)) {
                typeFQN = importFQN;
                break;
            }
        }
        if (typeFQN.equals("")) {
            IJavaElement package_ = iField.getCompilationUnit().getParent();
            if (package_ instanceof IPackageFragment) {
                for (ICompilationUnit unit : ((IPackageFragment) package_).getCompilationUnits()) {
                    IType t = unit.getType(type);
                    if (t != null) {
                        typeFQN = t.getFullyQualifiedName();
                        break;
                    }
                }
            }
        }
        return typeFQN;
    }

    private boolean isListEReference(IField iField) throws JavaModelException {
        return isJavaList(extractType(iField.getTypeSignature()));
    }

    private boolean isSetEReference(IField iField) throws JavaModelException {
        return isJavaSet(extractType(iField.getTypeSignature()));
    }

    private boolean isSortedSetEReference(IField iField) throws JavaModelException {
        return isJavaSortedSet(extractType(iField.getTypeSignature()));
    }

    /**
     * Check if the given Java or JDT type is a List.
     * 
     * @param type the given Java or JDT type.
     * @return true if the given Java or JDT type is a List, false otherwise.
     */
    private boolean isJavaList(String type) {
        if (type.startsWith("List<") || type.startsWith("QList<")) {
            return true;
        }
        return false;
    }

    /**
     * Check if the given Java or JDT type is a Set.
     * 
     * @param type the given Java or JDT type.
     * @return true if the given Java or JDT type is a Set, false otherwise.
     */
    private boolean isJavaSet(String type) {
        if (type.startsWith("Set<") || type.startsWith("QSet<")) {
            return true;
        }
        return false;
    }

    /**
     * Check if the given Java or JDT type is a SortedSet.
     * 
     * @param type the given Java or JDT type.
     * @return true if the given Java or JDT type is a SortedSet, false otherwise.
     */
    private boolean isJavaSortedSet(String type) {
        if (type.startsWith("SortedSet<") || type.startsWith("QSortedSet<")) {
            return true;
        }
        return false;
    }

    /**
     * Check if the given Java or JDT type is a Map.
     * 
     * @param type the given Java or JDT type.
     * @return true if the given Java or JDT type is a Map, false otherwise.
     */
    private boolean isJavaMap(String type) {
        if (type.startsWith("Map<") || type.startsWith("QMap<")) {
            return true;
        }
        return false;
    }

    /**
     * Check if the given Java or JDT type is a SortedMap.
     * 
     * @param type the given Java or JDT type.
     * @return true if the given Java or JDT type is a SortedMap, false otherwise.
     */
    private boolean isJavaSortedMap(String type) {
        if (type.startsWith("SortedMap<") || type.startsWith("QSortedMap<")) {
            return true;
        }
        return false;
    }

    /**
     * Check whether this field represent an enumerated value or not.
     * 
     * @param iField
     * @return
     */
    private boolean isJavaEnum(IField iField) {
        try {
            String type = iField.getTypeSignature();
            String simpleType = Signature.getSignatureSimpleName(type);
            IType iType = iField.getDeclaringType();
            IType enumType = iType.getType(simpleType);
            return (enumType != null && enumType.isEnum());
        }
        catch (JavaModelException jme) {
            return false;
        }
    }

    /**
     * Extract the java type from a JDT type.
     * 
     * @param type a JDT type
     */
    private String extractType(String type) {
        if (type.startsWith("Q")) {
            type = type.replaceFirst("Q", "");
        }
        else if (type.startsWith("L")) {
            type.replaceFirst("L", "");
        }

        if (type.endsWith(";")) {
            type = type.substring(0, type.lastIndexOf(";"));
        }
        return type;
    }

    /**
     * Check if the given type if a JDT array type.
     * 
     * @param type a JDT array type.
     * @return true if the given type if a JDT array type, false otherwise.
     */
    private boolean isJDTArrayType(String type) {
        if (type.startsWith("[")) {
            return true;
        }
        return false;
    }

    /**
     * Check if the given type if a JDT primitive array type.
     * 
     * @param type a JDT primitive array type.
     * @return true if the given type if a JDT primitive array type, false otherwise.
     */
    private boolean isJDTArrayPrimitiveType(String type) {
        if (type.startsWith("[")) {
            int length = type.length() - 1;
            if (length >= 0) {
                String last = String.valueOf(type.charAt(length));
                if (eJavaPrimitiveTypes.get(last) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Manage the conversion of a JDT primitive array type to the appropriate EcoreType.
     * 
     * @param type a JDT primitive array type.
     * @return the appropriate EcoreType.
     */
    private EDataType manageJDTArrayPrimitiveType(String type) {
        if (eArrayDataTypesAdded.containsKey(type)) {
            return eArrayDataTypesAdded.get(type);
        }
        else {
            EDataType dataType = eFactory.createEDataType();
            dataType.setName(jDTArrayPrimitiveTypeToIFPArrayPrimitiveType(type));
            dataType.setInstanceTypeName(jDTArrayPrimitiveTypeToJavaArrayPrimitiveType(type));
            EPackage dataTypesPackage = getPackageDataTypes(eProject);
            dataTypesPackage.getEClassifiers().add(dataType);
            eArrayDataTypesAdded.put(type, dataType);
            return dataType;
        }
    }

    /**
     * Manage the conversion of a JDT array type to the appropriate EcoreType.
     * 
     * @param type a JDT array type.
     * @return the appropriate EcoreType.
     */
    private EDataType manageJDTArrayType(String type) {
        if (eArrayDataTypesAdded.containsKey(type)) {
            return eArrayDataTypesAdded.get(type);
        }
        else {
            EDataType dataType = eFactory.createEDataType();
            dataType.setName(jDTArrayTypeToIFPArrayType(type));
            dataType.setInstanceTypeName(jDTArrayTypeToJavaArrayType(type));
            EPackage dataTypesPackage = getPackageDataTypes(eProject);
            dataTypesPackage.getEClassifiers().add(dataType);
            eArrayDataTypesAdded.put(type, dataType);
            return dataType;
        }
    }

    /**
     * Get the package containing the array data types. Creates it if it doesn't exist.
     * 
     * @param eProject the root {@link EPackage} of the metamodel.
     * @return the data types {@link EPackage}.
     */
    private EPackage getPackageDataTypes(EPackage eProject) {
        for (EPackage subPackage : eProject.getESubpackages()) {
            if (packageDataTypesName.equals(subPackage.getName())) {
                return subPackage;
            }
        }
        EPackage dataTypesPackage = eFactory.createEPackage();
        dataTypesPackage.setName(packageDataTypesName);
        eProject.getESubpackages().add(dataTypesPackage);
        return dataTypesPackage;
    }

    /**
     * Convert a JDT primitive array type to an IFP primitive array type.
     * 
     * @param type a JDT primitive array type.
     * @return the IFP array type equivalent.
     */
    private String jDTArrayPrimitiveTypeToIFPArrayPrimitiveType(String type) {
        String ifpType = "ArrayOf";
        int length = type.length() - 1;
        if (length >= 0) {
            String last = String.valueOf(type.charAt(length));
            String javaType = String.valueOf(eJavaPrimitiveTypes.get(last));
            javaType = javaType.substring(0, 1).toUpperCase() + javaType.substring(1);
            ifpType += javaType;
        }
        if (type.startsWith("[[[")) {
            ifpType = ifpType.concat("3D");
        }
        else if (type.startsWith("[[")) {
            ifpType = ifpType.concat("2D");
        }
        else if (type.startsWith("[")) {
            ifpType = ifpType.concat("1D");
        }
        return ifpType;
    }

    /**
     * Convert a JDT primitive array type of to a Java primitive array type.
     * 
     * @param type a JDT primitive array type.
     * @return the Java array type equivalent.
     */
    private String jDTArrayPrimitiveTypeToJavaArrayPrimitiveType(String type) {
        String javaArrayType = "";
        int length = type.length() - 1;
        if (length >= 0) {
            String last = String.valueOf(type.charAt(length));
            javaArrayType = String.valueOf(eJavaPrimitiveTypes.get(last));
        }
        if (type.startsWith("[[[")) {
            javaArrayType = javaArrayType.concat("[][][]");
        }
        else if (type.startsWith("[[")) {
            javaArrayType = javaArrayType.concat("[][]");
        }
        else if (type.startsWith("[")) {
            javaArrayType = javaArrayType.concat("[]");
        }
        return javaArrayType;
    }

    /**
     * Convert a JDT array type to an IFP array type.
     * 
     * @param type a JDT array type.
     * @return the IFP array type equivalent.
     */
    private String jDTArrayTypeToIFPArrayType(String type) {
        String ifpType = "ArrayOf";
        if (type.startsWith("[[[")) {
            ifpType = ifpType.concat(extractType(type.substring(3)));
            ifpType = ifpType.concat("3D");
        }
        else if (type.startsWith("[[")) {
            ifpType = ifpType.concat(extractType(type.substring(2)));
            ifpType = ifpType.concat("2D");
        }
        else if (type.startsWith("[")) {
            ifpType = ifpType.concat(extractType(type.substring(1)));
            ifpType = ifpType.concat("1D");
        }
        return ifpType;
    }

    /**
     * Convert a JDT array type of a JDT array type to a Java array type.
     * 
     * @param type a JDT array type.
     * @return the Java array type equivalent.
     */
    private String jDTArrayTypeToJavaArrayType(String type) {
        String javaArrayType = "";
        if (type.startsWith("[[[")) {
            javaArrayType = javaArrayType.concat(extractType(type.substring(3)));
            javaArrayType = javaArrayType.concat("[][][]");
        }
        else if (type.startsWith("[[")) {
            javaArrayType = javaArrayType.concat(extractType(type.substring(2)));
            javaArrayType = javaArrayType.concat("[][]");
        }
        else if (type.startsWith("[")) {
            javaArrayType = javaArrayType.concat(extractType(type.substring(1)));
            javaArrayType = javaArrayType.concat("[]");
        }
        return javaArrayType;
    }

    /**
     * Check if the given {@link IField} contained in the given {@link IType} has an associated
     * getter.
     * 
     * @param iField the given {@link IField}.
     * @param iType the given {@link IType}.
     * @return true if the given {@link IField} contained in the given {@link IType} has an
     *         associated getter, false otherwise.
     * @throws JavaModelException
     */
    private boolean hasGetter(IField iField, IType iType) throws JavaModelException {
        String fieldName = iField.getElementName();
        String fieldGetterName = "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
        List<IMethod> methods = Arrays.asList(iType.getMethods());
        for (IMethod iMethod : methods) {
            String methodName = iMethod.getElementName();
            if (fieldGetterName.equals(methodName)
                    && (iMethod.getParameters() == null || iMethod.getParameters().length == 0)) {
                return true;
            }
        }

        return false;

    }

    /**
     * Manage the addition of a specific getter annotation for the given {@link IField} (associated
     * to the given {@link EStructuralFeature}) contained in the given {@link IType} if needed.
     * 
     * @param iField the given {@link IField}.
     * @param iType the given {@link IType}.
     * @param feature the given {@link EStructuralFeature}.
     * @throws JavaModelException
     */
    private void manageGetterAnnotation(IField iField, IType iType, EStructuralFeature feature)
            throws JavaModelException {
        if (!hasGetter(iField, iType)) {
            EAnnotation ofGen = getOFannotation(feature);
            /*EAnnotation ofGen;
            if(feature.getEAnnotations().isEmpty()){
            	ofGen = eFactory.createEAnnotation();
            	ofGen.setSource("of_generation");
            } else {
            	ofGen=feature.getEAnnotation("of_generation");
            }*/
            ofGen.getDetails().put("of_getter", "");
            feature.getEAnnotations().add(ofGen);
            logEntry(getterLog,
                    iField.getCompilationUnit().getElementName() + ";" + iField.getElementName());
        }

    }

    private EAnnotation getOFannotation(EStructuralFeature feature) {
        EAnnotation ofGen;
        if (feature.getEAnnotations().isEmpty()) {
            ofGen = eFactory.createEAnnotation();
            ofGen.setSource("of_generation");
        }
        else {
            ofGen = feature.getEAnnotation("of_generation");
        }
        return ofGen;
    }

    /**
     * Set the addition of a specific enumerate annotation for the given {@link IField} if needed.
     * 
     * @param iField the given {@link IField}.
     * @param iType the given {@link IType}.
     * @param feature the given {@link EStructuralFeature}.
     * @throws JavaModelException
     */
    private void setEnumAnnotation(IField iField, EStructuralFeature feature)
            throws JavaModelException {
        EAnnotation ofGen = getOFannotation(feature);
        /*EAnnotation ofGen;
        if(feature.getEAnnotations().isEmpty()){
        	ofGen = eFactory.createEAnnotation();
        	ofGen.setSource("of_generation");
        } else {
        	ofGen=feature.getEAnnotation("of_generation");
        }
        */
        ofGen.getDetails().put("of_enum", "");
        feature.getEAnnotations().add(ofGen);
        logEntry(enumLog,
                iField.getCompilationUnit().getElementName() + ";" + iField.getElementName());
    }

    /**
     * Add an entry to the log.
     * 
     * @param log the given log.
     * @param entry the entry to append to the log.
     */
    private void logEntry(List<String> log, String entry) {
        log.add(entry);
    }

    /**
     * @return the Error log generated during the processing
     */
    public List<String> getErrorLog() {
        return errorLog;
    }

    /**
     * @return the Getter error log generated during the processing
     */
    public List<String> getGetterLog() {
        return getterLog;
    }

    /**
     * @return the Getter enum log generated during the processing
     */
    public List<String> getEnumLog() {
        return enumLog;
    }
}
