package Ejemplos;


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




/**
 * EjemploTriangulo.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class EjemploTriangulo implements GLEventListener {
   private GLU glu = new GLU();
   private float rtri = 0.0f;
   
    public static void main(String[] args) {
        Frame frame = new Frame("Ejemplo Tri�ngulo en 3D");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new EjemploTriangulo());
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
         final GL2 gl = drawable.getGL().getGL2();
	
   gl.glShadeModel(gl.GL_SMOOTH);
   gl.glClearColor(0f, 0f, 0f, 0f);
   gl.glClearDepth(1.0f);
   gl.glEnable(gl.GL_DEPTH_TEST);
   gl.glDepthFunc(gl.GL_LEQUAL);
   gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);  // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

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
        glu.gluPerspective(45.0f, h, 1.0, 10.0);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();
        
        
              // TODO Auto-generated method stub
      
    }
@Override
    public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();

    
      
      gl.glShadeModel( gl.GL_SMOOTH );
      gl.glClearColor( 0f, 0f, 0f, 0f );
      gl.glClearDepth( 1.0f );
      gl.glEnable( gl.GL_DEPTH_TEST );
      gl.glDepthFunc( gl.GL_LEQUAL );
      gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);

      // Clear The Screen And The Depth Buffer
      gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT); 
      gl.glLoadIdentity(); // Reset The View
      gl.glTranslatef( -0.5f,0.0f,-6.0f ); // Move the triangle
      gl.glRotatef( rtri, 0.0f, 1.0f, 0.0f );
      
      gl.glBegin( gl.GL_TRIANGLES ); 
        
      //drawing triangle in all dimensions
      // Front
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top Of Triangle (Front)
		
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Left Of Triangle (Front)
		
      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Right Of Triangle (Front)
        
      // Right
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top Of Triangle (Right)
		
      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Left Of Triangle (Right)
		
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Right Of Triangle (Right)
        
      // Left
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top Of Triangle (Back)
		
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Left Of Triangle (Back)
		
      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Right Of Triangle (Back)
        
      //left
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Red
      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top Of Triangle (Left)
		
      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Left Of Triangle (Left)
		
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Right Of Triangle (Left)
		
      gl.glEnd(); // Done Drawing 3d triangle (Pyramid)
      gl.glFlush();
      rtri += 0.2f;
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
   //
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

  

  

  
}

