/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RFIDSystem.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.RFIDSystem.connection.DBConnection;
import com.RFIDSystem.structures.ArticlesIDS;

/**
 * Realiza transaciones de Compra_Articulos en a DB.
 * @author diego
 */
public class Compra_ArticulosDAO {
	
    /**
     * Inserta una compra nueva.
     * @param articles Arreglo de identificadores de los articulos por compra
     * @param idCompra
     */
	public void insertCompra_articulo(List<ArticlesIDS> articles, int idCompra) {
		Connection c = new DBConnection().getConnection();
		try {
			String prepare_values = "";
			for (int i = 0; i < articles.size() ; i++) {
				for(int j = 0; j<articles.get(i).getCantidad(); j++)
					prepare_values += "("+articles.get(i).getArticleID()+","+idCompra+"),";
			}
			String values = prepare_values.substring(0, prepare_values.length()-1);
			PreparedStatement ps = c.prepareStatement("INSERT INTO COMPRA_ARTICULOS (ARTICULO_IDARTICULO,COMPRA_IDCOMPRA)VALUES"+values);
				ps.execute();
				c.close();
		}catch(SQLException ex) {
			Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, "Error al insertar compra", ex);
		}
	}
	
	
}
