package com.RFIDSystem.ws;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.RFIDSystem.daos.ComprasDAO;
import com.RFIDSystem.ws.structures.request.PaymentRequest;
import com.RFIDSystem.ws.structures.responses.PaymentResponse;

/** 
 * Servicio web de pagos POST 
 * http://localhost:8080/RFIDSystem/rest/Payment/Validate
 * @author diego
 *
 */
@Path("/Payment")
public class PaymentWS {
	

	@Path("/Validate")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public PaymentResponse validate(PaymentRequest p) {
		ComprasDAO cdao = new ComprasDAO();
		PaymentResponse pr = null;
		try {
			pr = cdao.validate(p);
		} catch (Exception e) {
			Logger.getLogger(PaymentWS.class.getName()).log(Level.SEVERE,"Error al ejecutar WS de pagos", e);
		} 
		return pr;
	}
}	