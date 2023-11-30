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
public class EjemploLineaCirculo implements GLEventListener {

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
      EjemploLineaCirculo l= new EjemploLineaCirculo();
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
        gl.glTranslatef(0.0f, 0.0f, -6.0f);   
        
        float angulo;
        int i;
        gl.glBegin(gl.GL_LINES);
        for (i = 0; i < 360; i += 5) {
            angulo = (float) i * 3.14159f / 180.0f; // grados a radianes  
            gl.glVertex3f(0.0f, 0.0f, 0.0f);
            float X=(float) Math.cos(angulo);;
            float Y=(float) Math.sin(angulo);
            gl.glVertex3f(X, Y, 0.0f);
        }
        gl.glEnd();         
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int width, int height) {
        GL2 gl = glad.getGL().getGL2();

        if (height <= 0) {
            height = 1;
        }

        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    
}
