/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fichero.properties.conexionproperties;

import com.fichero.propertie.utileria.Propiedades;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Morad
 */
public class Conexion {

    private static Conexion instancia = null;

    private Conexion() {

    }

    Propiedades properties = new Propiedades();

    //creamos el mertodo para conectarnos a la bd
    public void conectar() {

        Connection con = null;
        try {

            Properties propiedades = properties.cargarArchivoProperties();
            String user = propiedades.getProperty("conexion.user");
            String password = propiedades.getProperty("conexion.password");
            String url = propiedades.getProperty("conexion.url");

            con = DriverManager.getConnection(url, user, password);

            if (con != null) {
                JOptionPane.showMessageDialog(null, "Conexion exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion");
            }

        } catch (Exception error) {
            System.out.println(error);
        }

    }

    public void desconectar(Connection con) throws SQLException {
        try {

            con.close();
        } catch (Exception error) {
            System.out.println(error);
        } finally {
            con.close();
        }
    }

    //patron de software singleton, siempre retorno la instancia que existe 
    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();

        }
        return instancia;
    }
}
