package com.RFIDSystem.ws.structures.request;

import com.RFIDSystem.pojos.Empleados;

public class EmpleadosRequest {
	private Empleados e;
	
	public EmpleadosRequest(Empleados e) {
		this.e = e;
	}
	public EmpleadosRequest() {
		
	}
	public Empleados getEmpleados() {
		return e;
	}

	public void setEmpleados(Empleados e) {
		this.e = e;
	}
	
	
	

}
