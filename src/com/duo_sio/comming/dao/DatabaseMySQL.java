package com.duo_sio.comming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUO SIO
 */
public class DatabaseMySQL {
    private static Connection connection = null;
    
    public static Connection getConnection() throws Exception{
        if (connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/comming","root","");
            } catch (ClassNotFoundException | SQLException e) {
                return null;
            }
        }
        return connection;
    }
    
    public static boolean isConnect(){
        try {
            if (getConnection()==null){
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
