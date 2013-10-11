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
package fr.ifpen.emptooling.samples.newtview;

import java.awt.Font;

import javax.media.opengl.GL;
import javax.media.opengl.GL2ES2;
import javax.media.opengl.GLAnimatorControl;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

import com.jogamp.opengl.util.awt.TextRenderer;

/**
 * NEWTGLEventListener: this class must be derived in client code to provide proper GL rendering
 * implementation.
 * <p>
 * This basic implementation provides text rendering service to client code. To be able to use it,
 * don't forget to call this init method.
 * <p>
 * Created on 12 mars 2012
 * 
 * @author schneids
 */
public class NEWTGLEventListener implements GLEventListener {

    private static final boolean FONT_ANTIALIASING = false;

    // font properties, can be changed by client code before initialization
    protected String fontName = "SansSerif";

    protected int fontStyle = Font.PLAIN;

    protected int fontSize = 9;

    protected boolean displayDebugText = true;

    // black color by default
    protected float debugTextColor[] = new float[] { 0.f, 0.f, 0.f, 1.f };

    private TextRenderer textRenderer = null;

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see javax.media.opengl.GLEventListener#init(javax.media.opengl.GLAutoDrawable)
     */
    @Override
    public void init(GLAutoDrawable drawable) {
        textRenderer = new TextRenderer(new Font(fontName, fontStyle, fontSize), FONT_ANTIALIASING,
                true);
    }

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see javax.media.opengl.GLEventListener#dispose(javax.media.opengl.GLAutoDrawable)
     */
    @Override
    public void dispose(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub

    }

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see javax.media.opengl.GLEventListener#display(javax.media.opengl.GLAutoDrawable)
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub

    }

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see javax.media.opengl.GLEventListener#reshape(javax.media.opengl.GLAutoDrawable, int, int, int, int)
     */
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        // TODO Auto-generated method stub

    }

    /**
     * This method can be called from the display method of a specialized client implementation
     * 
     * @param drawable
     */
    protected void displayDebugText(GLAutoDrawable drawable) {
        if (textRenderer != null && displayDebugText) {
            // display some debug text
            int width = drawable.getWidth();
            int height = drawable.getHeight();
            GLAnimatorControl animator = drawable.getAnimator();
            GL gl = drawable.getGL();
            textRenderer.beginRendering(width, height, true);
            textRenderer.setColor(debugTextColor[0], debugTextColor[1], debugTextColor[2],
                    debugTextColor[3]);
            // display FPS
            int lastFPS = (int) animator.getLastFPS();
            int lastFTime = (int) (animator.getLastFPSPeriod() / animator.getUpdateFPSFrames());
            int totalFPS = (int) animator.getTotalFPS();
            textRenderer.draw("Rendering time: " + lastFTime + "ms; FPS: " + totalFPS
                    + "; TRUE FPS=" + lastFPS, 5, height - 10);
            // display GL Version
            String glVersion = gl.glGetString(GL.GL_VERSION);
            if (Integer.parseInt(glVersion.substring(0, 1)) >= 2) {
                glVersion += "; GLSL=" + gl.glGetString(GL2ES2.GL_SHADING_LANGUAGE_VERSION);
                textRenderer.draw("GL=" + glVersion, 230, height - 10);
            }
            // end rendering
            textRenderer.endRendering();
        }
    }

    /**
     * Permits specialized client code to use the TextRenderer
     * 
     * @return
     */
    protected TextRenderer getTextRenderer() {
        return textRenderer;
    }
}
