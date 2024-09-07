/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphicsproject;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 *
 * @author DELL
 */
public class EventListener implements GLEventListener {
    public static GL2 gl;
    public static float ballX = 0, ballY = 1.8f, basketX = 0, basketY = -1.5f, pollX = 0.9f, pollY = 1.8f;
    public static int flagout = 0, count = 0 , score = 0;
    public static float ballSpeed = 0;
    public static ImageResourse image1 = null ;
    public static ImageResourse image2 = null ;
    public static ImageResourse image3 = null ;
    private GLUT glut;
    
    @Override
    public void init(GLAutoDrawable glad) {
        gl = glad.getGL().getGL2();
        gl.glClearColor(0.1608f, 0.3098f, 0.4078f, 1.0f);
        gl.glEnable(GL2.GL_TEXTURE_2D) ; 
        image1 = new ImageResourse("/res/basket10.png") ; 
        image2 = new ImageResourse("/res/sama2.jpg") ;
        image3 = new ImageResourse("/res/gameover1.jpg") ;
        glut = new GLUT();
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
    }
    
     void ball(GL2 gl) {
         //gl.glColor4f(0.9925f, 0.7886f, 0.3965f , 1);
         gl.glColor4f(1.0f, 0.5372f, 0.1176f, 1);
            GLU glu = new GLU();
            glu.gluSphere(glu.gluNewQuadric(), 0.10, 20, 20);
        }

        void basket(GL2 gl) {
            GraphicsProject.drawImage(image1);
        }

        void poll(GL2 gl) {
            gl.glColor3f( 0.7373f, 0.7412f, 0.7490f);
            GraphicsProject.drawImage2(image2);
        }
        void ground(GL2 gl){
            GraphicsProject.fillRect();
        }
        
        void gameOver(GL2 gl){
            GraphicsProject.drawGameOver(image3);
        }

    @Override
    public void display(GLAutoDrawable glad) {
        
        GL2 gl = glad.getGL().getGL2();
            gl.glClear(GL2.GL_COLOR_BUFFER_BIT );
            gl.glLoadIdentity();
            
            gl.glColor3f(1.0f, 1.0f, 1.0f); // White color for text
                gl.glRasterPos2f(-1.9f, 1.7f); // Position to draw the text
                String currentScoreText = "Score: " + score;
                for (char c : currentScoreText.toCharArray()) {
                   glut.glutBitmapCharacter(GLUT.BITMAP_TIMES_ROMAN_24, c);
                }
                gl.glFlush();
            
            if (count == 3) {
                ballSpeed += 0.008;
                count = 0;
            }

            if (ballY < -1.5 && (ballX > basketX - 0.3 && ballX < basketX + 0.3)) {
                score++;
                count++;
                ballY = 1.8f;
                int r = (int) (Math.random() * 4);
                if (r == 0) {
                    ballX = -1.7f;
                    pollX = -1.7f + 0.9f;
                }
                if (r == 1) {
                    ballX = -1f;
                    pollX = -1f + 0.9f;
                }
                if (r == 2) {
                    ballX = 1f;
                    pollX = 1f + 0.9f;
                }
                if (r == 3) {
                    ballX = 1.7f;
                    pollX = 1.7f + 0.9f;
                }
            }

            if (flagout == 0)
                ballY -= 0.02f + ballSpeed;

            if (ballY < -2) {
                flagout = 1;
                System.out.println("Game Over! Score: " + score);
                 
            }
            
            if (flagout == 1){
                gl.glPushMatrix();
                gl.glTranslatef(0, 0, 0); 
                gameOver(gl) ;
                gl.glPopMatrix();
                
                gl.glColor3f(1.0f, 1.0f, 1.0f); // White color for text
                gl.glRasterPos2f(0.001f, 1.7f); // Position to draw the text
                String scoreText = "Score: " + score;
                for (char c : scoreText.toCharArray()) {
                   glut.glutBitmapCharacter(GLUT.BITMAP_TIMES_ROMAN_24, c);
                }
                gl.glFlush();
            }
            else {
            
            gl.glPushMatrix();
            gl.glTranslatef(ballX, ballY, 0);
            ball(gl);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(basketX, basketY, 0);
            gl.glRotatef(90, 1, 0, 0);
            basket(gl);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(pollX, pollY, 0);
            gl.glScalef(1.5f, 0.4f, 1);
            poll(gl);
            gl.glPopMatrix();
          }
            gl.glFlush();
            ground(gl);
            
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
            gl = glad.getGL().getGL2();
            gl.glMatrixMode(GL2.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glOrtho(-2, 2, -2, 2, -2, 2);
            gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
