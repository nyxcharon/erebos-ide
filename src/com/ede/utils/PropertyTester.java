/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ede.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

/**
 *
 * @author nyxcharon
 */
public class PropertyTester 
{
    public static void main(String[] args)
    {
        try
        {
        Properties props = new Properties();
        props.loadFromXML(new FileInputStream("/home/nyxcharon/NetBeansProjects/ede/src/com/ede/utils/edepropxml.props"));
        System.out.println(props.getProperty("Application.name"));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
