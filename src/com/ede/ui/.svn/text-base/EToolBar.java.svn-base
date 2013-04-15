package com.ede.ui;

import com.ede.utils.ECompiler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

/**
 *
 * @author Bobby
 * 
 */
public class EToolBar extends JToolBar
{
    ImageButton newb,newPb,copyb,saveb,saveAsb,undob,redob,compileb,runb,cutb,deleteb;
    public EToolBar()
    {
        this.setLayout(new FlowLayout(FlowLayout.LEFT,5,3));
        Dimension d=new Dimension(20,20);
        String prefix="/com/ede/icons/";
        newb=new ImageButton(prefix+"document-new.png",d);
        newPb=new ImageButton(prefix+"folder-new.png",d);
        copyb=new ImageButton(prefix+"edit-copy.png",d);
        saveb=new ImageButton(prefix+"save.gif",d);
       // saveAsb=new ImageButton(prefix+"document-save-as.png",d);
        undob=new ImageButton(prefix+"edit-undo.png",d);
        redob=new ImageButton(prefix+"edit-redo.png",d);
        compileb=new ImageButton(prefix+"document-save-as.png",d);
        runb=new ImageButton(prefix+"action_go.gif",d);
        cutb=new ImageButton(prefix+"edit-cut.png",d);
        deleteb=new ImageButton(prefix+"edit-delete.png",d);
        this.setBackground(Color.GRAY);
        this.setFloatable(false);
        add(newb);
        add(newPb);
        add(saveb);
        add(EDiv());
        add(undob);
        add(redob);
        add(EDiv());
        add(copyb);
        add(deleteb);
        add(compileb);
        add(runb);
        //add(EDiv());
        this.setMargin(new Insets(2,1,2,1));
        //this.setSize(this.getWidth(), 25);
       
    }
    
    public JTextField EDiv()
    {
        JTextField div=new JTextField("|");
        div.setBorder(null);
        div.setEditable(false);
        div.setPreferredSize(new Dimension(1,15));
        return div;
    }
    
    public String compile()
    {
        ECompiler comp=new ECompiler();
        return comp.compile("temp.java");
        
    }
    
    public ImageButton getCB()
    {
        return compileb;
    }

}
