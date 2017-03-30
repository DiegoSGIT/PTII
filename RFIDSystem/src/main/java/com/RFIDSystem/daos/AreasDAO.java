/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RFIDSystem.daos;


import com.RFIDSystem.structures.GetLocationsStructureProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.RFIDSystem.connection.DBConnection;
/**
 * Clase DAO para transaciones en la tabla Areas.
 * @author diego
 */
public class AreasDAO {
	private Connection c;
	
	public AreasDAO() {
		c = new DBConnection().getConnection();
	}
	
	/**
	 * Obtiene las localizaciones de los visitantes acerca de un grupo
	 * @param id tag del visitante.
	 * @return Lista de localizacion.
	 */
	
    public List<GetLocationsStructureProcedure> getLocations(int id){
        List<GetLocationsStructureProcedure> locations = new ArrayList<GetLocationsStructureProcedure>();
        CallableStatement cs;
        ResultSet rs;
        try {
            cs = c.prepareCall("{call getLocations(?)}");
            cs.setInt(1, id);
            if (cs.execute()){
                rs = cs.getResultSet();
                while (rs.next())
                    locations.add(new GetLocationsStructureProcedure(rs.getString(1), rs.getString(2)));
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locations;
    }
    public void inserArea(String name) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("insert into AREAS (NOMBRE)values (?)");
			ps.setString(1, name);			
			ps.execute();
			ps.close();
		}catch(SQLException ex) {
			Logger.getLogger(AreasDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}	
	}
	public void deleteArea(int id) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("DELETE FROM AREAS WHERE IDAREA = ?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			
		}catch(SQLException ex) {
			Logger.getLogger(AreasDAO.class.getName()).log(Level.SEVERE,"Error al actualizar la ubicación",ex);
		}
	}
	public void setArea() {
		
		
	}

}
