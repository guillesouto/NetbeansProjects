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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author roger
 */
public class Ejemplo01 implements GLEventListener, KeyListener {

    /**
     * @param args the command line arguments
     */
    private GLU glu = new GLU();
    private GLUT glut=new GLUT();
    
    public static void main(String[] args) {
       //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Ejemplo01 l= new Ejemplo01();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
   
      //creating frame
      final JFrame frame = new JFrame ("Forma Base");
   
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
          
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      final FPSAnimator animator = new FPSAnimator(glcanvas, 400, true);
      animator.start();      
      
    }

    @Override
    public void init(GLAutoDrawable glad) {
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
    }

    @Override
    public void display(GLAutoDrawable glad) {
        final GL2 gl = glad.getGL().getGL2(); 
 
      

        // Define shapes enclosed within a pair of glBegin and glEnd
        gl.glBegin(gl.GL_QUADS);              // Each set of 4 vertices form a quad
        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
        gl.glVertex2f(-0.8f, 0.1f);     // Define vertices in counter-clockwise (CCW) order
        gl.glVertex2f(-0.2f, 0.1f);     //  so that the normal (front-face) is facing you
        gl.glVertex2f(-0.2f, 0.7f);
        gl.glVertex2f(-0.8f, 0.7f);

        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
        gl.glVertex2f(-0.7f, -0.6f);
        gl.glVertex2f(-0.1f, -0.6f);
        gl.glVertex2f(-0.1f, 0.0f);
        gl.glVertex2f(-0.7f, 0.0f);

        gl.glColor3f(0.2f, 0.2f, 0.2f); // Dark Gray
        gl.glVertex2f(-0.9f, -0.7f);
        gl.glColor3f(1.0f, 1.0f, 1.0f); // White
        gl.glVertex2f(-0.5f, -0.7f);
        gl.glColor3f(0.2f, 0.2f, 0.2f); // Dark Gray
        gl.glVertex2f(-0.5f, -0.3f);
        gl.glColor3f(1.0f, 1.0f, 1.0f); // White
        gl.glVertex2f(-0.9f, -0.3f);
        gl.glEnd();

        gl.glBegin(gl.GL_TRIANGLES);          // Each set of 3 vertices form a triangle
        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
        gl.glVertex2f(0.1f, -0.6f);
        gl.glVertex2f(0.7f, -0.6f);
        gl.glVertex2f(0.4f, -0.1f);

        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
        gl.glVertex2f(0.3f, -0.4f);
        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
        gl.glVertex2f(0.9f, -0.4f);
        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
        gl.glVertex2f(0.6f, -0.9f);
        gl.glEnd();

        gl.glBegin(gl.GL_POLYGON);            // These vertices form a closed polygon
        gl.glColor3f(1.0f, 1.0f, 0.0f); // Yellow
        gl.glVertex2f(0.4f, 0.2f);
        gl.glVertex2f(0.6f, 0.2f);
        gl.glVertex2f(0.7f, 0.4f);
        gl.glVertex2f(0.6f, 0.6f);
        gl.glVertex2f(0.4f, 0.6f);
        gl.glVertex2f(0.3f, 0.4f);
        gl.glEnd();

        gl.glFlush();  // Render now       
    }
    void onkey(int key, int scancode, int action, int mods)  {
    System.out.println("Tecla:"+key);
}
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int width, int height) {
        GL2 gl = glad.getGL().getGL2();

        if (height <= 0) {
            height = 1;
        }
        float aspect = width / height;
        gl.glViewport(0, 0, width, height);

        // Set the aspect ratio of the clipping area to match the viewport
        gl.glMatrixMode(gl.GL_PROJECTION);  // To operate on the Projection matrix
        gl.glLoadIdentity();             // Reset the projection matrix
        if (width >= height) {
            // aspect >= 1, set the height from -1 to 1, with larger width
            glu.gluOrtho2D(-1.0 * aspect, 1.0 * aspect, -1.0, 1.0);
        } else {
            // aspect < 1, set the width to -1 to 1, with larger height
            glu.gluOrtho2D(-1.0, 1.0, -1.0 / aspect, 1.0 / aspect);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("1"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("2"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println("3");//To change body of generated methods, choose Tools | Templates.
    }
    
}
