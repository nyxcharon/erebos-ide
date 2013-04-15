/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ede.project;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author nyxcharon
 */
public class JavaProject 
{
    String EP_Home=System.getProperty("user.home")+File.separator+"ErebosProjects"+
            File.separator;
    String home;
    public JavaProject(String name)
    {
      File proj = new File(EP_Home+name);
      if (!proj.exists())
      {
        proj.mkdir();
      }
      home=EP_Home+name+File.separator;
      
      File projXML=new File(home+"name.xml");
       if (!proj.exists())
      {
           copyFile("C:\\Users\\Bobby\\Documents\\NetBeansProjects\\ede\\src\\com\\ede\\project\\ProjectTemplate.xml",projXML.getPath());
      }
          
    }
    
    public void copyFile(String oLoc,String nLoc)
    {
        //writeFile(readFile(oLoc),nLoc);
        try {
	// read this file into InputStream
	InputStream inputStream = new FileInputStream(oLoc);
 
	// write the inputStream to a FileOutputStream
	OutputStream out = new FileOutputStream(new File(nLoc));
 
	int read = 0;
	byte[] bytes = new byte[1024];
 
	while ((read = inputStream.read(bytes)) != -1) {
		out.write(bytes, 0, read);
	}
 
	inputStream.close();
	out.flush();
	out.close();
    } catch (IOException e) {
	System.out.println(e.getMessage());
    }
  
    }

    public String readFile(String url)
    {   
      String data="";
        try
        {
            String strLine; 
             File file=new File(url);
             FileInputStream in = new FileInputStream(file);
             BufferedReader br = new BufferedReader(new InputStreamReader(in));
             while ((strLine = br.readLine()) != null) 
            {
                data+=strLine + "\n";
            }   
        }
        catch(Exception e)
        {
        }

        return data;
   }
    
   public void writeFile(String data,String url)
   {
        try {
        BufferedWriter x = new BufferedWriter(new FileWriter(new File(url)));
        x.write(data,0,data.length());
         x.close();
         }
        catch (Exception e)
        {
        System.out.println("save error");
        }
           
   }
   
   
   /*
   public File loadFile(String url)
   {
       InputStream  logoStream = 
				this.getClass().getResourceAsStream (url);
       File file=null;
       //try
       //{
         //  file=new File(logoStream);
       //}
   }*/
   
}
