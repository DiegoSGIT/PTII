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
public class Articulos {
    private Integer sku;
    private String Descripcion;
    private float costo;

    public Articulos(Integer sku, String Descripcion, float costo) {
        this.sku = sku;
        this.Descripcion = Descripcion;
        this.costo = costo;
    }
    

    public Articulos() {
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    
    
    
}
