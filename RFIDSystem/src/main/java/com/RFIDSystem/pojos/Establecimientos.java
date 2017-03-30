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
public class Establecimientos {
    private Integer idEstablecimiento;
    private String nombre;

    public Establecimientos(Integer idEstablecimiento, String nombre) {
        this.idEstablecimiento = idEstablecimiento;
        this.nombre = nombre;
    }
    public Establecimientos(String nombre) {
        
        this.nombre = nombre;
    }
    

    public Establecimientos() {
    }

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
