/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1reloj;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;


/**
 *
 * @author guill
 */
public class Lab1Reloj implements GLEventListener{

  public static void main(String[] args) {
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        
        // Canvas
        final GLCanvas glcanvas =  new GLCanvas(capabilities);
        Lab1Reloj b = new Lab1Reloj();
        
        glcanvas.addGLEventListener(b);
        glcanvas.setSize(500,500);
        
        // Creamos frame
        
        final JFrame frame = new JFrame("Reloj Guillermo Souto");
        
        // Adicionamos el canvas
        // Asociamos el canvas al frame
        frame.getContentPane().add(glcanvas);
        
        //Colocamos el tamaño del frame al tamaño del canvas
        frame.setSize(frame.getContentPane().getPreferredSize());
        
        //Asociar el cierre del frame para liberar memoria
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                
        //Centrar el frame
        frame.setLocationRelativeTo(null);
        
        //Volve visible el Frame
        frame.setVisible(true);
    }

    @Override
    public void init(GLAutoDrawable glad) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable glad) {
        final GL2 gl = glad.getGL().getGL2();
        
        // Dibujar el Circulo con Líneas
        gl.glColor3f(10, 41, 255);  
        gl.glBegin(GL2.GL_LINE_LOOP);
            for(int i=0; i<100; i++){
                float x = (float) Math.cos(i * 2 * Math.PI/100);
                float y = (float) Math.sin(i * 2 * Math.PI/100);
                gl.glVertex2f(x, y);
            }
        gl.glEnd();

        // Dibujar el circulo con Poligonos Externo 
        gl.glColor3f(255f, 255f, 255f);
        gl.glBegin(GL2.GL_POLYGON);
            for(int i=0; i<100; i++){
                float x = (float) Math.cos(i * 2 * Math.PI/100);
                float y = (float) Math.sin(i * 2 * Math.PI/100);
                gl.glVertex2f(x, y);
            }
        gl.glEnd();
        
        // Dibujar el circulo con Poligonos Interno
        gl.glColor3f(0f, 0f, 0f);  
        gl.glBegin(GL2.GL_POLYGON);
            for(int i=0; i<100; i++){
                float x = (float) Math.cos(i * 2 * Math.PI/100);
                float y = (float) Math.sin(i * 2 * Math.PI/100);
                x=(float) (x*0.03);
                y=(float) (y*0.03);
                gl.glVertex2f(x, y);
            }
        gl.glEnd();

        // Dibujar los puntos dentro del circulo 
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glPointSize(5.0f);
        gl.glBegin(gl.GL_POINTS);
        for (int i = 1; i <= 12; i++) {
            double theta = 2.0 * Math.PI * i / 12.0;
            double x = 0.9 * Math.cos(theta);
            double y = 0.9 * Math.sin(theta);
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
              
        //Manecilla de la Hora
        
        gl.glBegin(GL2.GL_LINES);
        
            gl.glColor3f(0f, 255f, 0f);
            gl.glVertex2f(0, 0);
            gl.glVertex2f(-0.2f, 0.4f);
            
         //Manecillas de los minutos
         
            gl.glColor3f(0f, 0f, 255f);
            gl.glVertex2f(0, 0);
            gl.glVertex2f(0.1f, 0.6f);
            
         //Manecillas de los segundos(naranja)
         
            gl.glColor3f(1, 0.55f, 0.2f);
            gl.glVertex2f(0, 0);
            gl.glVertex2f(-0.2f, -0.5f);
            
        
        gl.glEnd();
        
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

