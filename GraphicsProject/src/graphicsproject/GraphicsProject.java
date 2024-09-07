/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphicsproject;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import java.util.ArrayList;
import java.util.Timer;

/**
 *
 * @author DELL
 */
public class GraphicsProject {
    public static GLWindow window = null ; 
    
    public static int ScreenWidth = 640 ;
    public static int ScreenHeight = 360 ;
    public static float unitsWide = 10 ;
    
    public static void init(){
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
                
        window = GLWindow.create(caps);
        window.setSize(640, 360);
        window.setResizable(true);
        window.addGLEventListener(new EventListener());
        window.addKeyListener(new KeyInput());
        window.setVisible(true);
        window.setTitle("Basket Game");
        
        FPSAnimator animator = new FPSAnimator(window , 40);
        animator.start();
    }
    
    public static int getWindowWidth(){
        return window.getWidth();
    }
    public static int getWindowHeight(){
        return window.getHeight();
    }
    
    public static void drawImage(ImageResourse image){
        GL2 gl = EventListener.gl ; 
        Texture tex = image.getTexture() ; 
        if (tex != null){
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        }
        gl.glColor4f(1 , 1 , 1 , 1);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(-0.15f, 0, -0.25f);
            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(0.15f, 0, -0.25f);  
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(0.15f, 0, 0.25f);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(-0.15f, 0, 0.25f);
        gl.glEnd();
        gl.glFlush();
        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
    }
    
    public static void fillRect(){
        GL2 gl = EventListener.gl ; 
        gl.glColor4f(1 , 1 , 1 , 1);
        gl.glBegin(GL2.GL_QUADS);
        
            gl.glColor4f(0.1608f, 0.3098f, 0.4078f , 1);
            gl.glVertex2f(-2.0f, -1.99f); // Vertex coordinate for top-right corner of the rectangle

            gl.glColor4f(1.0f, 0.5372f, 0.1176f, 1.0f);
            gl.glVertex2f(2.0f, -1.99f); // Vertex coordinate for top-left corner of the rectangle

            gl.glColor4f(1.0f, 0.5372f, 0.1176f, 1.0f);
            gl.glVertex2f(2.0f, -1.74f); // Vertex coordinate for bottom-left corner of the rectangle

            gl.glColor4f(0.1608f, 0.3098f, 0.4078f , 1);
            gl.glVertex2f(-2.0f, -1.74f);
            
        gl.glEnd();
    }
    
    public static void drawImage2(ImageResourse image){
        GL2 gl = EventListener.gl ; 
        Texture tex = image.getTexture() ; 
        if (tex != null){
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        }
        gl.glColor4f(1 , 1 , 1 , 1);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(-0.5f, -0.5f, 0.5f);
            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(0.5f, -0.5f, 0.5f);
            gl.glTexCoord2f(0, 1);
            gl.glVertex3f(0.5f, 0.5f, 0.5f);
            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(-0.5f, 0.5f, 0.5f);
            gl.glEnd();
        gl.glFlush();
        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
    }
    
    public static void drawGameOver(ImageResourse image){
        GL2 gl = EventListener.gl ; 
        Texture tex = image.getTexture() ; 
        if (tex != null){
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        }
        gl.glColor4f(1 , 1 , 1 , 1);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0, 0);
            gl.glVertex2f(-2, -2);
            gl.glTexCoord2f(1, 0);
            gl.glVertex2f(2, -2);
            gl.glTexCoord2f(1, 1);
            gl.glVertex2f(2, 2);
            gl.glTexCoord2f(0, 1);
            gl.glVertex2f(-2 , 2);
        gl.glEnd();
        gl.glFlush();
        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
    }
    
    public static void main(String[] args) {
        init();
    }
    
}
