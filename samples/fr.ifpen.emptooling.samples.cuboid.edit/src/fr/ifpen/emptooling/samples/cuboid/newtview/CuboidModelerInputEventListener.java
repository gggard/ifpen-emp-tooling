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
package fr.ifpen.emptooling.samples.cuboid.newtview;

import com.jogamp.newt.event.MouseEvent;

import fr.ifpen.emptooling.samples.newtview.NEWTInputEventListener;

/**
 * CubeModelerInputEventListener:
 * <p>
 * Created on 14 mars 2012
 * 
 * @author schneids
 */
public class CuboidModelerInputEventListener extends NEWTInputEventListener {

    private CuboidModelerGLEventListener glListener = null;

    public CuboidModelerInputEventListener(CuboidModelerGLEventListener glListener) {
        this.glListener = glListener;
    }

    @Override
    public void mouseWheelMoved(MouseEvent e) {
        super.mouseWheelMoved(e);
        int wheelRotation = e.getWheelRotation();
        glListener.setSceneTranslation(glListener.getSceneTranslation() + wheelRotation);
    }
}
