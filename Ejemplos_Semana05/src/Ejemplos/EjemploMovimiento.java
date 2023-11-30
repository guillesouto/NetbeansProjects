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
public class EjemploMovimiento implements GLEventListener, KeyListener  {

    /**
     * @param args the command line arguments
     */
    private GLU glu = new GLU();
    private GLUT glut = new GLUT();

    double rotate_y = 0;
    double rotate_x = 0;
    
    public static void main(String[] args) {
       //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      EjemploMovimiento l= new EjemploMovimiento();
      glcanvas.addGLEventListener(l);
      glcanvas.addKeyListener(l);
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
        /* * * * * * * Fin de la funcion retrollamdo *******/

/*****  Rotar cuando el usuario cambie “rotate_x” y “rotate_y” *****/

        gl.glRotatef((float) rotate_x, 1.0f, 0.0f, 0.0f);
        gl.glRotatef((float) rotate_y, 0.0f, 1.0f, 0.0f);

        /**
         * ***** Fin de la función rotar ******
         */

        /*Inicio de la ubicación y pigmentación de las ras o tapas del cubo*/
//LADO FRONTAL: lado multicolor
        gl.glBegin(gl.GL_POLYGON);

        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.5f, -0.5f, -0.5f); // P1 es rojo
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.5f, 0.5f, -0.5f); // P2 es verde
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(-0.5f, 0.5f, -0.5f); // P3 es azul
        gl.glColor3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(-0.5f, -0.5f, -0.5f); // P4 es morado

        gl.glEnd();

        /* las función glColor3f() es para asignar el color y en cambio las función glVrtyix3f() es para asignar vértices, con las dos combinadas podemos generar un mosaico  de colores*/

 /*FIN DE LA CARA 1*/
// LADO TRASERO: 
        gl.glBegin(gl.GL_POLYGON);

        gl.glColor3f(-1.0f, 1.0f, -1.6f); // color de la cara o tapa
        gl.glVertex3f(0.5f, -0.5f, 0.5f);
        gl.glVertex3f(0.5f, 0.5f, 0.5f);
        gl.glVertex3f(-0.5f, 0.5f, 0.5f);
        gl.glVertex3f(-0.5f, -0.5f, 0.5f);

        gl.glEnd();

// LADO DERECHO:
        gl.glBegin(gl.GL_POLYGON);
        gl.glColor3f(1.0f, 0.5f, 0.1f); // color de la cara o tapa
        gl.glVertex3f(0.5f, -0.5f, -0.5f);
        gl.glVertex3f(0.5f, 0.5f, -0.5f);
        gl.glVertex3f(0.5f, 0.5f, 0.5f);
        gl.glVertex3f(0.5f, -0.5f, 0.5f);
        gl.glEnd();

// LADO IZQUIERDO: 
        gl.glBegin(gl.GL_POLYGON);
        gl.glColor3f(1.0f, -2.8f, 1.0f); // color de la cara o tapa
        gl.glVertex3f(-0.5f, -0.5f, 0.5f);
        gl.glVertex3f(-0.5f, 0.5f, 0.5f);
        gl.glVertex3f(-0.5f, 0.5f, -0.5f);
        gl.glVertex3f(-0.5f, -0.5f, -0.5f);
        gl.glEnd();
// LADO SUPERIOR: 
        gl.glBegin(gl.GL_POLYGON);
        gl.glColor3f(1.0f, -4.0f, -1.0f); // color de la cara o tapa
        gl.glVertex3f(0.5f, 0.5f, 0.5f);
        gl.glVertex3f(0.5f, 0.5f, -0.5f);
        gl.glVertex3f(-0.5f, 0.5f, -0.5f);
        gl.glVertex3f(-0.5f, 0.5f, 0.5f);
        gl.glEnd();
// LADO INFERIOR: 
        gl.glBegin(gl.GL_POLYGON);
        gl.glColor3f(1.0f, -3.8f, -1.0f); // color de la cara o tapa
        gl.glVertex3f(0.5f, -0.5f, -0.5f);
        gl.glVertex3f(0.5f, -0.5f, 0.5f);
        gl.glVertex3f(-0.5f, -0.5f, 0.5f);
        gl.glVertex3f(-0.5f, -0.5f, -0.5f);
        gl.glEnd();
        
        rotate_y += 0.5;
       rotate_x += 0.5;

        gl.glFlush(); //NOTA: dan el efecto de doble-buffer.
       // glut.glutSwapBuffers(); //NOTA: dan el efecto de doble-buffer.
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            // no hace falta llamar al método Animator#stop()
            System.exit(0);
        } // La flecha derecha: incrementa su rotación en 5 grados
        else if (e.getKeyCode() == KeyEvent.VK_KP_RIGHT) {
            System.out.println("Derecha");
            rotate_y += 5;
        } // La flecha izquierda: disminuye su rotación en 5 grados
        else if (e.getKeyCode() == KeyEvent.VK_KP_LEFT) {
            System.out.println("Izqyuerda");
            rotate_y -= 5;
        } else if (e.getKeyCode() == KeyEvent.VK_KP_UP) {
            System.out.println("Arriba");
            rotate_x += 5;
        } else if (e.getKeyCode() == KeyEvent.VK_KP_DOWN) {
            System.out.println("Abajo");
            rotate_x -= 5;
        }
        //glu.glutPostRedisplay();
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Solto");
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("Dio");
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
