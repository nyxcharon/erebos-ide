
package com.ede.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

/**
 *
 * @Author 
 * Bobby Martin
 *
 */
    
public class EOutputWindow extends JTextArea implements MouseListener, KeyListener
{
    final String termText="Output:";
    public EOutputWindow()
    {
        Font font = new Font("Verdana", Font.PLAIN, 9);
        setFont(font);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(1000,30));
        setText(termText);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setEditable(false);
        setForeground(Color.WHITE);
        addMouseListener(this);
        addKeyListener(this);
    }
    
   public void cursorCheck()
   {
    if(this.getCaretPosition()<termText.length())
        this.setCaretPosition(termText.length());
   }
   
   public void clearText()
   {
       this.setText(termText);
   }
   
   public void resetText()
   {
       if(this.getText().length()>=termText.length())
       {
        if(!(this.getText().substring(0, termText.length()).equals(termText)))
            setText(termText);
       }
       else
           setText(termText);
   }

    public void mousePressed(MouseEvent e) 
    {
       resetText();
       cursorCheck();
    }

    

    public void keyTyped(KeyEvent e) 
    {
     resetText();
     cursorCheck(); 
    }

    public void keyPressed(KeyEvent e) 
    {}
    public void keyReleased(KeyEvent e) 
    {}
    public void mouseReleased(MouseEvent e)
    {}
    public void mouseEntered(MouseEvent e) 
    {}
    public void mouseExited(MouseEvent e) 
    {}
    public void mouseClicked(MouseEvent e) 
    {}
}

