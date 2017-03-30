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
import com.RFIDSystem.pojos.Visitantes;

/**
 * Realiza transaciones de Visitantes en la DB.
 * @author diego
 */
public class VisitantesDAO {
	
	/**
	 * Obtiene el NIP del vistante 
	 * @param id de visitante
	 * @return
	 */
	
	public int getNIP(int id){
		Connection c = new DBConnection().getConnection();
        int nip = -1;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT CAST(AES_DECRYPT(NIP, 'UPIITA') AS CHAR(50)) NIP FROM VISITANTES where TAG_VISITANTE = ?");
            ps.setInt(1, id);
            if(ps.execute()){
                ResultSet rs = ps.getResultSet();
                while(rs.next())
                    nip = Integer.parseInt(rs.getString(1));
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nip;
    }
	
    /**
     *	Obtiene el monedero electrónico del vistante 
     * @param id del visitante.
     * @return
     */
	
	public float getME(int id){
		Connection c = new DBConnection().getConnection();
		float me = -0;
        try {
            PreparedStatement ps = c.prepareCall("select SALDO from VISITANTES where TAG_VISITANTE = ?");
            ps.setInt(1, id);
            if(ps.execute()){
                ResultSet rs = ps.getResultSet();
                while (rs.next())
                    me = rs.getFloat(1);
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(VisitantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return me;
    }
	/**
	 * Actualiza el monedero electrónico de los visitanates
	 * @param idVisitante
	 * @param me
	 */
	public void updateME(int idVisitante,float me) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("UPDATE VISITANTES SET SALDO = ? WHERE TAG_VISITANTE=?");
			ps.setFloat(1, me);
			ps.setInt(2, idVisitante);
			ps.execute();
			c.close();
		}catch(SQLException ex) {
			Logger.getLogger(VisitantesDAO.class.getName()).log(Level.SEVERE, "Error al actualizar monedero electrónico", ex);
			
		}
	}
	/**
	 * Actualiza la ubicacion de los visitantes
	 * @param idVisitante
	 * @param idArea
	 */
	public void setLocation(int idVisitante, int idArea) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("UPDATE VISITANTES SET AREA_IDAREA = ? WHERE TAG_VISITANTE = ?");
			ps.setInt(1, idArea);
			ps.setInt(2, idVisitante);
			ps.execute();
			c.close();	
		}catch(SQLException ex) {
			Logger.getLogger(VisitantesDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}	
	}
	/**
	 * Inserta un nuevo visitante.
	 * @param v
	 */
	public void inserVisitante(Visitantes v) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("INSERT INTO VISITANTES (TAG_VISITANTE,NOMBRE,APELLIDO,CORREO,SALDO,NIP,GRUPO_IDGRUPO,AREA_IDAREA,EMPLEADO_IDEMPLEADO)VALUES(?,?,?,?,?,AES_ENCRYPT(?, 'UPIITA'),?,?,?)");
			ps.setInt(1, v.getTag());
			ps.setString(2, v.getNombre());
			ps.setString(3, v.getApellido());
			ps.setString(4, v.getCorreo());
			ps.setFloat(5, v.getSaldo());
			ps.setString(6, v.getNip());
			ps.setInt(7, v.getIdGrupo());
			ps.setInt(8, v.getIdArea());
			ps.setInt(9, v.getIdEmpleado());
			ps.execute();
			ps.close();
		}catch(SQLException ex) {
			Logger.getLogger(VisitantesDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}	
	}
	/**
	 * Elimina un visitante.
	 * @param id
	 */
	public void deleteVisitante(int id) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("DELETE FROM VISITANTES WHERE TAG_VISITANTE=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			
		}catch(SQLException ex) {
			Logger.getLogger(VisitantesDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}
	}
	/**
	 * Actualiza la informaciónd el visitante
	 * @param id
	 */
	public void updateVisitante(Visitantes v) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("UPDATE VISITANTES SET TAG_VISITANTE=?, NOMBRE=?, APELLIDO=?, CORREO=?, SALDO=?,NIP=AES_ENCRYPT(?, 'UPIITA'),GRUPO_IDGRUPO=?, AREA_IDAREA=?, EMPLEADO_IDEMPLEADO=? WHERE TAG_VISITANTE=?");
			ps.setInt(1, v.getTag());
			ps.setString(2, v.getNombre());
			ps.setString(3, v.getApellido());
			ps.setString(4, v.getCorreo());
			ps.setFloat(5, v.getSaldo());
			ps.setString(6, v.getNip());
			ps.setInt(7, v.getIdGrupo());
			ps.setInt(8, v.getIdArea());
			ps.setInt(9, v.getIdEmpleado());
			ps.setInt(10, v.getTag());
			ps.execute();
			ps.close();			
		}catch(SQLException ex) {
			Logger.getLogger(VisitantesDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}
	}
}
