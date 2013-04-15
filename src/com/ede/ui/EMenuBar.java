/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ede.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author Bobby
 */
public class EMenuBar extends JMenuBar
{
    
      public final static int HORIZONTAL = 0;
  public final static int VERTICAL = 1;
  public final static int DIAGONAL_LEFT = 2;
  public final static int DIAGONAL_RIGHT = 3;
  private int radius=10;
  public boolean header=false;
  private int direction = HORIZONTAL;
  
    public EMenuBar()
    {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu toolsM = new JMenu("Tools");
        JMenu help= new JMenu("Help");
    
        file.setForeground(Color.WHITE);
        edit.setForeground(Color.WHITE);
        toolsM.setForeground(Color.WHITE);
        help.setForeground(Color.WHITE);
        add(file);
        add(edit);
        add(toolsM);
        add(help); 
    }
    
    @Override
    protected void paintComponent(Graphics g)
  {
      
           //make round

       Graphics2D g2 = (Graphics2D)g.create();
               Color bg = getBackground();
        g2.setColor(new Color(bg.getRed(),bg.getGreen(),bg.getBlue(),40));
        g2.fillRoundRect(0,0, getWidth()-1, getHeight()-1, radius, radius);
        g2.setColor(new Color(0,0,0,70));
        g2.drawRoundRect(0,0, getWidth()-1, getHeight()-1, radius, radius);
        //Vertical
        Paint pV = new GradientPaint(
                0, 0, new Color(0x7D838F),
                0, getHeight(), new Color(0x272B39)
            );
        
        //Horizontal 
        Paint pH = new GradientPaint(
                0, 0, new Color(0x7D838F),
                getWidth(), 0, new Color(0x272B39)
            );
        
        //Reflected Horizontal
        Paint pRH = new GradientPaint(
                        0, 0, new Color(0x7D838F),
                        getWidth()/2, 0, new Color(0x272B39),
                        true
                    );
        
         //Reflected Vertical
        Paint pRV = new GradientPaint(
                        0, 0, new Color(0x7D838F),
                        0, getHeight()/2, new Color(0x272B39),
                        true
                    );
        
        
        
        
        g2.setPaint(pV);
        g2.fillRect(0, 0, getWidth(), getHeight());
        if(header)
        {
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), 40);
        g2.setColor(Color.DARK_GRAY);
        g2.drawRect(0, 0, getWidth()-1, 40);
        }
        
        g2.dispose();
        
        
   

            
    }
    

}
