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

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import fr.ifpen.emptooling.samples.cuboid.Scene;
import fr.ifpen.emptooling.samples.cuboid.components.SceneCustomPropertiesEditionComponent;
import fr.ifpen.emptooling.samples.cuboid.components.ScenePropertiesEditionComponent;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class SceneCustomPropertiesEditionProvider extends ScenePropertiesEditionProvider {

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.providers.ScenePropertiesEditionProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
     *      java.lang.String)
     */
    @Override
    public IPropertiesEditionComponent getPropertiesEditingComponent(
            PropertiesEditingContext editingContext, String mode) {
        if (editingContext.getEObject() instanceof Scene) {
            return new SceneCustomPropertiesEditionComponent(editingContext,
                    editingContext.getEObject(), mode);
        }
        return super.getPropertiesEditingComponent(editingContext, mode);
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.providers.ScenePropertiesEditionProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
     *      java.lang.String, java.lang.String)
     */
    @Override
    public IPropertiesEditionComponent getPropertiesEditingComponent(
            PropertiesEditingContext editingContext, String mode, String part) {
        if (editingContext.getEObject() instanceof Scene) {
            if (ScenePropertiesEditionComponent.BASE_PART.equals(part)) {
                return new SceneCustomPropertiesEditionComponent(editingContext,
                        editingContext.getEObject(), mode);
            }
        }
        return super.getPropertiesEditingComponent(editingContext, mode, part);
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.ifpen.emptooling.samples.cuboid.providers.ScenePropertiesEditionProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
     *      java.lang.String, java.lang.String, java.lang.Class)
     */
    @Override
    public IPropertiesEditionComponent getPropertiesEditingComponent(
            PropertiesEditingContext editingContext, String mode, String part, Class refinement) {
        if (editingContext.getEObject() instanceof Scene) {
            if (ScenePropertiesEditionComponent.BASE_PART.equals(part)
                    && refinement == ScenePropertiesEditionComponent.class) {
                return new SceneCustomPropertiesEditionComponent(editingContext,
                        editingContext.getEObject(), mode);
            }
        }
        return super.getPropertiesEditingComponent(editingContext, mode, part, refinement);
    }

}
