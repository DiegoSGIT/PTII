package com.RFIDSystem.structures;

import com.RFIDSystem.structures.ArticulosCompra;

public class History {
	public Integer id;
	public float monto;
	public Integer visitante;
	public Integer vendedor;
	public ArticulosCompra articulos;
	
	public History() {}
	
	public History(Integer id, float monto, Integer visitante, Integer vendedor) {
		this.id = id;
		this.monto = monto;
		this.visitante = visitante;
		this.vendedor = vendedor;
	
	}
	public History(Integer id, float monto, Integer visitante, Integer vendedor, ArticulosCompra articulos) {
		this.id = id;
		this.monto = monto;
		this.visitante = visitante;
		this.vendedor = vendedor;
		//this.articulos = articulos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Integer getVisitante() {
		return visitante;
	}
	public void setVisitante(Integer visitante) {
		this.visitante = visitante;
	}
	public Integer getVendedor() {
		return vendedor;
	}
	public void setVendedor(Integer vendedor) {
		this.vendedor = vendedor;
	}
	public ArticulosCompra getArticulos() {
		return articulos;
	}
	public void setArticulos(ArticulosCompra articulos) {
		this.articulos = articulos;
	}
	
	

}
