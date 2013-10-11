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

import java.awt.Canvas;
import java.awt.Frame;

import javax.media.opengl.FPSCounter;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.jogamp.newt.Window;
import com.jogamp.newt.awt.NewtCanvasAWT;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.Animator;

/**
 * NEWTWidget:
 * <p>
 * Created on 12 mars 2012
 * 
 * @author schneids
 */
public class NEWTWidget extends Composite {

    /** the light-weight OpenGL rendering target */
    private GLAutoDrawable glAutoDrawable;

    /** AWT canvas in which OpenGL rendering occur */
    private Canvas canvas;

    /** helper that regularly updates the canvas */
    private Animator animator;

    static {
        // these properties have to be set very early at runtime to be efficient
        // remove flickering
        System.setProperty("sun.awt.noerasebackground", "true");
        // disable DirectDraw/Direct3D to avoid conflicts with OpenGL
        System.setProperty("sun.java2d.noddraw", "true");
        // enable the full Java2D/OpenGL pipeline
        System.setProperty("sun.java2d.opengl", "true");
        // prevent JOGL from loading jar from cache... (class loader exception in other case..)
        System.setProperty("jogamp.gluegen.UseTempJarCache", "false");
    }

    /**
     * @param parent
     * @param style
     */
    public NEWTWidget(Composite parent, int style, NEWTGLEventListener glListener,
            NEWTInputEventListener inputListener) {
        super(parent, style | SWT.EMBEDDED | SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE);

        // set the layout so our canvas fills the whole control
        setLayout(new FillLayout());

        final Frame frame = SWT_AWT.new_Frame(this);
        frame.setIgnoreRepaint(true);

        // get the profile
        GLProfile profile = GLProfile.getDefault();
        // this allows us to set particular properties for the GLCanvas
        GLCapabilities glCapabilities = new GLCapabilities(profile);

        // we don't need either of these, just an example
        glCapabilities.setDoubleBuffered(true);
        glCapabilities.setHardwareAccelerated(true);

        // NEWT Drawable (GLWindow)
        this.glAutoDrawable = GLWindow.create(glCapabilities);
        // and create the link between NEWT window and AWT container
        this.canvas = new NewtCanvasAWT((Window) glAutoDrawable);
        this.canvas.setFocusable(true);
        this.canvas.setIgnoreRepaint(true);
        frame.add(canvas);

        /*
         * Laying out the components before starting the animator is necessary because
         * the width of the canvas cannot be equal to zero and the SWT/AWT helper returns
         * AWT frames with a strange behavior (width and height equal to zero, lazy layout 
         * and validation). This call is not necessary in plain Swing/AWT applications.
         * */
        frame.doLayout();

        // register Input listener
        if (inputListener == null) {
            // default input listener are empty
            inputListener = new NEWTInputEventListener();
        }
        ((GLWindow) glAutoDrawable).addKeyListener(inputListener);
        ((GLWindow) glAutoDrawable).addMouseListener(inputListener);

        // register GL listener
        if (glListener == null) {
            // default GL listener for test purpose only
            glListener = new PyramidEventListener();
        }
        glAutoDrawable.addGLEventListener(glListener);

        // the main GL rendering loop
        animator = new Animator(glAutoDrawable);
        animator.setUpdateFPSFrames(FPSCounter.DEFAULT_FRAMES_PER_INTERVAL, null);
        animator.start();
    }

    @Override
    public boolean setFocus() {
        return super.setFocus();
    }

    @Override
    public void dispose() {
        // dispose of the JOGL resources
        if (glAutoDrawable != null) {
            glAutoDrawable.destroy();
        }
        super.dispose();
    }
}
