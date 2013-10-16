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
package fr.ifpen.emptooling.samples.cuboid.components;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import fr.ifpen.emptooling.samples.cuboid.Scene;
import fr.ifpen.emptooling.samples.cuboid.parts.CuboidmodelerViewsRepository;
import fr.ifpen.emptooling.samples.cuboid.parts.ScenePropertiesEditionPart;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class SceneCustomPropertiesEditionComponent extends ScenePropertiesEditionComponent {

    /**
     * @param editingContext
     * @param scene
     * @param editing_mode
     */
    public SceneCustomPropertiesEditionComponent(PropertiesEditingContext editingContext,
            EObject scene, String editing_mode) {
        super(editingContext, scene, editing_mode);
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.components.ScenePropertiesEditionComponent#initPart(java.lang.Object,
     *      int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
     */
    @Override
    public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
        if (isAccessible(CuboidmodelerViewsRepository.Scene.View.newt)) {
            final Scene scene = (Scene) elt;
            final ScenePropertiesEditionPart basePart = (ScenePropertiesEditionPart) editingPart;
            basePart.initScene(scene);
        }
        super.initPart(key, kind, elt, allResource);
    }

}
