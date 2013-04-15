/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ede.ui;

import com.ede.core.EDE;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author Bobby
 */
public class ImageButton extends JButton implements MouseListener
{
    ImageIcon on,off;
    public ImageButton(String offS, Dimension dim)
    {
       InputStream  logoStream = EDE.class.getResourceAsStream(offS);
       BufferedImage logo=null;
        try {
            logo = ImageIO.read(logoStream);

        } catch (IOException ex) {
            Logger.getLogger(EDE.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBorder(BorderFactory.createMatteBorder( 1, 1, 1, 1, Color.GRAY));
        this.setOpaque(false);
        setIcon(new ImageIcon(logo));
        setPreferredSize(dim);
        setSize(dim);
        this.setAlignmentX(JButton.LEFT_ALIGNMENT);
        setMinimumSize(dim);
        setContentAreaFilled(false);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createMatteBorder( 1, 1, 1, 1, Color.BLACK));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder(BorderFactory.createMatteBorder( 1, 1, 1, 1, Color.GRAY));
    }
    
    
    
}
