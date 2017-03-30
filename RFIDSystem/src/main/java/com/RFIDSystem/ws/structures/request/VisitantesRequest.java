package com.RFIDSystem.ws.structures.request;

import com.RFIDSystem.pojos.Visitantes;

public class VisitantesRequest {
	private Visitantes v;
	
	public VisitantesRequest() {}
	public VisitantesRequest(Visitantes v) {
		this.v = v;
	}
	public Visitantes getVisitantes() {
		return this.v;
	}
	public void setVisitantes(Visitantes v) {
		this.v = v; 
	}
}
