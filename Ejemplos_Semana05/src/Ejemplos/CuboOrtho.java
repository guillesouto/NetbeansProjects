/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplos;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.DisplayMode;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


import com.jogamp.opengl.util.Animator;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author guill
 */
public class CuboOrtho implements GLEventListener{
 static GL2 gl;
    static GLU glu;
    static Toolkit miPantalla = Toolkit.getDefaultToolkit();
    static Dimension dimension = miPantalla.getScreenSize();
    
    public static void main(String[] args) {
        Frame frame = new Frame("Cubo 3D");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new CuboOrtho());
        frame.add(canvas);
        frame.setSize(dimension.width/2, dimension.height/2);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {

        glu = new GLU();
            gl = drawable.getGL().getGL2();
            gl.glClearColor(0, 0, 0, 1);
            gl.glMatrixMode(gl.GL_PROJECTION);
            glu.gluOrtho2D(0, dimension.width, 0, dimension.height);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();

        if (height <= 0) {
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60.0f, h, 1.0, 40.0);
        gl.glTranslated(0, 0, -15);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();
        
    }

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
//        gl.glScaled(2.0, 2.0, 2.0);
//        gl.glRotated(30, 0, 1, 0);
//        gl.glTranslated(5, -2, 1);

        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(-3.0f, 0.0f, -2.0f);
        gl.glVertex3f(0.0f, 1.0f, -4.0f);
        gl.glVertex3f(3.0f, 0.0f, -2.0f);
        gl.glVertex3f(0.0f, -1.0f, 0.0f);
        gl.glEnd();
        
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(-3.0f, 3.0f, -2.0f);
        gl.glVertex3f(0.0f, 4.0f, -4.0f);
        gl.glVertex3f(0.0f, 1.0f, -4.0f);
        gl.glVertex3f(-3.0f, 0.0f, -2.0f);
        gl.glEnd();
        
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, .0f);
        gl.glVertex3f(0.0f, 4.0f, -4.0f);
        gl.glVertex3f(3.0f, 3.0f, -2.0f);
        gl.glVertex3f(3.0f, 0.0f, -2.0f);
        gl.glVertex3f(0.0f, 1.0f, -4.0f);
        gl.glEnd();

        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 2.0f, 0.0f);
        gl.glVertex3f(3.0f, 3.0f, -2.0f);
        gl.glVertex3f(3.0f, 0.0f, -2.0f);
        gl.glVertex3f(0.0f, -1.0f, 0.0f);
        gl.glEnd();
        
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(-3.0f, 3.0f, -2.0f);
        gl.glVertex3f(0.0f, 2.0f, 0.0f);
        gl.glVertex3f(0.0f, -1.0f, 0.0f);
        gl.glVertex3f(-3.0f, 0.0f, -2.0f);
        gl.glEnd();
        
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 4.0f, -4.0f);
        gl.glVertex3f(3.0f, 3.0f, -2.0f);
        gl.glVertex3f(0.0f, 2.0f, 0.0f);
        gl.glVertex3f(-3.0f, 3.0f, -2.0f);
        gl.glEnd();
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
