/**
 * Generated with Acceleo
 */
package fr.ifpen.emptooling.samples.cuboid.providers;

import fr.ifpen.emptooling.samples.cuboid.util.CuboidModelerAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;

/**
 * 
 * 
 */
public class CuboidEEFAdapterFactory extends CuboidModelerAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see fr.ifpen.emptooling.samples.cuboid.util.CuboidModelerAdapterFactory#createSceneAdapter()
	 * 
	 */
	public Adapter createSceneAdapter() {
		return new ScenePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see fr.ifpen.emptooling.samples.cuboid.util.CuboidModelerAdapterFactory#createCuboidAdapter()
	 * 
	 */
	public Adapter createCuboidAdapter() {
		return new CuboidPropertiesEditionProvider();
	}

}
