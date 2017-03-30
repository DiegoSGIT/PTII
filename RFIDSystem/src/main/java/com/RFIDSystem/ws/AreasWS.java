package com.RFIDSystem.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.RFIDSystem.daos.AreasDAO;
@Path("/Areas")
public class AreasWS {
	@Path("/insert")
	@GET
	public void insertArea(@QueryParam("nombre") String nombre) {
		AreasDAO adao = new AreasDAO();
		adao.inserArea(nombre);
		
	}	

}
