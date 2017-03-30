package com.RFIDSystem.ws.structures.responses;

public class LoginEmpleadoResponse {
	
	private int id;
	private String name;
	private boolean gerente;
	
	public LoginEmpleadoResponse() {}
	
	public LoginEmpleadoResponse(int id, boolean gerente, String name) {
		this.id = id;
		this.gerente = gerente;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isGerente() {
		return gerente;
	}
	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
