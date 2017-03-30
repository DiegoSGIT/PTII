/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RFIDSystem.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.RFIDSystem.connection.DBConnection;

/**
 *
 * @author diego
 */
public class GruposDAO {
	public void inserGrupo(String name) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("insert into GRUPOS (NOMBRE)values (?)");
			ps.setString(1, name);			
			ps.execute();
			ps.close();
		}catch(SQLException ex) {
			Logger.getLogger(GruposDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}	
	}
	public void deleteGrupo(int id) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("DELETE FROM GRUPOS WHERE IDGRUPO = ?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			
		}catch(SQLException ex) {
			Logger.getLogger(GruposDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}
	}
    
}
