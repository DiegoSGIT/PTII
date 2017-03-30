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
public class Compras {
    private Integer idCompra;
    private float monto;
    private Integer idVisitante;
    private Integer idVendedor;

    public Compras(Integer idCompra, float monto, Integer idVisitante, Integer idVendedor) {
        this.idCompra = idCompra;
        this.monto = monto;
        this.idVisitante = idVisitante;
        this.idVendedor = idVendedor;
    }
    public Compras(float monto, Integer idVisitante, Integer idVendedor) {
        this.monto = monto;
        this.idVisitante = idVisitante;
        this.idVendedor = idVendedor;
    }
    public Compras() {
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Integer getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Integer idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    
    
}
