/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ede.utils;

import com.ede.core.EDE;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Bobby
 */
public class EImageLoader 
{
    public ImageIcon getImage(String url)
    {
        InputStream  logoStream = EDE.class.getResourceAsStream(url);
        BufferedImage logo=null;
        try {
            logo = ImageIO.read(logoStream);

        } catch (IOException ex) {
            Logger.getLogger(EDE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ImageIcon(logo);
    }
}
