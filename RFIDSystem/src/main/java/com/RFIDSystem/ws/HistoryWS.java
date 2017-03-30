package com.RFIDSystem.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.RFIDSystem.daos.ComprasDAO;
import com.RFIDSystem.ws.structures.responses.HistoryResponse;

@Path("/Compras")
public class HistoryWS {
	
	@Path("/getAll")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public HistoryResponse getCompras() {
		ComprasDAO cdao = new ComprasDAO();
		return cdao.getHistory();
		
		
	}	
	

}
