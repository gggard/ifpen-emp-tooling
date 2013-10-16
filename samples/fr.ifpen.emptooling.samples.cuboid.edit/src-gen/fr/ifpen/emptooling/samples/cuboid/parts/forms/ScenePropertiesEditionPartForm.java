/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.HorizontalBox;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;

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
public class ScenePropertiesEditionPartForm extends SectionPropertiesEditingPart implements
        IFormPropertiesEditionPart, ScenePropertiesEditionPart {

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
     * For {@link ISection} use only.
     */
    public ScenePropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     */
    public ScenePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.forms.widgets.FormToolkit)
     */
    @Override
    public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
        ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
        Form form = scrolledForm.getForm();
        view = form.getBody();
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        view.setLayout(layout);
        createControls(widgetFactory, view);
        return scrolledForm;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createControls(org.eclipse.ui.forms.widgets.FormToolkit,
     *      org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void createControls(final FormToolkit widgetFactory, Composite view) {
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
                    return createObjectsGroup(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Objects.cubes) {
                    return createCubesTableComposition(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.class) {
                    return createTransformationsGroup(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.class) {
                    return createTranslationHBox(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX) {
                    return createTranslationXText(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY) {
                    return createTranslationYText(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ) {
                    return createTranslationZText(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.class) {
                    return createRotationHBox(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX) {
                    return createRotationXText(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY) {
                    return createRotationYText(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ) {
                    return createRotationZText(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Flags.class) {
                    return createFlagsHBox(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate) {
                    return createRotateCheckbox(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires) {
                    return createShowWiresCheckbox(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces) {
                    return createShowFacesCheckbox(widgetFactory, parent);
                }
                if (key == CuboidmodelerViewsRepository.Scene.View.class) {
                    return createViewVBox(widgetFactory, parent);
                }
                // Start of user code for newt addToPart creation
                if (key == CuboidmodelerViewsRepository.Scene.View.newt) {
                    return createNewtWidget(widgetFactory, parent);
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
    protected Composite createObjectsGroup(FormToolkit widgetFactory, final Composite parent) {
        Section objectsSection = widgetFactory.createSection(parent, ExpandableComposite.TITLE_BAR
                | ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED);
        objectsSection.setText(CuboidmodelerMessages.ScenePropertiesEditionPart_ObjectsGroupLabel);
        GridData objectsSectionData = new GridData(GridData.FILL_HORIZONTAL);
        objectsSectionData.horizontalSpan = 3;
        objectsSection.setLayoutData(objectsSectionData);
        Composite objectsGroup = widgetFactory.createComposite(objectsSection);
        GridLayout objectsGroupLayout = new GridLayout();
        objectsGroupLayout.numColumns = 3;
        objectsGroup.setLayout(objectsGroupLayout);
        objectsSection.setClient(objectsGroup);
        return objectsGroup;
    }

    /**
     * @param container
     */
    protected Composite createCubesTableComposition(FormToolkit widgetFactory, Composite parent) {
        this.cubes = new ReferencesTable(getDescription(
                CuboidmodelerViewsRepository.Scene.Objects.cubes,
                CuboidmodelerMessages.ScenePropertiesEditionPart_CubesLabel),
                new ReferencesTableListener() {
                    @Override
                    public void handleAdd() {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
                                        CuboidmodelerViewsRepository.Scene.Objects.cubes,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD,
                                        null, null));
                        cubes.refresh();
                    }

                    @Override
                    public void handleEdit(EObject element) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
                                        CuboidmodelerViewsRepository.Scene.Objects.cubes,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT,
                                        null, element));
                        cubes.refresh();
                    }

                    @Override
                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
                                        CuboidmodelerViewsRepository.Scene.Objects.cubes,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE,
                                        element, newIndex));
                        cubes.refresh();
                    }

                    @Override
                    public void handleRemove(EObject element) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
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
                CuboidmodelerViewsRepository.FORM_KIND));
        this.cubes.createControls(parent, widgetFactory);
        this.cubes.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this,
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
    protected Composite createTransformationsGroup(FormToolkit widgetFactory, final Composite parent) {
        Section transformationsSection = widgetFactory.createSection(parent,
                ExpandableComposite.TITLE_BAR | ExpandableComposite.TWISTIE
                        | ExpandableComposite.EXPANDED);
        transformationsSection
                .setText(CuboidmodelerMessages.ScenePropertiesEditionPart_TransformationsGroupLabel);
        GridData transformationsSectionData = new GridData(GridData.FILL_HORIZONTAL);
        transformationsSectionData.horizontalSpan = 3;
        transformationsSection.setLayoutData(transformationsSectionData);
        Composite transformationsGroup = widgetFactory.createComposite(transformationsSection);
        GridLayout transformationsGroupLayout = new GridLayout();
        transformationsGroupLayout.numColumns = 3;
        transformationsGroup.setLayout(transformationsGroupLayout);
        transformationsSection.setClient(transformationsGroup);
        return transformationsGroup;
    }

    protected Composite createTranslationHBox(FormToolkit widgetFactory, Composite parent) {
        Composite container = widgetFactory.createComposite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = 3;
        container.setLayoutData(gridData);
        HorizontalBox translationHBox = new HorizontalBox(container);
        widgetFactory.adapt(translationHBox);
        return translationHBox;
    }

    protected Composite createTranslationXText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX,
                CuboidmodelerMessages.ScenePropertiesEditionPart_TranslationXLabel);
        translationX = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        translationX.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData translationXData = new GridData(GridData.FILL_HORIZONTAL);
        translationX.setLayoutData(translationXData);
        translationX.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    ScenePropertiesEditionPartForm.this,
                                    CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                    null, translationX.getText()));
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    ScenePropertiesEditionPartForm.this,
                                    CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX,
                                    PropertiesEditionEvent.FOCUS_CHANGED,
                                    PropertiesEditionEvent.FOCUS_LOST, null, translationX.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        translationX.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
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
        FormUtils
                .createHelpButton(
                        widgetFactory,
                        parent,
                        propertiesEditionComponent
                                .getHelpContent(
                                        CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX,
                                        CuboidmodelerViewsRepository.FORM_KIND), null);
        return parent;
    }

    protected Composite createTranslationYText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY,
                CuboidmodelerMessages.ScenePropertiesEditionPart_TranslationYLabel);
        translationY = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        translationY.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData translationYData = new GridData(GridData.FILL_HORIZONTAL);
        translationY.setLayoutData(translationYData);
        translationY.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    ScenePropertiesEditionPartForm.this,
                                    CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                    null, translationY.getText()));
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    ScenePropertiesEditionPartForm.this,
                                    CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY,
                                    PropertiesEditionEvent.FOCUS_CHANGED,
                                    PropertiesEditionEvent.FOCUS_LOST, null, translationY.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        translationY.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
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
        FormUtils
                .createHelpButton(
                        widgetFactory,
                        parent,
                        propertiesEditionComponent
                                .getHelpContent(
                                        CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY,
                                        CuboidmodelerViewsRepository.FORM_KIND), null);
        return parent;
    }

    protected Composite createTranslationZText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ,
                CuboidmodelerMessages.ScenePropertiesEditionPart_TranslationZLabel);
        translationZ = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        translationZ.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData translationZData = new GridData(GridData.FILL_HORIZONTAL);
        translationZ.setLayoutData(translationZData);
        translationZ.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    ScenePropertiesEditionPartForm.this,
                                    CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                    null, translationZ.getText()));
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(
                                    ScenePropertiesEditionPartForm.this,
                                    CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ,
                                    PropertiesEditionEvent.FOCUS_CHANGED,
                                    PropertiesEditionEvent.FOCUS_LOST, null, translationZ.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        translationZ.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
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
        FormUtils
                .createHelpButton(
                        widgetFactory,
                        parent,
                        propertiesEditionComponent
                                .getHelpContent(
                                        CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ,
                                        CuboidmodelerViewsRepository.FORM_KIND), null);
        return parent;
    }

    protected Composite createRotationHBox(FormToolkit widgetFactory, Composite parent) {
        Composite container = widgetFactory.createComposite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = 3;
        container.setLayoutData(gridData);
        HorizontalBox rotationHBox = new HorizontalBox(container);
        widgetFactory.adapt(rotationHBox);
        return rotationHBox;
    }

    protected Composite createRotationXText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX,
                CuboidmodelerMessages.ScenePropertiesEditionPart_RotationXLabel);
        rotationX = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        rotationX.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData rotationXData = new GridData(GridData.FILL_HORIZONTAL);
        rotationX.setLayoutData(rotationXData);
        rotationX.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            rotationX.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, rotationX.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        rotationX.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
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
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(
                        CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX,
                        CuboidmodelerViewsRepository.FORM_KIND), null);
        return parent;
    }

    protected Composite createRotationYText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY,
                CuboidmodelerMessages.ScenePropertiesEditionPart_RotationYLabel);
        rotationY = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        rotationY.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData rotationYData = new GridData(GridData.FILL_HORIZONTAL);
        rotationY.setLayoutData(rotationYData);
        rotationY.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            rotationY.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, rotationY.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        rotationY.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
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
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(
                        CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY,
                        CuboidmodelerViewsRepository.FORM_KIND), null);
        return parent;
    }

    protected Composite createRotationZText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent,
                CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ,
                CuboidmodelerMessages.ScenePropertiesEditionPart_RotationZLabel);
        rotationZ = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        rotationZ.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData rotationZData = new GridData(GridData.FILL_HORIZONTAL);
        rotationZ.setLayoutData(rotationZData);
        rotationZ.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            rotationZ.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this,
                            CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, rotationZ.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ScenePropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        rotationZ.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent
                                .firePropertiesChanged(new PropertiesEditionEvent(
                                        ScenePropertiesEditionPartForm.this,
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
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(
                        CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ,
                        CuboidmodelerViewsRepository.FORM_KIND), null);
        return parent;
    }

    protected Composite createFlagsHBox(FormToolkit widgetFactory, Composite parent) {
        Composite container = widgetFactory.createComposite(parent, SWT.NONE);
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
        widgetFactory.adapt(flagsHBox);
        return flagsHBox;
    }

    protected Composite createRotateCheckbox(FormToolkit widgetFactory, Composite parent) {
        rotate = widgetFactory.createButton(
                parent,
                getDescription(CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate,
                        CuboidmodelerMessages.ScenePropertiesEditionPart_RotateLabel), SWT.CHECK);
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
                            ScenePropertiesEditionPartForm.this,
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
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate,
                        CuboidmodelerViewsRepository.FORM_KIND), null);
        return parent;
    }

    protected Composite createShowWiresCheckbox(FormToolkit widgetFactory, Composite parent) {
        showWires = widgetFactory
                .createButton(
                        parent,
                        getDescription(
                                CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires,
                                CuboidmodelerMessages.ScenePropertiesEditionPart_ShowWiresLabel),
                        SWT.CHECK);
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
                            ScenePropertiesEditionPartForm.this,
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
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires,
                        CuboidmodelerViewsRepository.FORM_KIND), null);
        return parent;
    }

    protected Composite createShowFacesCheckbox(FormToolkit widgetFactory, Composite parent) {
        showFaces = widgetFactory
                .createButton(
                        parent,
                        getDescription(
                                CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces,
                                CuboidmodelerMessages.ScenePropertiesEditionPart_ShowFacesLabel),
                        SWT.CHECK);
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
                            ScenePropertiesEditionPartForm.this,
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
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces,
                        CuboidmodelerViewsRepository.FORM_KIND), null);
        return parent;
    }

    protected Composite createViewVBox(FormToolkit widgetFactory, Composite parent) {
        Composite container = widgetFactory.createComposite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
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
    protected Composite createNewtWidget(FormToolkit widgetFactory, Composite parent) {
        cubeModelerContext = new CuboidModelerGLEventListener(parent.getDisplay());
        newt = new NEWTWidget(parent, SWT.NONE, cubeModelerContext,
                new CuboidModelerInputEventListener(cubeModelerContext));
        newt.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData newtData = new GridData(SWT.FILL, SWT.FILL, true, true);
        newtData.horizontalSpan = 3;
        newt.setLayoutData(newtData);
        return parent;
    }
    // End of user code

}
