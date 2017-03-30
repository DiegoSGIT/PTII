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
import com.RFIDSystem.ws.structures.request.PaymentRequest;
import com.RFIDSystem.ws.structures.responses.HistoryResponse;
import com.RFIDSystem.ws.structures.responses.PaymentResponse;
import com.RFIDSystem.structures.ArticuloCompra;
import com.RFIDSystem.structures.ArticulosCompra;
import com.RFIDSystem.structures.History;

/**
 * Clase que realiza las transaciones de compras en la DB.
 * @author diego
 */
public class ComprasDAO {
	/**
	 * Valida la compra en base al NIP y Monedero electronico
	 * @param PaymentRequest p
	 * @return PaymentRepsonse pr
	 */
	public PaymentResponse validate(PaymentRequest p) {
		PaymentResponse pr = new PaymentResponse();
		VisitantesDAO vdao = new VisitantesDAO();
		Compra_ArticulosDAO c_adao = new Compra_ArticulosDAO();
		int idcompra;
		
		if((p.getNIP() == vdao.getNIP(p.getId())) && (p.getCosto() < vdao.getME(p.getId()))) {
			pr = new PaymentResponse("success", "La operación ha sido realizada con exito saldo restante: ",vdao.getME(p.getId())-p.getCosto());
			vdao.updateME(p.getId(), (vdao.getME(p.getId())-p.getCosto()));
			insertCompra(p.getId(), p.getVendedorId(), p.getCosto());
			idcompra = getCompraId(p.getId());
			c_adao.insertCompra_articulo(p.getCompras().articlesId, idcompra);
		}
		else {
			if(p.getNIP() != vdao.getNIP(p.getId()))
				pr = new PaymentResponse("fallido", "NIP incorrecto.");
			if(p.getCosto() > vdao.getME(p.getId()))
				pr = new PaymentResponse("fallido", "Saldo insuficiente.", vdao.getME(p.getId()));
			else
				pr = new PaymentResponse("fallido", "Error interno al procesar la información.");
		}
		
		return pr;
		
	}
	/**
	 * Inserta una compra nueva
	 * @param idVisitante
	 * @param idVendedor
	 * @param monto
	 */
	public void insertCompra(int idVisitante, int idVendedor, float monto) {
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("INSERT INTO COMPRAS (MONTO,VISITANTE_IDVISITANTE,VENDEDOR_IDVENDEDOR)VALUE(?,?,?)");
			ps.setFloat(1, monto);
			ps.setInt(2, idVisitante);
			ps.setInt(3, idVendedor);	
				ps.execute();
				c.close();
		}catch(SQLException ex) {
			Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, "Error al insertar compra", ex);
		}
		
	}
	/**
	 * Obtiene el identificador de compra mediante el identificador de visitante.
	 * @param idVisitante
	 * @return
	 */
	public int getCompraId(int idVisitante) {
		int id = -1;
		Connection c = new DBConnection().getConnection();
    	try {
    		PreparedStatement ps = c.prepareStatement("SELECT max(IDCOMPRA) from COMPRAS where VISITANTE_IDVISITANTE = ?");
    		ps.setInt(1, idVisitante);
    		if(ps.execute()) {
    			ResultSet rs = ps.getResultSet();
    			while(rs.next())
    				id = rs.getInt(1);
    		}
    		c.close();
    	}catch(Exception ex) {
    		Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);	    		
    	}
	    	return id;
    }
	public HistoryResponse getHistory() {
		Connection c = new DBConnection().getConnection();
		HistoryResponse historial = new HistoryResponse();
		int numCompras=0;
		try {
			
			PreparedStatement ps = c.prepareStatement("select MAX(IDCOMPRA) FROM COMPRAS");
			
			if(ps.execute()) {
				ResultSet rs = ps.getResultSet();
    			while(rs.next())
    				numCompras = rs.getInt(1);
    			System.out.println("Numero de compras: " +  numCompras);
    			for (int i = 0; i < numCompras; i++) {
    				historial.historialCompras.add(getComponentes(i+1));	
				}
			}
			c.close();
		}catch(SQLException ex) {
			Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE,"Error al obtener el historial de compras", ex);
		}
		return historial;
	}
	public History getComponentes(int i) {
		History h = new History();
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("select *FROM COMPRAS WHERE IDCOMPRA=?");
			ps.setInt(1, i);
			if(ps.execute()) {
				ResultSet rs = ps.getResultSet();
    			while(rs.next()) {
    				h.setId(rs.getInt(1)); 
    				h.setMonto(rs.getFloat(2));
    				h.setVisitante(rs.getInt(3));
    				h.setVendedor(rs.getInt(4));
    				
    			}
    			h.setArticulos(getArticulos(i));
    			c.close();
			}
		}catch(SQLException ex) {
			Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE,"Error al obtener el historial de compras", ex);
		}
		return h;
	}
	public ArticulosCompra getArticulos(int i) {
		ArticulosCompra a = new ArticulosCompra();
		Connection c = new DBConnection().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("select DESCRIPCION, count(*) as CANTIDAD FROM (ARTICULOS AS A JOIN COMPRA_ARTICULOS AS C ON A.SKU = C.ARTICULO_IDARTICULO) where C.COMPRA_IDCOMPRA = ? group by DESCRIPCION");
			ps.setInt(1, i);
			if(ps.execute()) {
				ResultSet rs = ps.getResultSet();
    			while(rs.next()) {
    				a.articulos.add(new ArticuloCompra(rs.getString(1),rs.getInt(2)));
    			}	
			}
			c.close();
		}catch(SQLException ex) {
			Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE,"Error al obtener el historial de compras", ex);
		}
		return a;
	}

}
