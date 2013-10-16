/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.parts.impl;

// Start of user code for imports
import fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart;
import fr.ifpen.emptooling.samples.cuboid.parts.CuboidmodelerViewsRepository;

import fr.ifpen.emptooling.samples.cuboid.providers.CuboidmodelerMessages;

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

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 * 
 */
public class CuboidPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CuboidPropertiesEditionPart {

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
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CuboidPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
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
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
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
					return createNameText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Position.class) {
					return createPositionGroup(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Position.posX) {
					return createPosXText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Position.posY) {
					return createPosYText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Position.posZ) {
					return createPosZText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.class) {
					return createColorGroup(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.red) {
					return createRedText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.green) {
					return createGreenText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.blue) {
					return createBlueText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Color.opacity) {
					return createOpacityText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Attributes.class) {
					return createAttributesGroup(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Attributes.length) {
					return createLengthText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Attributes.height) {
					return createHeightText(parent);
				}
				if (key == CuboidmodelerViewsRepository.Cuboid.Attributes.depth) {
					return createDepthText(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.name, CuboidmodelerMessages.CuboidPropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, CuboidmodelerViewsRepository.Cuboid.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.name, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createPositionGroup(Composite parent) {
		Group positionGroup = new Group(parent, SWT.NONE);
		positionGroup.setText(CuboidmodelerMessages.CuboidPropertiesEditionPart_PositionGroupLabel);
		GridData positionGroupData = new GridData(GridData.FILL_HORIZONTAL);
		positionGroupData.horizontalSpan = 3;
		positionGroup.setLayoutData(positionGroupData);
		GridLayout positionGroupLayout = new GridLayout();
		positionGroupLayout.numColumns = 3;
		positionGroup.setLayout(positionGroupLayout);
		return positionGroup;
	}

	
	protected Composite createPosXText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Position.posX, CuboidmodelerMessages.CuboidPropertiesEditionPart_PosXLabel);
		posX = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData posXData = new GridData(GridData.FILL_HORIZONTAL);
		posX.setLayoutData(posXData);
		posX.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Position.posX, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posX.getText()));
			}

		});
		posX.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Position.posX, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posX.getText()));
				}
			}

		});
		EditingUtils.setID(posX, CuboidmodelerViewsRepository.Cuboid.Position.posX);
		EditingUtils.setEEFtype(posX, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Position.posX, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createPosYText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Position.posY, CuboidmodelerMessages.CuboidPropertiesEditionPart_PosYLabel);
		posY = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData posYData = new GridData(GridData.FILL_HORIZONTAL);
		posY.setLayoutData(posYData);
		posY.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Position.posY, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posY.getText()));
			}

		});
		posY.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Position.posY, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posY.getText()));
				}
			}

		});
		EditingUtils.setID(posY, CuboidmodelerViewsRepository.Cuboid.Position.posY);
		EditingUtils.setEEFtype(posY, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Position.posY, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createPosZText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Position.posZ, CuboidmodelerMessages.CuboidPropertiesEditionPart_PosZLabel);
		posZ = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData posZData = new GridData(GridData.FILL_HORIZONTAL);
		posZ.setLayoutData(posZData);
		posZ.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Position.posZ, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posZ.getText()));
			}

		});
		posZ.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Position.posZ, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, posZ.getText()));
				}
			}

		});
		EditingUtils.setID(posZ, CuboidmodelerViewsRepository.Cuboid.Position.posZ);
		EditingUtils.setEEFtype(posZ, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Position.posZ, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createColorGroup(Composite parent) {
		Group colorGroup = new Group(parent, SWT.NONE);
		colorGroup.setText(CuboidmodelerMessages.CuboidPropertiesEditionPart_ColorGroupLabel);
		GridData colorGroupData = new GridData(GridData.FILL_HORIZONTAL);
		colorGroupData.horizontalSpan = 3;
		colorGroup.setLayoutData(colorGroupData);
		GridLayout colorGroupLayout = new GridLayout();
		colorGroupLayout.numColumns = 3;
		colorGroup.setLayout(colorGroupLayout);
		return colorGroup;
	}

	
	protected Composite createRedText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Color.red, CuboidmodelerMessages.CuboidPropertiesEditionPart_RedLabel);
		red = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData redData = new GridData(GridData.FILL_HORIZONTAL);
		red.setLayoutData(redData);
		red.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Color.red, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, red.getText()));
			}

		});
		red.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Color.red, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, red.getText()));
				}
			}

		});
		EditingUtils.setID(red, CuboidmodelerViewsRepository.Cuboid.Color.red);
		EditingUtils.setEEFtype(red, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Color.red, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createGreenText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Color.green, CuboidmodelerMessages.CuboidPropertiesEditionPart_GreenLabel);
		green = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData greenData = new GridData(GridData.FILL_HORIZONTAL);
		green.setLayoutData(greenData);
		green.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Color.green, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, green.getText()));
			}

		});
		green.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Color.green, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, green.getText()));
				}
			}

		});
		EditingUtils.setID(green, CuboidmodelerViewsRepository.Cuboid.Color.green);
		EditingUtils.setEEFtype(green, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Color.green, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createBlueText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Color.blue, CuboidmodelerMessages.CuboidPropertiesEditionPart_BlueLabel);
		blue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData blueData = new GridData(GridData.FILL_HORIZONTAL);
		blue.setLayoutData(blueData);
		blue.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Color.blue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, blue.getText()));
			}

		});
		blue.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Color.blue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, blue.getText()));
				}
			}

		});
		EditingUtils.setID(blue, CuboidmodelerViewsRepository.Cuboid.Color.blue);
		EditingUtils.setEEFtype(blue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Color.blue, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createOpacityText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Color.opacity, CuboidmodelerMessages.CuboidPropertiesEditionPart_OpacityLabel);
		opacity = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData opacityData = new GridData(GridData.FILL_HORIZONTAL);
		opacity.setLayoutData(opacityData);
		opacity.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Color.opacity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, opacity.getText()));
			}

		});
		opacity.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Color.opacity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, opacity.getText()));
				}
			}

		});
		EditingUtils.setID(opacity, CuboidmodelerViewsRepository.Cuboid.Color.opacity);
		EditingUtils.setEEFtype(opacity, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Color.opacity, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createAttributesGroup(Composite parent) {
		Group attributesGroup = new Group(parent, SWT.NONE);
		attributesGroup.setText(CuboidmodelerMessages.CuboidPropertiesEditionPart_AttributesGroupLabel);
		GridData attributesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		attributesGroupData.horizontalSpan = 3;
		attributesGroup.setLayoutData(attributesGroupData);
		GridLayout attributesGroupLayout = new GridLayout();
		attributesGroupLayout.numColumns = 3;
		attributesGroup.setLayout(attributesGroupLayout);
		return attributesGroup;
	}

	
	protected Composite createLengthText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Attributes.length, CuboidmodelerMessages.CuboidPropertiesEditionPart_LengthLabel);
		length = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData lengthData = new GridData(GridData.FILL_HORIZONTAL);
		length.setLayoutData(lengthData);
		length.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Attributes.length, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
			}

		});
		length.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Attributes.length, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, length.getText()));
				}
			}

		});
		EditingUtils.setID(length, CuboidmodelerViewsRepository.Cuboid.Attributes.length);
		EditingUtils.setEEFtype(length, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Attributes.length, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createHeightText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Attributes.height, CuboidmodelerMessages.CuboidPropertiesEditionPart_HeightLabel);
		height = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData heightData = new GridData(GridData.FILL_HORIZONTAL);
		height.setLayoutData(heightData);
		height.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Attributes.height, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, height.getText()));
			}

		});
		height.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Attributes.height, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, height.getText()));
				}
			}

		});
		EditingUtils.setID(height, CuboidmodelerViewsRepository.Cuboid.Attributes.height);
		EditingUtils.setEEFtype(height, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Attributes.height, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDepthText(Composite parent) {
		createDescription(parent, CuboidmodelerViewsRepository.Cuboid.Attributes.depth, CuboidmodelerMessages.CuboidPropertiesEditionPart_DepthLabel);
		depth = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData depthData = new GridData(GridData.FILL_HORIZONTAL);
		depth.setLayoutData(depthData);
		depth.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Attributes.depth, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, depth.getText()));
			}

		});
		depth.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CuboidPropertiesEditionPartImpl.this, CuboidmodelerViewsRepository.Cuboid.Attributes.depth, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, depth.getText()));
				}
			}

		});
		EditingUtils.setID(depth, CuboidmodelerViewsRepository.Cuboid.Attributes.depth);
		EditingUtils.setEEFtype(depth, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(CuboidmodelerViewsRepository.Cuboid.Attributes.depth, CuboidmodelerViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
