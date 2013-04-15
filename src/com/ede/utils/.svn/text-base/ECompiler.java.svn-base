/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ede.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 *
 * @author Bobby
 */
public class ECompiler 
{
    String home;
    String javac;
    String path;
    public ECompiler()
    {
        home=System.getProperty("user.home");
        javac=System.getProperty("java.home");
        javac=javac.substring(0, javac.lastIndexOf("\\")+1);
        javac+="bin\\javac.exe";
    }
    
    public void updatePath(String path)
    {
        this.path=path;
    }
    
    public String compile(String file)
    {
        String output="";
        try {
          String line;
          String os=System.getProperty("os.name");
          os=os.toLowerCase();
          Process p = null;
          if(os.contains("wind"))
           p = Runtime.getRuntime().exec(javac+" "+home+"/"+file);
          else if(os.contains("linux")||os.contains("mac")||os.contains("bsd")
                      ||os.contains("solaris")||os.contains("sun"))
           p= Runtime.getRuntime().exec("javac"+" "+home+"/"+file);
          else
              return "Compiler Not Found";
          
          BufferedReader bri = new BufferedReader
            (new InputStreamReader(p.getInputStream()));
          BufferedReader bre = new BufferedReader
            (new InputStreamReader(p.getErrorStream()));
          while ((line = bri.readLine()) != null) {
            System.out.println(line);
          }
          bri.close();
          while ((line = bre.readLine()) != null) 
          {
            output+=line+"\n";
          }
          bre.close();
          p.waitFor();

          if(output.contains("error") || output.contains(" file not found"))
              output+="Compile Unsuccessful";
          else
               output+="Compile Successful";

        }
        catch (Exception err) 
        {
          //err.printStackTrace();
        }
        return output;
    }
    public static void main(String[] args) throws IOException
    {
        ECompiler c=new ECompiler();
        System.out.println(c.compile("Test.java"));
    }
}
    

