package com.RFIDSystem.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import com.RFIDSystem.daos.EstablecimientosDAO;

@Path("/Establecimientos")
public class EstablecimientosWS {
	@Path("/insert")
	@GET
	public void insertEstablecimiento(@QueryParam("nombre") String nombre) {
		EstablecimientosDAO edao = new EstablecimientosDAO();
		edao.inserEstablecimiento(nombre);
		
	}	

}
