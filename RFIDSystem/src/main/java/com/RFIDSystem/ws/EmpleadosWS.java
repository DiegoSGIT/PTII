package com.RFIDSystem.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.RFIDSystem.daos.EmpleadosDAO;
import com.RFIDSystem.ws.structures.request.EmpleadosRequest;


@Path("/Empleados")
public class EmpleadosWS {
	@Path("/insert")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void insertEmpleados(EmpleadosRequest er) {
		EmpleadosDAO edao = new EmpleadosDAO();
		edao.insertEmpleados(er.getEmpleados());
	}
	
	@Path("/update")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateEmpleados(EmpleadosRequest er) {
		EmpleadosDAO edao = new EmpleadosDAO();
		edao.updateEmpleados(er.getEmpleados());
	}
	
	
}
