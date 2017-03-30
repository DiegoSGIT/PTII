package com.RFIDSystem.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import com.RFIDSystem.daos.GruposDAO;

@Path("/Grupos")
public class GruposWS {
	@Path("/insert")
	@GET
	public void insertGrupo(@QueryParam("nombre") String nombre) {
		GruposDAO gdao = new GruposDAO();
		gdao.inserGrupo(nombre);
		
	}

}
