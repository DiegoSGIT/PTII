package com.RFIDSystem.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.RFIDSystem.daos.VisitantesDAO;
import com.RFIDSystem.ws.structures.request.VisitantesRequest;

@Path("/Visitantes")
public class VisitantesWS {
	@Path("/insert")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public void insertVisitante(VisitantesRequest vr) {
		VisitantesDAO vdao = new VisitantesDAO();
		vdao.inserVisitante(vr.getVisitantes());
		
	}
	@Path("/update")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateVisitante(VisitantesRequest vr) {
		VisitantesDAO vdao = new VisitantesDAO();
		vdao.updateVisitante(vr.getVisitantes());
		
	}
	
}