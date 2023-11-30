package Ejemplos;


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;





/**
 * EjemploCubo3D.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class EjemploCubo3D implements GLEventListener {
    public static DisplayMode dm,dm_old;
    private GLU glu =  new GLU();
    private float rquad = 0.0f;
    
    public static void main(String[] args) {
        Frame frame = new Frame("Ejemplo Cubo");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new EjemploCubo3D());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }
@Override
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL2 gl = drawable.getGL().getGL2();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(gl.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }
@Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
@Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // Clear the drawing area
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        gl.glTranslatef(0.0f, 0.0f, -5.0f);
        
        gl.glRotatef(rquad,1.0f,1.0f,1.0f);
        
        gl.glBegin(gl.GL_QUADS);
        //Rojo
            gl.glColor3f(1.0f, 0.5f, 0.0f);
            gl.glVertex3f(1f,1f,-1f);
            gl.glVertex3f(-1f,1f,-1f);
            gl.glVertex3f(-1f,1f,1f);
            gl.glVertex3f(1f,1f,1f);
            
            // Verde
            gl.glColor3f(0f,1f,0f);
            gl.glVertex3f(1f,-1f,1f);
            gl.glVertex3f(-1f,-1f,1f);
            gl.glVertex3f(-1f,-1f,-1f);
            gl.glVertex3f(1f,-1f,-1f);
            
    // Azul
            gl.glColor3f(0f,0f,1f);
            gl.glVertex3f(1f,1f,1f);
            gl.glVertex3f(-1f,1f,1f);
            gl.glVertex3f(-1f,-1f,1f);
            gl.glVertex3f(1f,-1f,1f);
            
//Amarrillo
            gl.glColor3f(1f,1f,0f);
            gl.glVertex3f(1f,-1f,-1f);
            gl.glVertex3f(-1f,-1f,-1f);
            gl.glVertex3f(-1f,1f,-1f);
            gl.glVertex3f(1f,1f,-1f);
// Purpura
            gl.glColor3f(1f,0f,1f);
            gl.glVertex3f(-1f,1f,1f);
            gl.glVertex3f(-1f,1f,-1f);
            gl.glVertex3f(-1f,-1f,-1f);
            gl.glVertex3f(-1f,-1f,1f);
// Azul claro
            gl.glColor3f(0f,1f,1f);
            gl.glVertex3f(1f,1f,-1f);
            gl.glVertex3f(1f,1f,1f);
            gl.glVertex3f(1f,-1f,1f);
            gl.glVertex3f(1f,-1f,-1f);            
        gl.glEnd();


        // Flush all drawing operations to the graphics card
        gl.glFlush();
        rquad -=0.10f;
    }


    @Override
    public void dispose(GLAutoDrawable glad) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }







 
}

