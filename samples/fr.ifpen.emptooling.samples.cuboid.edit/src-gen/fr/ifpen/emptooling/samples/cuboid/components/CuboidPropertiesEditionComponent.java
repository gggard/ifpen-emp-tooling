/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.components;

// Start of user code for imports
import fr.ifpen.emptooling.samples.cuboid.Cuboid;
import fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage;

import fr.ifpen.emptooling.samples.cuboid.parts.CuboidPropertiesEditionPart;
import fr.ifpen.emptooling.samples.cuboid.parts.CuboidmodelerViewsRepository;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;


// End of user code

/**
 * 
 * 
 */
public class CuboidPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public CuboidPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject cuboid, String editing_mode) {
		super(editingContext, cuboid, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = CuboidmodelerViewsRepository.class;
		partKey = CuboidmodelerViewsRepository.Cuboid.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final Cuboid cuboid = (Cuboid)elt;
			final CuboidPropertiesEditionPart basePart = (CuboidPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Position.posX)) {
				basePart.setPosX(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getPosX()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Position.posY)) {
				basePart.setPosY(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getPosY()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Position.posZ)) {
				basePart.setPosZ(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getPosZ()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Color.red)) {
				basePart.setRed(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getRed()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Color.green)) {
				basePart.setGreen(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getGreen()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Color.blue)) {
				basePart.setBlue(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getBlue()));
			}
			
			if (cuboid.getName() != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cuboid.getName()));
			
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Color.opacity)) {
				basePart.setOpacity(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getOpacity()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Attributes.length)) {
				basePart.setLength(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getLength()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Attributes.height)) {
				basePart.setHeight(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getHeight()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Cuboid.Attributes.depth)) {
				basePart.setDepth(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, cuboid.getDepth()));
			}
			
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}














	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Position.posX) {
			return CuboidModelerPackage.eINSTANCE.getSceneObj_PosX();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Position.posY) {
			return CuboidModelerPackage.eINSTANCE.getSceneObj_PosY();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Position.posZ) {
			return CuboidModelerPackage.eINSTANCE.getSceneObj_PosZ();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Color.red) {
			return CuboidModelerPackage.eINSTANCE.getSceneObj_Red();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Color.green) {
			return CuboidModelerPackage.eINSTANCE.getSceneObj_Green();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Color.blue) {
			return CuboidModelerPackage.eINSTANCE.getSceneObj_Blue();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.name) {
			return CuboidModelerPackage.eINSTANCE.getSceneObj_Name();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Color.opacity) {
			return CuboidModelerPackage.eINSTANCE.getSceneObj_Opacity();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Attributes.length) {
			return CuboidModelerPackage.eINSTANCE.getCuboid_Length();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Attributes.height) {
			return CuboidModelerPackage.eINSTANCE.getCuboid_Height();
		}
		if (editorKey == CuboidmodelerViewsRepository.Cuboid.Attributes.depth) {
			return CuboidModelerPackage.eINSTANCE.getCuboid_Depth();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Cuboid cuboid = (Cuboid)semanticObject;
		if (CuboidmodelerViewsRepository.Cuboid.Position.posX == event.getAffectedEditor()) {
			cuboid.setPosX((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Cuboid.Position.posY == event.getAffectedEditor()) {
			cuboid.setPosY((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Cuboid.Position.posZ == event.getAffectedEditor()) {
			cuboid.setPosZ((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Cuboid.Color.red == event.getAffectedEditor()) {
			cuboid.setRed((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Cuboid.Color.green == event.getAffectedEditor()) {
			cuboid.setGreen((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Cuboid.Color.blue == event.getAffectedEditor()) {
			cuboid.setBlue((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Cuboid.name == event.getAffectedEditor()) {
			cuboid.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (CuboidmodelerViewsRepository.Cuboid.Color.opacity == event.getAffectedEditor()) {
			cuboid.setOpacity((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Cuboid.Attributes.length == event.getAffectedEditor()) {
			cuboid.setLength((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Cuboid.Attributes.height == event.getAffectedEditor()) {
			cuboid.setHeight((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Cuboid.Attributes.depth == event.getAffectedEditor()) {
			cuboid.setDepth((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			CuboidPropertiesEditionPart basePart = (CuboidPropertiesEditionPart)editingPart;
			if (CuboidModelerPackage.eINSTANCE.getSceneObj_PosX().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Position.posX)) {
				if (msg.getNewValue() != null) {
					basePart.setPosX(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPosX("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getSceneObj_PosY().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Position.posY)) {
				if (msg.getNewValue() != null) {
					basePart.setPosY(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPosY("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getSceneObj_PosZ().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Position.posZ)) {
				if (msg.getNewValue() != null) {
					basePart.setPosZ(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPosZ("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getSceneObj_Red().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Color.red)) {
				if (msg.getNewValue() != null) {
					basePart.setRed(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setRed("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getSceneObj_Green().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Color.green)) {
				if (msg.getNewValue() != null) {
					basePart.setGreen(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setGreen("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getSceneObj_Blue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Color.blue)) {
				if (msg.getNewValue() != null) {
					basePart.setBlue(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setBlue("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getSceneObj_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getSceneObj_Opacity().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Color.opacity)) {
				if (msg.getNewValue() != null) {
					basePart.setOpacity(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setOpacity("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getCuboid_Length().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Attributes.length)) {
				if (msg.getNewValue() != null) {
					basePart.setLength(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setLength("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getCuboid_Height().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Attributes.height)) {
				if (msg.getNewValue() != null) {
					basePart.setHeight(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setHeight("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getCuboid_Depth().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Cuboid.Attributes.depth)) {
				if (msg.getNewValue() != null) {
					basePart.setDepth(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setDepth("");
				}
			}
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			CuboidModelerPackage.eINSTANCE.getSceneObj_PosX(),
			CuboidModelerPackage.eINSTANCE.getSceneObj_PosY(),
			CuboidModelerPackage.eINSTANCE.getSceneObj_PosZ(),
			CuboidModelerPackage.eINSTANCE.getSceneObj_Red(),
			CuboidModelerPackage.eINSTANCE.getSceneObj_Green(),
			CuboidModelerPackage.eINSTANCE.getSceneObj_Blue(),
			CuboidModelerPackage.eINSTANCE.getSceneObj_Name(),
			CuboidModelerPackage.eINSTANCE.getSceneObj_Opacity(),
			CuboidModelerPackage.eINSTANCE.getCuboid_Length(),
			CuboidModelerPackage.eINSTANCE.getCuboid_Height(),
			CuboidModelerPackage.eINSTANCE.getCuboid_Depth()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == CuboidmodelerViewsRepository.Cuboid.Position.posX || key == CuboidmodelerViewsRepository.Cuboid.Position.posY || key == CuboidmodelerViewsRepository.Cuboid.Position.posZ || key == CuboidmodelerViewsRepository.Cuboid.Color.red || key == CuboidmodelerViewsRepository.Cuboid.Color.green || key == CuboidmodelerViewsRepository.Cuboid.Color.blue || key == CuboidmodelerViewsRepository.Cuboid.name || key == CuboidmodelerViewsRepository.Cuboid.Color.opacity || key == CuboidmodelerViewsRepository.Cuboid.Attributes.length || key == CuboidmodelerViewsRepository.Cuboid.Attributes.height || key == CuboidmodelerViewsRepository.Cuboid.Attributes.depth;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (CuboidmodelerViewsRepository.Cuboid.Position.posX == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getSceneObj_PosX().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getSceneObj_PosX().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.Position.posY == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getSceneObj_PosY().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getSceneObj_PosY().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.Position.posZ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getSceneObj_PosZ().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getSceneObj_PosZ().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.Color.red == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getSceneObj_Red().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getSceneObj_Red().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.Color.green == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getSceneObj_Green().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getSceneObj_Green().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.Color.blue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getSceneObj_Blue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getSceneObj_Blue().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getSceneObj_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getSceneObj_Name().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.Color.opacity == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getSceneObj_Opacity().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getSceneObj_Opacity().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.Attributes.length == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getCuboid_Length().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getCuboid_Length().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.Attributes.height == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getCuboid_Height().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getCuboid_Height().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Cuboid.Attributes.depth == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getCuboid_Depth().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getCuboid_Depth().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
