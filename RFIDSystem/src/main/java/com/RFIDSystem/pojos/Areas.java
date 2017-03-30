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
public class Areas {

    private Integer id;
    private String nombre;

    public Areas(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Areas(String nombre) {
       
        this.nombre = nombre;
    }
    public Areas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
}
