/*******************************************************************************
 * Copyright (c) 2013 IFPen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IFPen - initial API and implementation
 *******************************************************************************/
package fr.ifpen.emptooling.samples.cuboid.providers;

import org.eclipse.emf.common.notify.Adapter;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class CuboidmodelerCustomEEFAdapterFactory extends CuboidEEFAdapterFactory {

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.providers.CuboidmodelerEEFAdapterFactory#createSceneAdapter()
     */
    @Override
    public Adapter createSceneAdapter() {
        return new SceneCustomPropertiesEditionProvider();
    }

}
