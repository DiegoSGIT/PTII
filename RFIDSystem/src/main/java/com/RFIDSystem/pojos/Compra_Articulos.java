/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RFIDSystem.pojos;

/**
 *
 * @author diego
 */
public class Compra_Articulos {
    private Integer idArticulo;
    private Integer idCompra;

    public Compra_Articulos(Integer idArticulo, Integer idCompra) {
        this.idArticulo = idArticulo;
        this.idCompra = idCompra;
    }

    public Compra_Articulos() {
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
    
    
}
