/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fichero.propertie.utileria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Morad
 */
public class Propiedades {
    //metodo para cargar el archivo properties
    public Properties cargarArchivoProperties() throws FileNotFoundException, IOException{
        Properties propiedades = new Properties();//creamos el archivo properties
         //ruta  relativa
       // InputStream archivo = getClass().getResourceAsStream("/conexionBD.properties");
               InputStream archivo =  getClass().getClassLoader().getResourceAsStream("conexionBD.properties");

        
        propiedades.load(archivo);
             
        return propiedades;
    }
    
    
    
}
