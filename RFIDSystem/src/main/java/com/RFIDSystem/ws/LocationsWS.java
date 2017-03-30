package com.RFIDSystem.ws;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.RFIDSystem.daos.AreasDAO;
import com.RFIDSystem.daos.VisitantesDAO;
import com.RFIDSystem.ws.structures.responses.LocationsResponse;

/**
 * Servicio web de obtencion de ubicacion de visitantes
 * http://localhost:8080/RFIDSystem/rest/Locations/get?id=id
 * @author diego
 * 
 *
 */

@Path("/Locations")

public class LocationsWS {
	
	@GET
	@Path("/get")
	@Produces({MediaType.APPLICATION_JSON})
	public LocationsResponse getLocations(@QueryParam("id") int id){
		LocationsResponse l = new LocationsResponse();
		AreasDAO adao = new AreasDAO();
        l.locations = adao.getLocations(id);
		return l;
	}
	@GET
	@Path("/set")
	public void setLocations(@QueryParam("idvis") int idvis, @QueryParam("idarea") int idarea){
		VisitantesDAO vdao = new VisitantesDAO();
		vdao.setLocation(idvis, idarea);
	}

}
