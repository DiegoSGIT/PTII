package com.RFIDSystem.ws;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.RFIDSystem.daos.EmpleadosDAO;
import com.RFIDSystem.ws.structures.request.LoginRequest;
import com.RFIDSystem.ws.structures.responses.LoginEmpleadoResponse;

@Path("/Login")
public class LoginWS {

	@Path("/Empleado")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public LoginEmpleadoResponse SingInEmpleado(LoginRequest lr) {
		EmpleadosDAO edao = new EmpleadosDAO();
		LoginEmpleadoResponse ler = edao.checkLogin(lr);
		return ler;
	}
}
