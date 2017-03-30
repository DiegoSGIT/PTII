package com.RFIDSystem.structures;
/**
 * Clase que modela los parametros que se obtienen desde un procedimiento almacenado que
 * obtiene la ubicación de ciertos visitantes
 * @author diego
 *
 */
public class GetLocationsStructureProcedure {
	private String areaName;
    private String personName;

    public GetLocationsStructureProcedure(String areaName, String personName) {
    	this.areaName = areaName;
    	this.personName = personName;
    	
    }
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }


}
