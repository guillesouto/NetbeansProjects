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

/**
 *
 * @author roger
 */
public class EjemploCubo implements GLEventListener {

    /**
     * @param args the command line arguments
     */
    private GLU glu = new GLU();
    private GLUT glut=new GLUT();
    
    public static DisplayMode dm, dm_old;
    private float rquad = 0.025f; 
    
    public static void main(String[] args) {
       //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      EjemploCubo l= new EjemploCubo();
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
        //
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        //
    }

    @Override
    public void display(GLAutoDrawable glad) {
        final GL2 gl = glad.getGL().getGL2(); 
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0f, 0f, -5.0f);

        // Rotate The Cube On X, Y & Z
        gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f);

        //giving different colors to different sides
        gl.glBegin(gl.GL_QUADS); // Start Drawing The Cube
        gl.glColor3f(1f, 0f, 0f); //red color
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad (Top)
        gl.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The Quad (Top)

        gl.glColor3f(0f, 1f, 0f); //green color
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Right Of The Quad
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Top Left Of The Quad
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad 

        gl.glColor3f(0f, 0f, 1f); //blue color
        gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Front)
        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Front)
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad 

        gl.glColor3f(1f, 1f, 0f); //yellow (red + green)
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Back)
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Back)

        gl.glColor3f(1f, 0f, 1f); //purple (red + green)
        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Left)
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Left)
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad 

        gl.glColor3f(0f, 1f, 1f); //sky blue (blue +green)
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Right)
        gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The Quad
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad
        gl.glEnd(); // Done Drawing The Quad
        gl.glFlush();

       rquad -= 0.1f;      
        
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int width, int height) {
     final GL2 gl = glad.getGL().getGL2();
     
			
      final float h = ( float ) width / ( float ) height;
      gl.glViewport( 0, 0, width, height );
      gl.glMatrixMode( gl.GL_PROJECTION );
      gl.glLoadIdentity();
		
      glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
      gl.glMatrixMode( gl.GL_MODELVIEW );
      gl.glLoadIdentity();
    }
    
}
