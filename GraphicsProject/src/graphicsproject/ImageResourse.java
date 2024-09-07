/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphicsproject;

import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author DELL
 */
public class ImageResourse {
    
    private Texture texture = null ; 
    private BufferedImage image = null ; 
    private GLProfile profile = GLProfile.getDefault();
    
    public ImageResourse(String path){
        URL url = ImageResourse.class.getResource(path) ; 
        try{
            image = ImageIO.read(url) ; 
        }
        catch(IOException e){
            e.printStackTrace();
        }
        if (image != null){
            image.flush();
        }
    }
    
    public Texture getTexture(){
        if (image == null){
            return null ; 
        }
        if (texture == null) {
            texture = AWTTextureIO.newTexture(profile , image , true) ; 
        }
        return texture ; 
    }
    
}
