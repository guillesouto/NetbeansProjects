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
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author roger
 */
public class EjemploFigura3DAnimado implements GLEventListener {

    /**
     * @param args the command line arguments
     */
    private GLU glu = new GLU();
    private GLUT glut=new GLUT();
    
    float anglePyramid = 0.0f;  // Rotational angle for pyramid [NEW]
    float angleCube = 0.0f;     // Rotational angle for cube [NEW]
    int refreshMills = 15;        // refresh interval in milliseconds [NEW]
    
    public static void main(String[] args) {
       //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      EjemploFigura3DAnimado l= new EjemploFigura3DAnimado();
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
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();
        //gl.glTranslatef(0.0f, 0.0f, -6.0f);   
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT); // Clear color and depth buffers
        gl.glMatrixMode(gl.GL_MODELVIEW);     // To operate on model-view matrix

        // Render a color-cube consisting of 6 quads with different colors
        gl.glLoadIdentity();                 // Reset the model-view matrix
        gl.glTranslatef(1.5f, 0.0f, -7.0f);  // Move right and into the screen
        gl.glRotatef(angleCube, 1.0f, 1.0f, 1.0f);  // Rotate about (1,1,1)-axis [NEW]

        gl.glBegin(gl.GL_QUADS);                // Begin drawing the color cube with 6 quads
        // Top face (y = 1.0f)
        // Define vertices in counter-clockwise (CCW) order with normal pointing out
        gl.glColor3f(0.0f, 1.0f, 0.0f);     // Green
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);

        // Bottom face (y = -1.0f)
        gl.glColor3f(1.0f, 0.5f, 0.0f);     // Orange
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);

        // Front face  (z = 1.0f)
        gl.glColor3f(1.0f, 0.0f, 0.0f);     // Red
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);

        // Back face (z = -1.0f)
        gl.glColor3f(1.0f, 1.0f, 0.0f);     // Yellow
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);

        // Left face (x = -1.0f)
        gl.glColor3f(0.0f, 0.0f, 1.0f);     // Blue
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);

        // Right face (x = 1.0f)
        gl.glColor3f(1.0f, 0.0f, 1.0f);     // Magenta
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glEnd();  // End of drawing color-cube

        // Render a PIRAMIDE HECHA CON 4 TRIANGULOS
        
        gl.glLoadIdentity();                  // Reset the model-view matrix
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);  // Move left and into the screen
        gl.glRotatef(anglePyramid, 1.0f, 1.0f, 0.0f);  // Rotate about the (1,1,0)-axis [NEW]

        gl.glBegin(gl.GL_TRIANGLES);           // Begin drawing the pyramid with 4 triangles
        // Front
        gl.glColor3f(1.0f, 0.0f, 0.0f);     // Red
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f);     // Green
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f);     // Blue
        gl.glVertex3f(1.0f, -1.0f, 1.0f);

        // Right
        gl.glColor3f(1.0f, 0.0f, 0.0f);     // Red
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f);     // Blue
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f);     // Green
        gl.glVertex3f(1.0f, -1.0f, -1.0f);

        // Back
        gl.glColor3f(1.0f, 0.0f, 0.0f);     // Red
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f);     // Green
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f);     // Blue
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);

        // Left
        gl.glColor3f(1.0f, 0.0f, 0.0f);       // Red
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f);       // Blue
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f);       // Green
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glEnd();   // Done drawing the pyramid
        

        //gl.glutSwapBuffers();  // Swap the front and back frame buffers (double buffering)

        // Update the rotational angle after each refresh [NEW]
        anglePyramid += 0.2f;
        angleCube -= 0.15f;
}
 


    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int width, int height) {
        GL2 gl = glad.getGL().getGL2();

        if (height <= 0) {
            height = 1;
        }
// PROYECCIO PERSPECTIVA
    /*    final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    */    
// PROYECCION ORTOGONAL
        final float aspect = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);

        // Set the aspect ratio of the clipping volume to match the viewport
        gl.glMatrixMode(gl.GL_PROJECTION);  // To operate on the Projection matrix
        gl.glLoadIdentity();             // Reset

        // Set up orthographic projection view [NEW]
        if (width >= height) {
            // aspect >= 1, set the height from -1 to 1, with larger width
            gl.glOrtho(-3.0 * aspect, 3.0 * aspect, -3.0, 3.0, 0.1, 100);
        } else {
            // aspect < 1, set the width to -1 to 1, with larger height
            gl.glOrtho(-3.0, 3.0, -3.0 / aspect, 3.0 / aspect, 0.1, 100);
        }
    }
    
    
}
