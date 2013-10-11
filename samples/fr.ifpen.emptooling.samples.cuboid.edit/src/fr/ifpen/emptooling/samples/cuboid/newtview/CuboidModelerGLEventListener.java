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

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GL2GL3;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.media.opengl.glu.GLU;

import org.eclipse.swt.widgets.Display;

import fr.ifpen.emptooling.samples.cuboid.Cuboid;
import fr.ifpen.emptooling.samples.cuboid.Scene;
import fr.ifpen.emptooling.samples.cuboid.SceneObj;
import fr.ifpen.emptooling.samples.newtview.NEWTGLEventListener;

/**
 * CuboidModelerGLEventListener:
 * <p>
 * Created on 12 mars 2012
 * 
 * @author schneids
 */
public class CuboidModelerGLEventListener extends NEWTGLEventListener {

    private float[] frontalLightPosition = new float[] { 0, 0, 0, 1 };

    private final float[] ambientLightParameters = new float[] { 0.1f, 0.1f, 0.1f, 1.f };

    private final float[] diffuseLightParameters = new float[] { 0.7f, 0.7f, 0.7f, 1.f };

    private final float[] specularLightParameters = new float[] { 0.f, 0.f, 0.f, 0.f };

    private Display display;

    private Scene scene;

    private float localRoty;

    public CuboidModelerGLEventListener(Display display) {
        this.display = display;
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
        final GLU glu = new GLU();

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
        gl.glLoadIdentity();

        glu.gluPerspective(45.0f, (double) width / (double) height, 0.1f, 1000.0f);

        gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        // don't forget to call the super init to permits parent stuff initialization
        super.init(drawable);
        // always get a fresh instance of GL to avoid using an invalidated GL one
        final GL2 gl = drawable.getGL().getGL2();
        // enable V-sync
        // gl.setSwapInterval(1);

        gl.glEnable(GLLightingFunc.GL_LIGHTING);
        gl.glEnable(GLLightingFunc.GL_LIGHT0);
        gl.glEnable(GLLightingFunc.GL_NORMALIZE);
        // gl.glLightModeli(GL2ES1.GL_LIGHT_MODEL_TWO_SIDE, GL.GL_TRUE);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_POSITION, frontalLightPosition, 0);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_AMBIENT, ambientLightParameters, 0);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_DIFFUSE, diffuseLightParameters, 0);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_SPECULAR, specularLightParameters,
                0);
        gl.glShadeModel(GLLightingFunc.GL_SMOOTH);
        // background color is white
        gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
        gl.glHint(GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        super.dispose(drawable);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        // update local variables from Scene data
        final int tx = scene.getTranslationX();
        final int ty = scene.getTranslationY();
        final int tz = scene.getTranslationZ();
        final float rotx = scene.getRotationX();
        final float roty = scene.getRotationY() + localRoty;
        final float rotz = scene.getRotationZ();

        // global scene transformation: translation and rotation
        gl.glTranslatef(tx, ty, tz);
        gl.glRotatef(rotx, 1.f, 0.f, 0.f);
        gl.glRotatef(roty, 0.f, 1.f, 0.f);
        gl.glRotatef(rotz, 0.f, 0.f, 1.f);

        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

        // draw Cuboids
        for (SceneObj cuboid : scene.getCubes()) {
            int x = cuboid.getPosX();
            int y = cuboid.getPosY();
            int z = cuboid.getPosZ();
            float r = cuboid.getRed() / 255.f;
            float g = cuboid.getGreen() / 255.f;
            float b = cuboid.getBlue() / 255.f;
            float a = cuboid.getOpacity() / 255.f;
            int lx = 0, ly = 0, lz = 0;
            if (cuboid instanceof Cuboid) {
                lx = ((Cuboid) cuboid).getLength();
                ly = ((Cuboid) cuboid).getHeight();
                lz = ((Cuboid) cuboid).getDepth();
            }
            // set the color
            float diffuseColor[] = new float[] { r, g, b, a };
            float emissionColor[] = new float[] { .0f, .0f, .0f, a };
            float specularColor[] = new float[] { .9f, .8f, .8f, a };
            float ambientColor[] = new float[] { 0.1f, .1f, .1f, a };
            float shininess = 50.f;
            gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GLLightingFunc.GL_EMISSION, emissionColor, 0);
            gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GLLightingFunc.GL_SPECULAR, specularColor, 0);
            gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GLLightingFunc.GL_DIFFUSE, diffuseColor, 0);
            gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GLLightingFunc.GL_AMBIENT, ambientColor, 0);
            gl.glMaterialfv(GL.GL_FRONT, GLLightingFunc.GL_SHININESS, new float[] { shininess }, 0);

            // rendering
            if (scene.isShowFaces()) {
                // gl.glLoadIdentity();
                // gl.glTranslatef(x, y, z);
                gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL2GL3.GL_FILL);
                gl.glEnable(GL.GL_POLYGON_OFFSET_FILL);
                gl.glPolygonOffset(0.5f, 0.5f);
                gl.glColor4f(r, g, b, a);
                renderCuboidDirect(gl, x, y, z, lx, ly, lz);
            }

            // wireFrame
            if (scene.isShowWires()) {
                // darker color for wires
                for (int i = 0; i < 3; i++) {
                    diffuseColor[i] = diffuseColor[i] * .6f;
                }
                // render wireframe
                gl.glPushAttrib(GL2.GL_ENABLE_BIT);

                gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL2GL3.GL_LINE);
                gl.glDisable(GL.GL_POLYGON_OFFSET_FILL);
                gl.glLineWidth(2);

                if (gl.glIsEnabled(GLLightingFunc.GL_LIGHTING)) {
                    gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GLLightingFunc.GL_EMISSION,
                            emissionColor, 0);
                    gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GLLightingFunc.GL_SPECULAR,
                            specularColor, 0);
                    gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GLLightingFunc.GL_AMBIENT, ambientColor,
                            0);
                    gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GLLightingFunc.GL_DIFFUSE, diffuseColor,
                            0);
                }
                else {
                    gl.glColor4fv(diffuseColor, 0);
                }

                // rendering
                renderCuboidDirect(gl, x, y, z, lx, ly, lz);

                // restoring gl states
                gl.glPopAttrib();
                gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL2GL3.GL_FILL);
            }

        }
        gl.glDisable(GL.GL_BLEND);

        // drawPyramid(gl);

        // update the Scene model if needed
        if (scene.isRotate()) {
            display.asyncExec(new Runnable() {
                @Override
                public void run() {
                    // update scene rotation
                    if (localRoty + .2f >= 360.f) {
                        localRoty = 0.f;
                    }
                    else {
                        localRoty = localRoty + .2f;
                    }
                }
            });
        }

        // some debug bonus info !
        super.displayDebugText(drawable);
    }

    private void renderCuboidDirect(GL2 gl, int x, int y, int z, int lx, int ly, int lz) {
        gl.glBegin(GL2.GL_QUADS);
        // face 1 - front
        gl.glNormal3f(0.f, 0.f, -1.f);
        gl.glVertex3f(x, y, z);
        gl.glNormal3f(0.f, 0.f, -1.f);
        gl.glVertex3f(x + lx, y, z);
        gl.glNormal3f(0.f, 0.f, -1.f);
        gl.glVertex3f(x + lx, y + ly, z);
        gl.glNormal3f(0.f, 0.f, -1.f);
        gl.glVertex3f(x, y + ly, z);
        // face 2 - right
        gl.glNormal3f(1.f, 0.f, 0.f);
        gl.glVertex3f(x + lx, y, z);
        gl.glNormal3f(1.f, 0.f, 0.f);
        gl.glVertex3f(x + lx, y, z + lz);
        gl.glNormal3f(1.f, 0.f, 0.f);
        gl.glVertex3f(x + lx, y + ly, z + lz);
        gl.glNormal3f(1.f, 0.f, 0.f);
        gl.glVertex3f(x + lx, y + ly, z);
        // face 3 - back
        gl.glNormal3f(0.f, 0.f, 1.f);
        gl.glVertex3f(x + lx, y, z + lz);
        gl.glNormal3f(0.f, 0.f, 1.f);
        gl.glVertex3f(x, y, z + lz);
        gl.glNormal3f(0.f, 0.f, 1.f);
        gl.glVertex3f(x, y + ly, z + lz);
        gl.glNormal3f(0.f, 0.f, 1.f);
        gl.glVertex3f(x + lx, y + ly, z + lz);
        // face 4 - left
        gl.glNormal3f(-1.f, 0.f, 0.f);
        gl.glVertex3f(x, y, z + lz);
        gl.glNormal3f(-1.f, 0.f, 0.f);
        gl.glVertex3f(x, y, z);
        gl.glNormal3f(-1.f, 0.f, 0.f);
        gl.glVertex3f(x, y + ly, z);
        gl.glNormal3f(-1.f, 0.f, 0.f);
        gl.glVertex3f(x, y + ly, z + lz);
        // face 5 - top
        gl.glNormal3f(0.f, 1.f, 0.f);
        gl.glVertex3f(x, y + ly, z);
        gl.glNormal3f(0.f, 1.f, 0.f);
        gl.glVertex3f(x + lx, y + ly, z);
        gl.glNormal3f(0.f, 1.f, 0.f);
        gl.glVertex3f(x + lx, y + ly, z + lz);
        gl.glNormal3f(0.f, 1.f, 0.f);
        gl.glVertex3f(x, y + ly, z + lz);
        // face 6 - top
        gl.glNormal3f(0.f, -1.f, 0.f);
        gl.glVertex3f(x, y, z);
        gl.glNormal3f(0.f, -1.f, 0.f);
        gl.glVertex3f(x + lx, y, z);
        gl.glNormal3f(0.f, -1.f, 0.f);
        gl.glVertex3f(x + lx, y, z + lz);
        gl.glNormal3f(0.f, -1.f, 0.f);
        gl.glVertex3f(x, y, z + lz);
        gl.glEnd();
    }

    public void setInput(Scene scene) {
        this.scene = scene;
    }

    protected void setSceneTranslation(final float t) {
        // update the Scene model
        display.asyncExec(new Runnable() {
            @Override
            public void run() {
                scene.setTranslationZ((int) t);
            }
        });
    }

    protected float getSceneTranslation() {
        return scene.getTranslationZ();
    }

}
