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
public class Empleados {
    private Integer idEmpleado;
    private String nombre;
    private String apellido;
    private String password;
    private boolean gerente;

    public Empleados(Integer idEmpleado, String nombre, String apellido, String password, boolean gerente) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.gerente = gerente;
    }
    public Empleados(String nombre, String apellido, String password, boolean gerente) {
     
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.gerente = gerente;
    }

    public Empleados() {
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }
    
    
    
}
