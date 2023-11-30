package Ejemplos;


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




/**
 * EjemploEsfera.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class EjemploEsfera implements GLEventListener {
        GLUT glut = new GLUT();
        
        GLU glu = new GLU();
        
        float velRotacion=0;
    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener((GLEventListener) new EjemploEsfera());
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
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        
        velRotacion += 2.0f; //Velocidad a la que rota la esfera         
//Borrar el �rea de dibujo         
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
//Restablecer la matriz actual a la "identidad"         
        gl.glLoadIdentity();
//creamos la ESFERA         
        gl.glTranslatef(0.0f, 0.0f, -1.0f);
//Permite enfocar la esfera         
        gl.glRotatef(velRotacion, 0.0f, 0.0f, -2.0f);
//Permite la rotaci�n de la esfera         
        gl.glColor3f(0.6f, 0.5f, 0.7f);
        glu.gluLookAt(1, 1, 5, 0, 0, 0, 1, 1, 0);
        glut.glutWireSphere(2d, 40, 50);
        gl.glFlush();
/*
        int i = 0;
        int j = 0;
        float radio = 0.5f;
        float teta;
        float phi;
        float porcentajex = 0;
        float porcentajey = 1;
        float incrementox = (float) (1 / ((float) 2 * ResolucionEsfera)); //1/20
        float incrementoy = (float) (-1 / ((float) ResolucionEsfera)); //1/10
        float increRad = (float) (PI / ResolucionEsfera);
        float Vertice1x, Vertice1y, Vertice1z = 0;
        float Vertice2x, Vertice2y, Vertice2z = 0;
        float Vertice3x, Vertice3y, Vertice3z = 0;
        float Vertice4x, Vertice4y, Vertice4z = 0;
        //-----------\/---------Construcci�n de la esfera poco a poco---------------
            if (FinalPhi < 2 * PI) {
            FinalPhi += increRad / 50;/*FinalPhi=2*PI;
        }
        if (FinalTeta < PI) {
            FinalTeta += increRad / 100;/*FinalTeta=(float)PI;
        }
        //-----------/\---------Construcci�n de la esfera poco a poco---------------
        for (teta = 0; teta < FinalTeta; teta += increRad) {
            for (phi = 0; phi < FinalPhi; phi += increRad) {
                //VERTICE 1
                Vertice1z = (radio) * ((float) sin(teta)) * ((float) cos(phi));
                Vertice1x = (radio) * ((float) sin(teta)) * ((float) sin(phi));
                Vertice1y = (radio) * ((float) cos(teta));
                //VERTICE 2
                Vertice2z = (radio) * ((float) sin(teta + increRad)) * ((float) cos(phi));
                Vertice2x = (radio) * ((float) sin(teta + increRad)) * ((float) sin(phi));
                Vertice2y = (radio) * ((float) cos(teta + increRad));
                //VERTICE 3
                Vertice3z = (radio) * ((float) sin(teta + increRad)) * ((float) cos(phi + increRad));
                Vertice3x = (radio) * ((float) sin(teta + increRad)) * ((float) sin(phi + increRad));
                Vertice3y = (radio) * ((float) cos(teta + increRad));
                //VERTICE 4
                Vertice4z = (radio) * ((float) sin(teta)) * ((float) cos(phi + increRad));
                Vertice4x = (radio) * ((float) sin(teta)) * ((float) sin(phi + increRad));
                Vertice4y = (radio) * ((float) cos(teta));

                glNormal3f((float) 1.5 * sin(teta) * sin(phi), (float) 1.5 * cos(teta), (float) 1.5 * sin(teta) * cos(phi));

                glBegin(GL_TRIANGLES);
                //TRIANGULO 1
                glTexCoord2f(porcentajex, porcentajey);
                glVertex3f(Vertice1x, Vertice1y, Vertice1z);
                glTexCoord2f(porcentajex, porcentajey + incrementoy);
                glVertex3f(Vertice2x, Vertice2y, Vertice2z);
                glTexCoord2f(porcentajex + incrementox, porcentajey + incrementoy);
                glVertex3f(Vertice3x, Vertice3y, Vertice3z);
                //TRIANGULO
                glTexCoord2f(porcentajex, porcentajey);
                glVertex3f(Vertice1x, Vertice1y, Vertice1z);
                glTexCoord2f(porcentajex + incrementox, porcentajey + incrementoy);
                glVertex3f(Vertice3x, Vertice3y, Vertice3z);
                glTexCoord2f(porcentajex + incrementox, porcentajey);
                glVertex3f(Vertice4x, Vertice4y, Vertice4z);

                glEnd();

                porcentajex += incrementox;
            }
            porcentajey += incrementoy;
            porcentajex = 0;
        }
*/
    
        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
   //
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

