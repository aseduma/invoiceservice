/**
 * 
 */
package za.co.digitalplatoon.invoiceservice.service.invoice;

import java.util.List;

import za.co.digitalplatoon.invoiceservice.model.invoice.Invoice;

/**
 * @author w5100593
 *
 */
public interface InvoiceService {
	Invoice addInvoice(Invoice invoice);

	List<Invoice> viewAllInvoices();

	Invoice viewInvoice(Long invoiceId);
}
