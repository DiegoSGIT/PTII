package com.RFIDSystem.ws.structures.request;

import com.RFIDSystem.pojos.Vendedores;

public class VendedoresRequest {
	private Vendedores v;
	
	public VendedoresRequest() {}
	public VendedoresRequest(Vendedores v) {
		this.v = v;
	}
	public void setVendedores(Vendedores v) {
		this.v = v;
	}
	public Vendedores getVenededores() {
		return this.v;
	}
}
