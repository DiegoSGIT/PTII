package com.RFIDSystem.structures;

/**
 * Clase que modela los identificadores de producto.
 * @author diego
 *
 */
public class ArticlesIDS {
	public Integer articleID;
	public Integer cantidad;
	
	public ArticlesIDS() {}
	public ArticlesIDS(Integer articleID, Integer cantidad) {
		this.articleID = articleID;
		this.cantidad = cantidad;
	}
	public Integer getArticleID() {
		return this.articleID;
	}
	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}
	public Integer getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;	
	}

}
