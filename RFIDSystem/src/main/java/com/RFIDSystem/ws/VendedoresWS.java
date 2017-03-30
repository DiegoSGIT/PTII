package com.RFIDSystem.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.RFIDSystem.daos.VendedoresDAO;
import com.RFIDSystem.ws.structures.request.VendedoresRequest;


@Path("/Vendedores")
public class VendedoresWS {
	@Path("/insert")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void insertVendedores(VendedoresRequest vr) {
		VendedoresDAO vdao = new VendedoresDAO();
		vdao.insertVendedor(vr.getVenededores());
	}
	@Path("/update")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateVendedores(VendedoresRequest vr) {
		VendedoresDAO vdao = new VendedoresDAO();
		vdao.updateVendedor(vr.getVenededores());
	}

}
