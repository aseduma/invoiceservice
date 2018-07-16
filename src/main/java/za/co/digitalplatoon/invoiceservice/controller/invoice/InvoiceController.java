/**
 * 
 */
package za.co.digitalplatoon.invoiceservice.controller.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.digitalplatoon.invoiceservice.model.invoice.Invoice;
import za.co.digitalplatoon.invoiceservice.service.invoice.InvoiceService;

/**
 * @author w5100593
 *
 */
@RestController
@RequestMapping("/invoices/")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice) {

		Invoice _invoice = invoiceService.addInvoice(invoice);
		if (_invoice != null) {
			return new ResponseEntity(_invoice, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> viewAllInvoices() {
		List<Invoice> invoices = invoiceService.viewAllInvoices();

		if (invoices != null && invoices.size() > 0) {
			return new ResponseEntity(invoices, HttpStatus.OK);
		}

		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@RequestMapping("{invoiceId}")
	public ResponseEntity<Invoice> viewInvoice(@PathVariable("invoiceId") Long invoiceId) {
		Invoice invoice = invoiceService.viewInvoice(invoiceId);

		if (invoice != null) {
			return new ResponseEntity(invoice, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
