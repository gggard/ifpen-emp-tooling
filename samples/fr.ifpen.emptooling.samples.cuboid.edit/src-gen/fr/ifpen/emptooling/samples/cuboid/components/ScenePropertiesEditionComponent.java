/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.components;

// Start of user code for imports
import fr.ifpen.emptooling.samples.cuboid.Cuboid;
import fr.ifpen.emptooling.samples.cuboid.CuboidModelerPackage;
import fr.ifpen.emptooling.samples.cuboid.Scene;

import fr.ifpen.emptooling.samples.cuboid.parts.CuboidmodelerViewsRepository;
import fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public class ScenePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for cubes ReferencesTable
	 */
	protected ReferencesTableSettings cubesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ScenePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject scene, String editing_mode) {
		super(editingContext, scene, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = CuboidmodelerViewsRepository.class;
		partKey = CuboidmodelerViewsRepository.Scene.class;
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
			final Scene scene = (Scene)elt;
			final ScenePropertiesEditionPart basePart = (ScenePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Objects.cubes)) {
				cubesSettings = new ReferencesTableSettings(scene, CuboidModelerPackage.eINSTANCE.getScene_Cubes());
				basePart.initCubes(cubesSettings);
			}
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX)) {
				basePart.setRotationX(EEFConverterUtil.convertToString(EcorePackage.Literals.EFLOAT, scene.getRotationX()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX)) {
				basePart.setTranslationX(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, scene.getTranslationX()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY)) {
				basePart.setTranslationY(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, scene.getTranslationY()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ)) {
				basePart.setTranslationZ(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, scene.getTranslationZ()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY)) {
				basePart.setRotationY(EEFConverterUtil.convertToString(EcorePackage.Literals.EFLOAT, scene.getRotationY()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ)) {
				basePart.setRotationZ(EEFConverterUtil.convertToString(EcorePackage.Literals.EFLOAT, scene.getRotationZ()));
			}
			
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate)) {
				basePart.setRotate(scene.isRotate());
			}
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires)) {
				basePart.setShowWires(scene.isShowWires());
			}
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces)) {
				basePart.setShowFaces(scene.isShowFaces());
			}
			// init filters
			if (isAccessible(CuboidmodelerViewsRepository.Scene.Objects.cubes)) {
				basePart.addFilterToCubes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Cuboid); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for cubes
				// End of user code
			}
			
			
			
			
			
			
			
			
			
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
		if (editorKey == CuboidmodelerViewsRepository.Scene.Objects.cubes) {
			return CuboidModelerPackage.eINSTANCE.getScene_Cubes();
		}
		if (editorKey == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX) {
			return CuboidModelerPackage.eINSTANCE.getScene_RotationX();
		}
		if (editorKey == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX) {
			return CuboidModelerPackage.eINSTANCE.getScene_TranslationX();
		}
		if (editorKey == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY) {
			return CuboidModelerPackage.eINSTANCE.getScene_TranslationY();
		}
		if (editorKey == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ) {
			return CuboidModelerPackage.eINSTANCE.getScene_TranslationZ();
		}
		if (editorKey == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY) {
			return CuboidModelerPackage.eINSTANCE.getScene_RotationY();
		}
		if (editorKey == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ) {
			return CuboidModelerPackage.eINSTANCE.getScene_RotationZ();
		}
		if (editorKey == CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate) {
			return CuboidModelerPackage.eINSTANCE.getScene_Rotate();
		}
		if (editorKey == CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires) {
			return CuboidModelerPackage.eINSTANCE.getScene_ShowWires();
		}
		if (editorKey == CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces) {
			return CuboidModelerPackage.eINSTANCE.getScene_ShowFaces();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Scene scene = (Scene)semanticObject;
		if (CuboidmodelerViewsRepository.Scene.Objects.cubes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, cubesSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				cubesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				cubesSettings.move(event.getNewIndex(), (Cuboid) event.getNewValue());
			}
		}
		if (CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX == event.getAffectedEditor()) {
			scene.setRotationX((EEFConverterUtil.createFloatFromString(EcorePackage.Literals.EFLOAT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX == event.getAffectedEditor()) {
			scene.setTranslationX((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY == event.getAffectedEditor()) {
			scene.setTranslationY((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ == event.getAffectedEditor()) {
			scene.setTranslationZ((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY == event.getAffectedEditor()) {
			scene.setRotationY((EEFConverterUtil.createFloatFromString(EcorePackage.Literals.EFLOAT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ == event.getAffectedEditor()) {
			scene.setRotationZ((EEFConverterUtil.createFloatFromString(EcorePackage.Literals.EFLOAT, (String)event.getNewValue())));
		}
		if (CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate == event.getAffectedEditor()) {
			scene.setRotate((Boolean)event.getNewValue());
		}
		if (CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires == event.getAffectedEditor()) {
			scene.setShowWires((Boolean)event.getNewValue());
		}
		if (CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces == event.getAffectedEditor()) {
			scene.setShowFaces((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			ScenePropertiesEditionPart basePart = (ScenePropertiesEditionPart)editingPart;
			if (CuboidModelerPackage.eINSTANCE.getScene_Cubes().equals(msg.getFeature()) && isAccessible(CuboidmodelerViewsRepository.Scene.Objects.cubes))
				basePart.updateCubes();
			if (CuboidModelerPackage.eINSTANCE.getScene_RotationX().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX)) {
				if (msg.getNewValue() != null) {
					basePart.setRotationX(EcoreUtil.convertToString(EcorePackage.Literals.EFLOAT, msg.getNewValue()));
				} else {
					basePart.setRotationX("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getScene_TranslationX().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX)) {
				if (msg.getNewValue() != null) {
					basePart.setTranslationX(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setTranslationX("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getScene_TranslationY().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY)) {
				if (msg.getNewValue() != null) {
					basePart.setTranslationY(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setTranslationY("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getScene_TranslationZ().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ)) {
				if (msg.getNewValue() != null) {
					basePart.setTranslationZ(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setTranslationZ("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getScene_RotationY().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY)) {
				if (msg.getNewValue() != null) {
					basePart.setRotationY(EcoreUtil.convertToString(EcorePackage.Literals.EFLOAT, msg.getNewValue()));
				} else {
					basePart.setRotationY("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getScene_RotationZ().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ)) {
				if (msg.getNewValue() != null) {
					basePart.setRotationZ(EcoreUtil.convertToString(EcorePackage.Literals.EFLOAT, msg.getNewValue()));
				} else {
					basePart.setRotationZ("");
				}
			}
			if (CuboidModelerPackage.eINSTANCE.getScene_Rotate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate))
				basePart.setRotate((Boolean)msg.getNewValue());
			
			if (CuboidModelerPackage.eINSTANCE.getScene_ShowWires().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires))
				basePart.setShowWires((Boolean)msg.getNewValue());
			
			if (CuboidModelerPackage.eINSTANCE.getScene_ShowFaces().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces))
				basePart.setShowFaces((Boolean)msg.getNewValue());
			
			
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
			CuboidModelerPackage.eINSTANCE.getScene_Cubes(),
			CuboidModelerPackage.eINSTANCE.getScene_RotationX(),
			CuboidModelerPackage.eINSTANCE.getScene_TranslationX(),
			CuboidModelerPackage.eINSTANCE.getScene_TranslationY(),
			CuboidModelerPackage.eINSTANCE.getScene_TranslationZ(),
			CuboidModelerPackage.eINSTANCE.getScene_RotationY(),
			CuboidModelerPackage.eINSTANCE.getScene_RotationZ(),
			CuboidModelerPackage.eINSTANCE.getScene_Rotate(),
			CuboidModelerPackage.eINSTANCE.getScene_ShowWires(),
			CuboidModelerPackage.eINSTANCE.getScene_ShowFaces()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX || key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX || key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY || key == CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ || key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY || key == CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ;
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
				if (CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationX == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getScene_RotationX().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getScene_RotationX().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationX == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getScene_TranslationX().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getScene_TranslationX().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationY == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getScene_TranslationY().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getScene_TranslationY().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Scene.Transformations.Translation.translationZ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getScene_TranslationZ().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getScene_TranslationZ().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationY == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getScene_RotationY().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getScene_RotationY().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Scene.Transformations.Rotation.rotationZ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getScene_RotationZ().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getScene_RotationZ().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Scene.Transformations.Flags.rotate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getScene_Rotate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getScene_Rotate().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Scene.Transformations.Flags.showWires == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getScene_ShowWires().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getScene_ShowWires().getEAttributeType(), newValue);
				}
				if (CuboidmodelerViewsRepository.Scene.Transformations.Flags.showFaces == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(CuboidModelerPackage.eINSTANCE.getScene_ShowFaces().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(CuboidModelerPackage.eINSTANCE.getScene_ShowFaces().getEAttributeType(), newValue);
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
