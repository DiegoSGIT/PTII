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
import com.RFIDSystem.pojos.Vendedores;

/**
 *
 * @author diego
 */
public class VendedoresDAO {
	
	public void insertVendedor(Vendedores v) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("insert into VENDEDORES (NOMBRE,APELLIDO,PASSWORD,ESTABLECIMIENTO_IDESTABLECIMIENTO)values (?,?,?,?)");
			ps.setString(1, v.getNombre());
			ps.setString(2, v.getApellido());
			ps.setString(3, v.getPassword());
			ps.setInt(4, v.getIdEstablecimiento());
			ps.execute();
			ps.close();
		}catch(SQLException ex) {
			Logger.getLogger(VendedoresDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}	
	}
	public void updateVendedor(Vendedores v) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("UPDATE VENDEDORES SET NOMBRE=?,APELLIDO=?,PASSWORD=?,ESTABLECIMIENTO_IDESTABLECIMIENTO=? WHERE IDVENDEDOR=?");
			ps.setString(1, v.getNombre());
			ps.setString(2, v.getApellido());
			ps.setString(3, v.getPassword());
			ps.setInt(4, v.getIdEstablecimiento());
			ps.setInt(5, v.getIdVendedor());
			ps.execute();
			ps.close();
		}catch(SQLException ex) {
			Logger.getLogger(VendedoresDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}	
	}
    
}
