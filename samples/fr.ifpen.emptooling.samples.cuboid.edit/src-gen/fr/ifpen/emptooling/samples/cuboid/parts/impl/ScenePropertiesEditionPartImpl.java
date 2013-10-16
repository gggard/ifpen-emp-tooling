/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.VerticalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import fr.ifpen.emptooling.samples.cuboid.Scene;
import fr.ifpen.emptooling.samples.cuboid.newtview.CuboidModelerGLEventListener;
import fr.ifpen.emptooling.samples.cuboid.newtview.CuboidModelerInputEventListener;
import fr.ifpen.emptooling.samples.cuboid.parts.CuboidmodelerViewsRepository;
import fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart;
import fr.ifpen.emptooling.samples.cuboid.providers.CuboidmodelerMessages;
import fr.ifpen.emptooling.samples.newtview.NEWTWidget;

// End of user code

/**
 * 
 * 
 */
public class ScenePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements
        ISWTPropertiesEditionPart, ScenePropertiesEditionPart {

    protected ReferencesTable cubes;

    protected List<ViewerFilter> cubesBusinessFilters = new ArrayList<ViewerFilter>();

    protected List<ViewerFilter> cubesFilters = new ArrayList<ViewerFilter>();

    protected Text translationX;

    protected Text translationY;

    protected Text translationZ;

    protected Text rotationX;

    protected Text rotationY;

    protected Text rotationZ;

    protected Button rotate;

    protected Button showWires;

    protected Button showFaces;

    // Start of user code for newt widgets declarations
    protected NEWTWidget newt;

    protected CuboidModelerGLEventListener cubeModelerContext;

    // End of user code

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     */
    public ScenePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public Composite createFigure(final Composite parent) {
        view = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        view.setLayout(layout);
        createControls(view);
        return view;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
     *      createControls(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void createControls(Composite view) {
        CompositionSequence sceneStep = new BindingCompositionSequence(propertiesEditionComponent);
        sceneStep.addStep(CuboidmodelerViewsRepository.Scene.Objects.class).addStep(
                CuboidmodelerViewsRepository.Scene.Objects.cubes);

        CompositionStep transformationsStep = sceneStep
                .addStep(CuboidmodelerViewsRepository.Scene.Transformations.class);
        CompositionStep translationStep = transformationsStep
                .addStep(CuboidmodelerViewsRepository.Scene.Transformations.Translation.class);
        translationStep
                .addStep(CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX);
        translationStep
                .addStep(CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY);
        translationStep
                .addStep(CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ);

        CompositionStep rotationStep = transformationsStep
                .addStep(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.class);
        rotationStep.addStep(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX);
        rotationStep.addStep(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY);
        rotationStep.addStep(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ);

        CompositionStep flagsStep = transformationsStep
                .addStep(CuboidmodelerViewsRepository.Scene.Transformations.Flags.class);
        flagsStep.addStep(CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate);
        flagsStep.addStep(CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires);
        flagsStep.addStep(CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces);

        sceneStep.addStep(CuboidmodelerViewsRepository.Scene.View.class).addStep(
                CuboidmodelerViewsRepository.Scene.View.newt);

        composer = new PartComposer(sceneStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == CuboidmodelerViewsRepository.Scene.Objects.class) {
                    return createObjectsGroup(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Objects.cubes) {
                    return createCubesAdvancedTableComposition(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.class) {
                    return createTransformationsGroup(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.class) {
                    return createTranslationHBox(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX) {
                    return createTranslationXText(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY) {
                    return createTranslationYText(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ) {
                    return createTranslationZText(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.class) {
                    return createRotationHBox(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX) {
                    return createRotationXText(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY) {
                    return createRotationYText(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ) {
                    return createRotationZText(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Flags.class) {
                    return createFlagsHBox(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate) {
                    return createRotateCheckbox(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires) {
                    return createShowWiresCheckbox(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces) {
                    return createShowFacesCheckbox(parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.View.class) {
                    return createViewVBox(parent);
                }
                // Start of user code for newt addToPart creation
                if (key == CuboidmodelerViewsRepository.Scene.View.newt) {
                    return createNewtWidget(parent);
                }
                // End of user code
                return parent;
            }
        };
        composer.compose(view);
    }

    /**
	 * 
	 */
    protected Composite createObjectsGroup(Composite parent) {
        Group objectsGroup = new Group(parent, SWT.NONE);
        objectsGroup.setText(CuboidmodelerMessages.ScenePropertiesEditionPart_ObjectsGroupLabel);
        GridData objectsGroupData = new GridData(GridData.FILL_HORIZONTAL);
        objectsGroupData.horizontalSpan = 3;
        objectsGroup.setLayoutData(objectsGroupData);
        GridLayout objectsGroupLayout = new GridLayout();
        objectsGroupLayout.numColumns = 3;
        objectsGroup.setLayout(objectsGroupLayout);
        return objectsGroup;
    }

    /**
     * @param container
     */
    protected Composite createCubesAdvancedTableComposition(Composite parent) {
        this.cubes = new ReferencesTable(getDescription(
                CuboidmodelerViewsRepository.Scene.Objects.cubes,
                CuboidmodelerMessages.ScenePropertiesEditionPart_CubesLabel),
                new ReferencesTableListener() {
                    @Override
                    public void handleAdd() {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Objects.cubes,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD,
                                        null, null));
                        cubes.refresh();
                    }

                    @Override
                    public void handleEdit(EObject element) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Objects.cubes,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT,
                                        null, element));
                        cubes.refresh();
                    }

                    @Override
                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Objects.cubes,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE,
                                        element, newIndex));
                        cubes.refresh();
                    }

                    @Override
                    public void handleRemove(EObject element) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Objects.cubes,
                                        PropertiesEditionEvent.COMMIT,
                                        PropertiesEditionEvent.REMOVE, null, element));
                        cubes.refresh();
                    }

                    @Override
                    public void navigateTo(EObject element) {
                    }
                });
        for (ViewerFilter filter : this.cubesFilters) {
            this.cubes.addFilter(filter);
        }
        this.cubes.setHelpText(propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Objects.cubes,
                CuboidmodelerViewsRepository.SWT_KIND));
        this.cubes.createControls(parent);
        this.cubes.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartImpl.this,
                            CuboidmodelerViewsRepository.Scene.Objects.cubes,
                            PropertiesEditionEvent.CHANGE,
                            PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
                }
            }

        });
        GridData cubesData = new GridData(GridData.FILL_HORIZONTAL);
        cubesData.horizontalSpan = 3;
        this.cubes.setLayoutData(cubesData);
        this.cubes.setLowerBound(0);
        this.cubes.setUpperBound(-1);
        cubes.setID(CuboidmodelerViewsRepository.Scene.Objects.cubes);
        cubes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        return parent;
    }

    /**
	 * 
	 */
    protected Composite createTransformationsGroup(Composite parent) {
        Group transformationsGroup = new Group(parent, SWT.NONE);
        transformationsGroup
                .setText(CuboidmodelerMessages.ScenePropertiesEditionPart_TransformationsGroupLabel);
        GridData transformationsGroupData = new GridData(GridData.FILL_HORIZONTAL);
        transformationsGroupData.horizontalSpan = 3;
        transformationsGroup.setLayoutData(transformationsGroupData);
        GridLayout transformationsGroupLayout = new GridLayout();
        transformationsGroupLayout.numColumns = 3;
        transformationsGroup.setLayout(transformationsGroupLayout);
        return transformationsGroup;
    }

    protected Composite createTranslationHBox(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = 3;
        container.setLayoutData(gridData);
        HorizontalBox translationHBox = new HorizontalBox(container);
        return translationHBox;
    }

    protected Composite createTranslationXText(Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX,
                CuboidmodelerMessages.ScenePropertiesEditionPart_TranslationXLabel);
        translationX = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData translationXData = new GridData(GridData.FILL_HORIZONTAL);
        translationX.setLayoutData(translationXData);
        translationX.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    ScenePropertiesEditionPartImpl.this,
                                    CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                    null, translationX.getText()));
                }
            }

        });
        translationX.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, translationX.getText()));
                    }
                }
            }

        });
        EditingUtils.setID(translationX,
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX);
        EditingUtils.setEEFtype(translationX, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX,
                CuboidmodelerViewsRepository.SWT_KIND), null);
        return parent;
    }

    protected Composite createTranslationYText(Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY,
                CuboidmodelerMessages.ScenePropertiesEditionPart_TranslationYLabel);
        translationY = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData translationYData = new GridData(GridData.FILL_HORIZONTAL);
        translationY.setLayoutData(translationYData);
        translationY.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    ScenePropertiesEditionPartImpl.this,
                                    CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                    null, translationY.getText()));
                }
            }

        });
        translationY.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, translationY.getText()));
                    }
                }
            }

        });
        EditingUtils.setID(translationY,
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY);
        EditingUtils.setEEFtype(translationY, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY,
                CuboidmodelerViewsRepository.SWT_KIND), null);
        return parent;
    }

    protected Composite createTranslationZText(Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ,
                CuboidmodelerMessages.ScenePropertiesEditionPart_TranslationZLabel);
        translationZ = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData translationZData = new GridData(GridData.FILL_HORIZONTAL);
        translationZ.setLayoutData(translationZData);
        translationZ.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    ScenePropertiesEditionPartImpl.this,
                                    CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                    null, translationZ.getText()));
                }
            }

        });
        translationZ.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, translationZ.getText()));
                    }
                }
            }

        });
        EditingUtils.setID(translationZ,
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ);
        EditingUtils.setEEFtype(translationZ, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ,
                CuboidmodelerViewsRepository.SWT_KIND), null);
        return parent;
    }

    protected Composite createRotationHBox(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = 3;
        container.setLayoutData(gridData);
        HorizontalBox rotationHBox = new HorizontalBox(container);
        return rotationHBox;
    }

    protected Composite createRotationXText(Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX,
                CuboidmodelerMessages.ScenePropertiesEditionPart_RotationXLabel);
        rotationX = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData rotationXData = new GridData(GridData.FILL_HORIZONTAL);
        rotationX.setLayoutData(rotationXData);
        rotationX.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartImpl.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            rotationX.getText()));
                }
            }

        });
        rotationX.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, rotationX.getText()));
                    }
                }
            }

        });
        EditingUtils.setID(rotationX,
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX);
        EditingUtils.setEEFtype(rotationX, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX,
                CuboidmodelerViewsRepository.SWT_KIND), null);
        return parent;
    }

    protected Composite createRotationYText(Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY,
                CuboidmodelerMessages.ScenePropertiesEditionPart_RotationYLabel);
        rotationY = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData rotationYData = new GridData(GridData.FILL_HORIZONTAL);
        rotationY.setLayoutData(rotationYData);
        rotationY.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartImpl.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            rotationY.getText()));
                }
            }

        });
        rotationY.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, rotationY.getText()));
                    }
                }
            }

        });
        EditingUtils.setID(rotationY,
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY);
        EditingUtils.setEEFtype(rotationY, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY,
                CuboidmodelerViewsRepository.SWT_KIND), null);
        return parent;
    }

    protected Composite createRotationZText(Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ,
                CuboidmodelerMessages.ScenePropertiesEditionPart_RotationZLabel);
        rotationZ = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData rotationZData = new GridData(GridData.FILL_HORIZONTAL);
        rotationZ.setLayoutData(rotationZData);
        rotationZ.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartImpl.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            rotationZ.getText()));
                }
            }

        });
        rotationZ.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartImpl.this,
                                        CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, rotationZ.getText()));
                    }
                }
            }

        });
        EditingUtils.setID(rotationZ,
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ);
        EditingUtils.setEEFtype(rotationZ, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ,
                CuboidmodelerViewsRepository.SWT_KIND), null);
        return parent;
    }

    protected Composite createFlagsHBox(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = 3;
        container.setLayoutData(gridData);
        HorizontalBox flagsHBox = new HorizontalBox(container);
        // Apply constraint for checkbox
        GridData constraint = new GridData(GridData.FILL_HORIZONTAL);
        constraint.horizontalAlignment = GridData.BEGINNING;
        flagsHBox.setLayoutData(constraint);
        return flagsHBox;
    }

    protected Composite createRotateCheckbox(Composite parent) {
        rotate = new Button(parent, SWT.CHECK);
        rotate.setText(getDescription(
                CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate,
                CuboidmodelerMessages.ScenePropertiesEditionPart_RotateLabel));
        rotate.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartImpl.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            new Boolean(rotate.getSelection())));
                }
            }

        });
        GridData rotateData = new GridData(GridData.FILL_HORIZONTAL);
        rotateData.horizontalSpan = 2;
        rotate.setLayoutData(rotateData);
        EditingUtils.setID(rotate, CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate);
        EditingUtils.setEEFtype(rotate, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate,
                CuboidmodelerViewsRepository.SWT_KIND), null);
        return parent;
    }

    protected Composite createShowWiresCheckbox(Composite parent) {
        showWires = new Button(parent, SWT.CHECK);
        showWires.setText(getDescription(
                CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires,
                CuboidmodelerMessages.ScenePropertiesEditionPart_ShowWiresLabel));
        showWires.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartImpl.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            new Boolean(showWires.getSelection())));
                }
            }

        });
        GridData showWiresData = new GridData(GridData.FILL_HORIZONTAL);
        showWiresData.horizontalSpan = 2;
        showWires.setLayoutData(showWiresData);
        EditingUtils.setID(showWires,
                CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires);
        EditingUtils.setEEFtype(showWires, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires,
                CuboidmodelerViewsRepository.SWT_KIND), null);
        return parent;
    }

    protected Composite createShowFacesCheckbox(Composite parent) {
        showFaces = new Button(parent, SWT.CHECK);
        showFaces.setText(getDescription(
                CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces,
                CuboidmodelerMessages.ScenePropertiesEditionPart_ShowFacesLabel));
        showFaces.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartImpl.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            new Boolean(showFaces.getSelection())));
                }
            }

        });
        GridData showFacesData = new GridData(GridData.FILL_HORIZONTAL);
        showFacesData.horizontalSpan = 2;
        showFaces.setLayoutData(showFacesData);
        EditingUtils.setID(showFaces,
                CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces);
        EditingUtils.setEEFtype(showFaces, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces,
                CuboidmodelerViewsRepository.SWT_KIND), null);
        return parent;
    }

    protected Composite createViewVBox(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        VerticalBox viewVBox = new VerticalBox(container);
        return viewVBox;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     */
    @Override
    public void firePropertiesChanged(IPropertiesEditionEvent event) {
        // Start of user code for tab synchronization

        // End of user code
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#initCubes(EObject
     *      current, EReference containingFeature, EReference feature)
     */
    @Override
    public void initCubes(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null) {
            this.resourceSet = current.eResource().getResourceSet();
        }
        ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
        cubes.setContentProvider(contentProvider);
        cubes.setInput(settings);
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#updateCubes()
     */
    @Override
    public void updateCubes() {
        cubes.refresh();
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#addFilterCubes(ViewerFilter
     *      filter)
     */
    @Override
    public void addFilterToCubes(ViewerFilter filter) {
        cubesFilters.add(filter);
        if (this.cubes != null) {
            this.cubes.addFilter(filter);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#addBusinessFilterCubes(ViewerFilter
     *      filter)
     */
    @Override
    public void addBusinessFilterToCubes(ViewerFilter filter) {
        cubesBusinessFilters.add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#isContainedInCubesTable(EObject
     *      element)
     */
    @Override
    public boolean isContainedInCubesTable(EObject element) {
        return ((ReferencesTableSettings) cubes.getInput()).contains(element);
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#getTranslationX()
     */
    @Override
    public String getTranslationX() {
        return translationX.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#setTranslationX(String
     *      newValue)
     */
    @Override
    public void setTranslationX(String newValue) {
        if (newValue != null) {
            translationX.setText(newValue);
        }
        else {
            translationX.setText(""); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#getTranslationY()
     */
    @Override
    public String getTranslationY() {
        return translationY.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#setTranslationY(String
     *      newValue)
     */
    @Override
    public void setTranslationY(String newValue) {
        if (newValue != null) {
            translationY.setText(newValue);
        }
        else {
            translationY.setText(""); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#getTranslationZ()
     */
    @Override
    public String getTranslationZ() {
        return translationZ.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#setTranslationZ(String
     *      newValue)
     */
    @Override
    public void setTranslationZ(String newValue) {
        if (newValue != null) {
            translationZ.setText(newValue);
        }
        else {
            translationZ.setText(""); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#getRotationX()
     */
    @Override
    public String getRotationX() {
        return rotationX.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#setRotationX(String
     *      newValue)
     */
    @Override
    public void setRotationX(String newValue) {
        if (newValue != null) {
            rotationX.setText(newValue);
        }
        else {
            rotationX.setText(""); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#getRotationY()
     */
    @Override
    public String getRotationY() {
        return rotationY.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#setRotationY(String
     *      newValue)
     */
    @Override
    public void setRotationY(String newValue) {
        if (newValue != null) {
            rotationY.setText(newValue);
        }
        else {
            rotationY.setText(""); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#getRotationZ()
     */
    @Override
    public String getRotationZ() {
        return rotationZ.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#setRotationZ(String
     *      newValue)
     */
    @Override
    public void setRotationZ(String newValue) {
        if (newValue != null) {
            rotationZ.setText(newValue);
        }
        else {
            rotationZ.setText(""); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#getRotate()
     */
    @Override
    public Boolean getRotate() {
        return Boolean.valueOf(rotate.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#setRotate(Boolean
     *      newValue)
     */
    @Override
    public void setRotate(Boolean newValue) {
        if (newValue != null) {
            rotate.setSelection(newValue.booleanValue());
        }
        else {
            rotate.setSelection(false);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#getShowWires()
     */
    @Override
    public Boolean getShowWires() {
        return Boolean.valueOf(showWires.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#setShowWires(Boolean
     *      newValue)
     */
    @Override
    public void setShowWires(Boolean newValue) {
        if (newValue != null) {
            showWires.setSelection(newValue.booleanValue());
        }
        else {
            showWires.setSelection(false);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#getShowFaces()
     */
    @Override
    public Boolean getShowFaces() {
        return Boolean.valueOf(showFaces.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart#setShowFaces(Boolean
     *      newValue)
     */
    @Override
    public void setShowFaces(Boolean newValue) {
        if (newValue != null) {
            showFaces.setSelection(newValue.booleanValue());
        }
        else {
            showFaces.setSelection(false);
        }
    }

    // Start of user code for newt specific getters and setters implementation
    @Override
    public void initScene(Scene scene) {
        cubeModelerContext.setInput(scene);
    }

    // End of user code

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     */
    @Override
    public String getTitle() {
        return CuboidmodelerMessages.Scene_Part_Title;
    }

    // Start of user code additional methods
    protected Composite createNewtWidget(Composite parent) {
        cubeModelerContext = new CuboidModelerGLEventListener(parent.getDisplay());
        newt = new NEWTWidget(parent, SWT.NONE, cubeModelerContext,
                new CuboidModelerInputEventListener(cubeModelerContext));
        GridData newtData = new GridData(SWT.FILL, SWT.FILL, true, true);
        newtData.horizontalSpan = 3;
        newt.setLayoutData(newtData);
        return parent;
    }
    // End of user code

}
