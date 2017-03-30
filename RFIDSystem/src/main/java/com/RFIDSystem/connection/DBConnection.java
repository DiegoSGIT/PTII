package com.RFIDSystem.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase que establece la conexión a la base de datos.
 * @author diego
 *
 */

public class DBConnection {
	
	private final String host = "localhost";
    private final String port = "3306";
    private final String db = "RFIDSystemDB";
    private final String user = "root";
    private final String pwd = "0793bgmd";
    private Connection c;

    public DBConnection() {
        try{   
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port +"/" + db ,user,pwd);
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    public Connection getConnection() {
        return c;
    }
    
   
}
