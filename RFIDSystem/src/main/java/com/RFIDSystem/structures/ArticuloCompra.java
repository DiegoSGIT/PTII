package com.RFIDSystem.structures;

public class ArticuloCompra {
	private String descripcion;
	private Integer cantidad;
	public ArticuloCompra() {
	}
	public ArticuloCompra(String decripcion, Integer cantidad) {
		this.descripcion = decripcion;
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
