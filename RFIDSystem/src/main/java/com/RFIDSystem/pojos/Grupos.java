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
public class Grupos {
    private Integer idGrupo;
    private String nombre;

    public Grupos(Integer idGrupo, String nombre) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
    }
    public Grupos(String nombre) {
        this.nombre = nombre;
    }
    public Grupos() {
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
