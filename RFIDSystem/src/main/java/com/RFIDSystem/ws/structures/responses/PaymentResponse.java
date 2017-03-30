package com.RFIDSystem.ws.structures.responses;

public class PaymentResponse {
	public String status;
	public String description;
	public float salgoActual;
	
	public PaymentResponse(String status, String description, float salgoActual) {
		this.status = status;
		this.description = description;
		this.salgoActual = salgoActual;
	}
	public PaymentResponse(String status, String description) {
		this.status = status;
		this.description = description;
	
	}
	public PaymentResponse() {}
	public String getStatus() {
		return this.status;
	}
	public String getDescription() {
		return this.description;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDescription(String description) {
		this.description = description; 
	}
	public float getSalgoActual() {
		return this.salgoActual;
	}
	public void setSalgoActual(float salgoActual) {
		this.salgoActual = salgoActual;
	}
	
	

}
