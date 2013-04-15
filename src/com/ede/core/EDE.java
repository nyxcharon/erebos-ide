
package com.ede.core;

import com.ede.ui.EEditor;
import com.ede.ui.EFileNav;
import com.ede.ui.EMenuBar;
import com.ede.ui.EOutputWindow;
import com.ede.ui.EToolBar;
import com.ede.utils.EImageLoader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

/**
 *
 * @author Bobby
 */
public class EDE extends JFrame
{
    JPanel editorP,leftNav,output,main;
    JMenuBar menu;
    JSplitPane vert,horz;
    EEditor editor;
    EOutputWindow opw;
    EFileNav fn;
    EToolBar etb;
    public EDE()
    {
        this.setSize(1680,1024);     
        checkEDEProperties();
        setupEditor();
        setupOutput();
        setupNav();
        setupMenu();
        setupLayout();
        setTitle("Erebos Devolopment Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //File tree UI setup
        EImageLoader il=new EImageLoader();
        ImageIcon folder=il.getImage("/com/ede/icons/folder.png");
        ImageIcon file=il.getImage("/com/ede/icons/format-justify-fill.png");
        UIManager.put("Tree.textForeground", Color.WHITE);
        UIManager.put("Tree.selectionBackground", Color.LIGHT_GRAY);
        UIManager.put("Tree.selectionBorderColor", Color.LIGHT_GRAY);
        UIManager.put("Tree.leafIcon", file);
        UIManager.put("Tree.openIcon", folder);
        UIManager.put("Tree.closedIcon", folder);
        //UIManager.put("Tree.collapsedIcon", new ImageIcon(logo));
       
        
        String path=System.getProperty("java.home");
        path=path.substring(0, path.lastIndexOf("\\")+1);
        path+="bin\\javac.exe";
        //System.out.println(System.getProperty("java.home"));
        System.out.println(path);
       
        new EDE();
    }

    private void setupEditor() 
    {
       editorP=new JPanel(new BorderLayout());
       editor=new EEditor();
       editorP.add(editor,BorderLayout.CENTER);
       editorP.setOpaque(false);
    }

    private void setupOutput() 
    {
        output=new JPanel(new BorderLayout());
        opw=new EOutputWindow();
        output.add(opw,BorderLayout.CENTER);
        
    }

    private void setupNav() 
    {
        leftNav=new JPanel(new BorderLayout());
        fn=new EFileNav();
        JScrollPane lsp = new JScrollPane(fn);
        leftNav.add(lsp);
        
    }

    private void setupLayout() 
    {
        main=new JPanel(new BorderLayout());
        vert=new JSplitPane(JSplitPane.VERTICAL_SPLIT,editorP,output);   
        horz=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftNav,vert);
        horz.setDividerLocation(175);
        horz.setDividerSize(3);
        vert.setDividerLocation((int)(this.getHeight()*.80));
        vert.setDividerSize(3);
        main.add(horz,BorderLayout.CENTER);
        add(main);
        etb=new EToolBar();
        etb.getCB().addActionListener(new CompileListener());
        add(etb,BorderLayout.NORTH);
        setJMenuBar(new EMenuBar());
    }

    private void setupMenu() 
    {
        menu=new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu toolsM = new JMenu("Tools");
        JMenu help= new JMenu("Help");
        menu.setBackground(Color.DARK_GRAY);
        file.setForeground(Color.WHITE);
        edit.setForeground(Color.WHITE);
        toolsM.setForeground(Color.WHITE);
        help.setForeground(Color.WHITE);
        menu.add(file);
        menu.add(edit);
        menu.add(toolsM);
        menu.add(help);
    }

    private void checkEDEProperties() 
    {
         //Check for properties folder
          File edeHome = new File(System.getProperty("user.home")+File.separator+".EDE");
          if (!edeHome.exists())
          {
            edeHome.mkdir();
          }

          //check for project folder
          File edeProj = new File(System.getProperty("user.home")+File.separator+"ErebosProjects");
          if (!edeProj.exists())
          {
            edeProj.mkdir();
          }
        
    }
    
    class CompileListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            writeTempFile();
            //System.out.println(editor.getText());
            opw.clearText();
            opw.append("\n"+etb.compile());
        }

        private void writeTempFile() 
        {
            BufferedWriter writer = null;
	try
	{
		writer = new BufferedWriter( new FileWriter(System.getProperty("user.home")+File.separator+"temp.java"));
		writer.write(editor.getText());
	}
	catch ( IOException e)
	{
	}
	finally
	{
		try
		{
			if ( writer != null)
				writer.close( );
		}
		catch ( IOException e)
		{
		}
     }
        }
    }
}
