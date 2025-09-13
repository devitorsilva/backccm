package boundary;

import control.InvoiceService;
import entity.Invoice;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/invoice")
public class InvoiceResource {
	
	@Inject
	private InvoiceService invoiceService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveInoice(Invoice invoice) {
		System.out.println("Received request for create new inovice");

		try {
			Invoice newInvoice = invoiceService.save(invoice);
			return Response.status(Response.Status.CREATED).entity(newInvoice).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}

	}
}
