package com.RFIDSystem.ws.structures.request;

/**
 * Clase que modela una entrada JSON de compras.
 */


public class PaymentRequest {
	
	public Integer id;
	public float costo;
	public Integer nip;
	public Integer vendedorId; 
	public Compras compras;
	
	public PaymentRequest(){}
	
	public PaymentRequest(Integer id, float costo, Integer NIP, Integer vendedorId, Compras compra) {
		this.id = id;
		this.costo = costo;
		this.nip = NIP;
		this.vendedorId = vendedorId;
		this.compras=compra;
	}
	public int getId() {
		return this.id;
	}
	public float getCosto() {
		return this.costo;
	}
	public int getNIP() {
		return this.nip;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setNIP(int NIP) {
		this.nip = NIP;
	}
	public Integer getVendedorId() {	
		return this.vendedorId;
	}
	public void setVendedorId(Integer vendedorId) {
		this.vendedorId = vendedorId;
	}
	public Compras getCompras() {
		return this.compras;
	}
	public void setCompras(Compras c) {
		this.compras = c;
	}
	

}
