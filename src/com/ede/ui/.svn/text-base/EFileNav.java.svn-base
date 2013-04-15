package com.ede.ui;

import com.ede.utils.FileTreeModel;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Bobby
 */
public class EFileNav extends JTree
{
    public EFileNav()
    {
        FileTreeModel m=new FileTreeModel(new File(System.getProperty("user.home")));
        setModel(m);
        setCellRenderer(new MyRenderer());
        setBackground(Color.DARK_GRAY);
        setForeground(Color.LIGHT_GRAY);
    }
    
    private class MyRenderer extends DefaultTreeCellRenderer 
    {  
  
        public Component getTreeCellRendererComponent(  
                JTree tree,  
                Object value,  
                boolean sel,  
                boolean expanded,  
                boolean leaf,  
                int row,  
                boolean hasFocus) {  
  
            super.getTreeCellRendererComponent(  
                    tree, value, sel,  
                    expanded, leaf, row,  
                    hasFocus);  
  
            setBackgroundNonSelectionColor(tree.getBackground());  
  
            return this;  
        }  
    }  
}
