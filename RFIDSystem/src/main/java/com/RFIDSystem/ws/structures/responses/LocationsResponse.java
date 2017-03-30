package com.RFIDSystem.ws.structures.responses;

import java.util.ArrayList;
import java.util.List;

import com.RFIDSystem.structures.GetLocationsStructureProcedure;
/**
 * Clase que mapea el resultado de la búsqueda de ubicaciones en JSON
 * @author diego
 *
 */
public class LocationsResponse {
	public List<GetLocationsStructureProcedure> locations;
	
	public LocationsResponse() {
		locations = new ArrayList<GetLocationsStructureProcedure>();
	}

}
