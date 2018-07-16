/**
 * 
 */
package za.co.digitalplatoon.invoiceservice.service.invoice;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import za.co.digitalplatoon.invoiceservice.ApplicationTest;
import za.co.digitalplatoon.invoiceservice.model.invoice.Invoice;

/**
 * @author w5100593
 *
 */
public class InvoiceServiceTest extends ApplicationTest {
	@Autowired
	private InvoiceService invoiceService;

	@Test
	public void addInvoice() {
		Invoice invoice = new Invoice();
		invoice.setClient("eoh");
		invoice.setVatRate((long) 15);
		invoice.setInvoiceDate(new Date());
		invoiceService.addInvoice(invoice);
		Assert.assertNotEquals(null, invoice.getId());
	}

	@Test
	public void viewAllInvoices() {
		List<Invoice> invoices = invoiceService.viewAllInvoices();
		System.out.println(invoices.size());
		Assert.assertNotNull(invoices);
	}

	@Test
	public void viewInvoiceAssertNotNull() {
		Invoice invoice = invoiceService.viewInvoice((long) 1);
		Assert.assertNotNull(invoice);
	}

	@Test
	public void viewInvoiceAssertEqual() {
		Invoice invoice = invoiceService.viewInvoice((long) 1);
		Assert.assertEquals(Long.valueOf(1), invoice.getId());
	}
}
