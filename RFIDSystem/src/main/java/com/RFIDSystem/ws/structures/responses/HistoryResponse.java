package com.RFIDSystem.ws.structures.responses;

import java.util.ArrayList;
import java.util.List;
import com.RFIDSystem.structures.History;

public class HistoryResponse {
	public List<History> historialCompras;
	
	public HistoryResponse() {
		historialCompras = new ArrayList<History>();
	}
	
	

}
