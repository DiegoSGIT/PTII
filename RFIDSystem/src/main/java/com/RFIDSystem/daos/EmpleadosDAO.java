/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RFIDSystem.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.RFIDSystem.connection.DBConnection;
import com.RFIDSystem.pojos.Empleados;
import com.RFIDSystem.ws.structures.request.LoginRequest;
import com.RFIDSystem.ws.structures.responses.LoginEmpleadoResponse;

/**
 *
 * @author diego
 */
public class EmpleadosDAO {
	
	public void insertEmpleados(Empleados e) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("insert into EMPLEADOS (NOMBRE,APELLIDO,PASSWORD,GERENTE)values(?,?,?,?)");
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getApellido());
			ps.setString(3, e.getPassword());
			ps.setBoolean(4, e.isGerente());
			ps.execute();
			ps.close();
		}catch(SQLException ex) {
			Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}	
	}
	public void updateEmpleados(Empleados e) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("UPDATE EMPLEADOS SET NOMBRE=?, APELLIDO = ?, PASSWORD=?, GERENTE = ? WHERE IDEMPLEADO=?");	
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getApellido());
			ps.setString(3, e.getPassword());
			ps.setBoolean(4, e.isGerente());
			ps.setInt(5, e.getIdEmpleado());
			ps.execute();
			ps.close();
		}catch(SQLException ex) {
			Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}	
	}
	public LoginEmpleadoResponse checkLogin(LoginRequest lr) {
		Connection c = new DBConnection().getConnection();
		LoginEmpleadoResponse ler = new LoginEmpleadoResponse();
		try {
			PreparedStatement ps = c.prepareStatement("select IDEMPLEADO, NOMBRE, GERENTE from EMPLEADOS where NOMBRE = ? and PASSWORD = ?");
			ps.setString(1, lr.getUser());
			ps.setString(2, lr.getPasssword());
			if(ps.execute()) {
    			ResultSet rs = ps.getResultSet();
    			if(rs.next()) {
    				ler.setId(rs.getInt(1));
    				ler.setName(rs.getString(2));
    				ler.setGerente(rs.getBoolean(3));
    			}
    		}
			ps.close();
		}catch(SQLException ex) {
			Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE,"Error en revisar el login" , ex);
		}
		return ler;	
	}
}
