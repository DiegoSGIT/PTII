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
public class EstablecimientosDAO {
	
    public void inserEstablecimiento(String name) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("insert into ESTABLECIMIENTOS (NOMBRE)values (?)");
			ps.setString(1, name);			
			ps.execute();
			ps.close();
		}catch(SQLException ex) {
			Logger.getLogger(EstablecimientosDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}	
	}
	public void deleteEstablecimiento(int id) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("DELETE FROM ESTABLECIMIENTOS WHERE IDESTABLECIMIENTO = ?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			
		}catch(SQLException ex) {
			Logger.getLogger(EstablecimientosDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}
	}
    
}
