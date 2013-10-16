/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.parts.forms;

// Start of user code for imports
import fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart;
import fr.ifpen.emptooling.samples.cuboid.parts.CuboidmodelerViewsRepository;

import fr.ifpen.emptooling.samples.cuboid.providers.CuboidmodelerMessages;

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

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * 
 * 
 */
public class CuboidPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CuboidPropertiesEditionPart {

	protected Text name;
	protected Text posX;
	protected Text posY;
	protected Text posZ;
	protected Text red;
	protected Text green;
	protected Text blue;
	protected Text opacity;
	protected Text length;
	protected Text height;
	protected Text depth;



	/**
	 * For {@link ISection} use only.
	 */
	public CuboidPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CuboidPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
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
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence cuboidStep = new BindingCompositionSequence(propertiesEditionComponent);
		cuboidStep.addStep(CuboidmodelerViewsRepository.Cuboid.name);
		CompositionStep positionStep = cuboidStep.addStep(CuboidmodelerViewsRepository.Cuboid.Position.class);
		positionStep.addStep(CuboidmodelerViewsRepository.Cuboid.Position.posX);
		positionStep.addStep(CuboidmodelerViewsRepository.Cuboid.Position.posY);
		positionStep.addStep(CuboidmodelerViewsRepository.Cuboid.Position.posZ);
		
		CompositionStep colorStep = cuboidStep.addStep(CuboidmodelerViewsRepository.Cuboid.Color.class);
		colorStep.addStep(CuboidmodelerViewsRepository.Cuboid.Color.red);
		colorStep.addStep(CuboidmodelerViewsRepository.Cuboid.Color.green);
		colorStep.addStep(CuboidmodelerViewsRepository.Cuboid.Color.blue);
		colorStep.addStep(CuboidmodelerViewsRepository.Cuboid.Color.opacity);
		
		CompositionStep attributesStep = cuboidStep.addStep(CuboidmodelerViewsRepository.Cuboid.Attributes.class);
		attributesStep.addStep(CuboidmodelerViewsRepository.Cuboid.Attributes.length);
		attributesStep.addStep(CuboidmodelerViewsRepository.Cuboid.Attributes.height);
		attributesStep.addStep(CuboidmodelerViewsRepository.Cuboid.Attributes.depth);
		
		
		composer = new PartComposer(cuboidStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == CuboidmodelerViewsRepository.Cuboid.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Position.class) {
					return createPositionGroup(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Position.posX) {
					return createPosXText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Position.posY) {
					return createPosYText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Position.posZ) {
					return createPosZText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.class) {
					return createColorGroup(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.red) {
					return createRedText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.green) {
					return createGreenText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.blue) {
					return createBlueText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.opacity) {
					return createOpacityText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Attributes.class) {
					return createAttributesGroup(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Attributes.length) {
					return createLengthText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Attributes.height) {
					return createHeightText(widgetFactory, parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Attributes.depth) {
					return createDepthText(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.name, CuboidmodelerMessages.CuboidPropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, CuboidmodelerViewsRepository.Cuboid.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.name, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createPositionGroup(FormToolkit widgetFactory, final Composite parent) {
		Section positionSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		positionSection.setText(CuboidmodelerMessages.CuboidPropertiesEditionPart_PositionGroupLabel);
		GridData positionSectionData = new GridData(GridData.FILL_HORIZONTAL);
		positionSectionData.horizontalSpan = 3;
		positionSection.setLayoutData(positionSectionData);
		Composite positionGroup = widgetFactory.createComposite(positionSection);
		GridLayout positionGroupLayout = new GridLayout();
		positionGroupLayout.numColumns = 3;
		positionGroup.setLayout(positionGroupLayout);
		positionSection.setClient(positionGroup);
		return positionGroup;
	}

	
	protected Composite createPosXText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Position.posX, CuboidmodelerMessages.CuboidPropertiesEditionPart_PosXLabel);
		posX = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		posX.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData posXData = new GridData(GridData.FILL_HORIZONTAL);
		posX.setLayoutData(posXData);
		posX.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Position.posX,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posX.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Position.posX,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, posX.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		posX.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Position.posX, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posX.getText()));
				}
			}
		});
		EditingUtils.setID(posX, CuboidmodelerViewsRepository.Cuboid.Position.posX);
		EditingUtils.setEEFtype(posX, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Position.posX, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createPosYText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Position.posY, CuboidmodelerMessages.CuboidPropertiesEditionPart_PosYLabel);
		posY = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		posY.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData posYData = new GridData(GridData.FILL_HORIZONTAL);
		posY.setLayoutData(posYData);
		posY.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Position.posY,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posY.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Position.posY,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, posY.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		posY.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Position.posY, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posY.getText()));
				}
			}
		});
		EditingUtils.setID(posY, CuboidmodelerViewsRepository.Cuboid.Position.posY);
		EditingUtils.setEEFtype(posY, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Position.posY, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createPosZText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Position.posZ, CuboidmodelerMessages.CuboidPropertiesEditionPart_PosZLabel);
		posZ = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		posZ.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData posZData = new GridData(GridData.FILL_HORIZONTAL);
		posZ.setLayoutData(posZData);
		posZ.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Position.posZ,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posZ.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Position.posZ,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, posZ.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		posZ.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Position.posZ, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posZ.getText()));
				}
			}
		});
		EditingUtils.setID(posZ, CuboidmodelerViewsRepository.Cuboid.Position.posZ);
		EditingUtils.setEEFtype(posZ, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Position.posZ, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createColorGroup(FormToolkit widgetFactory, final Composite parent) {
		Section colorSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		colorSection.setText(CuboidmodelerMessages.CuboidPropertiesEditionPart_ColorGroupLabel);
		GridData colorSectionData = new GridData(GridData.FILL_HORIZONTAL);
		colorSectionData.horizontalSpan = 3;
		colorSection.setLayoutData(colorSectionData);
		Composite colorGroup = widgetFactory.createComposite(colorSection);
		GridLayout colorGroupLayout = new GridLayout();
		colorGroupLayout.numColumns = 3;
		colorGroup.setLayout(colorGroupLayout);
		colorSection.setClient(colorGroup);
		return colorGroup;
	}

	
	protected Composite createRedText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Color.red, CuboidmodelerMessages.CuboidPropertiesEditionPart_RedLabel);
		red = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		red.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData redData = new GridData(GridData.FILL_HORIZONTAL);
		red.setLayoutData(redData);
		red.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Color.red,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, red.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Color.red,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, red.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		red.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Color.red, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, red.getText()));
				}
			}
		});
		EditingUtils.setID(red, CuboidmodelerViewsRepository.Cuboid.Color.red);
		EditingUtils.setEEFtype(red, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Color.red, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createGreenText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Color.green, CuboidmodelerMessages.CuboidPropertiesEditionPart_GreenLabel);
		green = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		green.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData greenData = new GridData(GridData.FILL_HORIZONTAL);
		green.setLayoutData(greenData);
		green.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Color.green,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, green.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Color.green,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, green.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		green.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Color.green, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, green.getText()));
				}
			}
		});
		EditingUtils.setID(green, CuboidmodelerViewsRepository.Cuboid.Color.green);
		EditingUtils.setEEFtype(green, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Color.green, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createBlueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Color.blue, CuboidmodelerMessages.CuboidPropertiesEditionPart_BlueLabel);
		blue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		blue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData blueData = new GridData(GridData.FILL_HORIZONTAL);
		blue.setLayoutData(blueData);
		blue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Color.blue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, blue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Color.blue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, blue.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		blue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Color.blue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, blue.getText()));
				}
			}
		});
		EditingUtils.setID(blue, CuboidmodelerViewsRepository.Cuboid.Color.blue);
		EditingUtils.setEEFtype(blue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Color.blue, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createOpacityText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Color.opacity, CuboidmodelerMessages.CuboidPropertiesEditionPart_OpacityLabel);
		opacity = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		opacity.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData opacityData = new GridData(GridData.FILL_HORIZONTAL);
		opacity.setLayoutData(opacityData);
		opacity.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Color.opacity,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, opacity.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Color.opacity,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, opacity.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		opacity.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Color.opacity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, opacity.getText()));
				}
			}
		});
		EditingUtils.setID(opacity, CuboidmodelerViewsRepository.Cuboid.Color.opacity);
		EditingUtils.setEEFtype(opacity, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Color.opacity, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createAttributesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section attributesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		attributesSection.setText(CuboidmodelerMessages.CuboidPropertiesEditionPart_AttributesGroupLabel);
		GridData attributesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		attributesSectionData.horizontalSpan = 3;
		attributesSection.setLayoutData(attributesSectionData);
		Composite attributesGroup = widgetFactory.createComposite(attributesSection);
		GridLayout attributesGroupLayout = new GridLayout();
		attributesGroupLayout.numColumns = 3;
		attributesGroup.setLayout(attributesGroupLayout);
		attributesSection.setClient(attributesGroup);
		return attributesGroup;
	}

	
	protected Composite createLengthText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Attributes.length, CuboidmodelerMessages.CuboidPropertiesEditionPart_LengthLabel);
		length = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		length.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData lengthData = new GridData(GridData.FILL_HORIZONTAL);
		length.setLayoutData(lengthData);
		length.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Attributes.length,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Attributes.length,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, length.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		length.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Attributes.length, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
				}
			}
		});
		EditingUtils.setID(length, CuboidmodelerViewsRepository.Cuboid.Attributes.length);
		EditingUtils.setEEFtype(length, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Attributes.length, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createHeightText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Attributes.height, CuboidmodelerMessages.CuboidPropertiesEditionPart_HeightLabel);
		height = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		height.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData heightData = new GridData(GridData.FILL_HORIZONTAL);
		height.setLayoutData(heightData);
		height.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Attributes.height,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, height.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Attributes.height,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, height.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		height.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Attributes.height, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, height.getText()));
				}
			}
		});
		EditingUtils.setID(height, CuboidmodelerViewsRepository.Cuboid.Attributes.height);
		EditingUtils.setEEFtype(height, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Attributes.height, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDepthText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Attributes.depth, CuboidmodelerMessages.CuboidPropertiesEditionPart_DepthLabel);
		depth = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		depth.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData depthData = new GridData(GridData.FILL_HORIZONTAL);
		depth.setLayoutData(depthData);
		depth.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CuboidPropertiesEditionPartForm.this,
							CuboidmodelerViewsRepository.Cuboid.Attributes.depth,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, depth.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									CuboidmodelerViewsRepository.Cuboid.Attributes.depth,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, depth.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CuboidPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		depth.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartForm.this, CuboidmodelerViewsRepository.Cuboid.Attributes.depth, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, depth.getText()));
				}
			}
		});
		EditingUtils.setID(depth, CuboidmodelerViewsRepository.Cuboid.Attributes.depth);
		EditingUtils.setEEFtype(depth, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Attributes.depth, CuboidmodelerViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getPosX()
	 * 
	 */
	public String getPosX() {
		return posX.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setPosX(String newValue)
	 * 
	 */
	public void setPosX(String newValue) {
		if (newValue != null) {
			posX.setText(newValue);
		} else {
			posX.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getPosY()
	 * 
	 */
	public String getPosY() {
		return posY.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setPosY(String newValue)
	 * 
	 */
	public void setPosY(String newValue) {
		if (newValue != null) {
			posY.setText(newValue);
		} else {
			posY.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getPosZ()
	 * 
	 */
	public String getPosZ() {
		return posZ.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setPosZ(String newValue)
	 * 
	 */
	public void setPosZ(String newValue) {
		if (newValue != null) {
			posZ.setText(newValue);
		} else {
			posZ.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getRed()
	 * 
	 */
	public String getRed() {
		return red.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setRed(String newValue)
	 * 
	 */
	public void setRed(String newValue) {
		if (newValue != null) {
			red.setText(newValue);
		} else {
			red.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getGreen()
	 * 
	 */
	public String getGreen() {
		return green.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setGreen(String newValue)
	 * 
	 */
	public void setGreen(String newValue) {
		if (newValue != null) {
			green.setText(newValue);
		} else {
			green.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getBlue()
	 * 
	 */
	public String getBlue() {
		return blue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setBlue(String newValue)
	 * 
	 */
	public void setBlue(String newValue) {
		if (newValue != null) {
			blue.setText(newValue);
		} else {
			blue.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getOpacity()
	 * 
	 */
	public String getOpacity() {
		return opacity.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setOpacity(String newValue)
	 * 
	 */
	public void setOpacity(String newValue) {
		if (newValue != null) {
			opacity.setText(newValue);
		} else {
			opacity.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getLength()
	 * 
	 */
	public String getLength() {
		return length.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setLength(String newValue)
	 * 
	 */
	public void setLength(String newValue) {
		if (newValue != null) {
			length.setText(newValue);
		} else {
			length.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getHeight()
	 * 
	 */
	public String getHeight() {
		return height.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setHeight(String newValue)
	 * 
	 */
	public void setHeight(String newValue) {
		if (newValue != null) {
			height.setText(newValue);
		} else {
			height.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#getDepth()
	 * 
	 */
	public String getDepth() {
		return depth.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart#setDepth(String newValue)
	 * 
	 */
	public void setDepth(String newValue) {
		if (newValue != null) {
			depth.setText(newValue);
		} else {
			depth.setText(""); //$NON-NLS-1$
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return CuboidmodelerMessages.Cuboid_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
