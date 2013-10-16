/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.providers;

import fr.ifpen.emptooling.samples.cuboid.parts.CuboidmodelerViewsRepository;

import fr.ifpen.emptooling.samples.cuboid.parts.forms.CuboidPropertiesEditionPartForm;
import fr.ifpen.emptooling.samples.cuboid.parts.forms.ScenePropertiesEditionPartForm;

import fr.ifpen.emptooling.samples.cuboid.parts.impl.CuboidPropertiesEditionPartImpl;
import fr.ifpen.emptooling.samples.cuboid.parts.impl.ScenePropertiesEditionPartImpl;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

/**
 * 
 * 
 */
public class CuboidmodelerPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == CuboidmodelerViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == CuboidmodelerViewsRepository.Scene.class) {
			if (kind == CuboidmodelerViewsRepository.SWT_KIND)
				return new ScenePropertiesEditionPartImpl(component);
			if (kind == CuboidmodelerViewsRepository.FORM_KIND)
				return new ScenePropertiesEditionPartForm(component);
		}
		if (key == CuboidmodelerViewsRepository.Cuboid.class) {
			if (kind == CuboidmodelerViewsRepository.SWT_KIND)
				return new CuboidPropertiesEditionPartImpl(component);
			if (kind == CuboidmodelerViewsRepository.FORM_KIND)
				return new CuboidPropertiesEditionPartForm(component);
		}
		return null;
	}

}
