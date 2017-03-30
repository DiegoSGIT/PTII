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
public class Vendedores {
    private Integer idVendedor;
    private String nombre;
    private String apellido;
    private String password;
    private Integer idEstablecimiento;

    public Vendedores(Integer idVendedor, String nombre, String apellido, String password,Integer idEstablecimiento) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.idEstablecimiento = idEstablecimiento;
    }
    public Vendedores(String nombre, String apellido, String password, Integer idEstablecimiento) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.idEstablecimiento = idEstablecimiento;
    }

    public Vendedores() {
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }
    
    
    
}
