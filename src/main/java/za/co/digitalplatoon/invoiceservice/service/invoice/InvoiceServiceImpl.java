/**
 * 
 */
package za.co.digitalplatoon.invoiceservice.service.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.digitalplatoon.invoiceservice.model.invoice.Invoice;
import za.co.digitalplatoon.invoiceservice.repository.invoice.InvoiceRepository;

/**
 * @author w5100593
 *
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * za.co.digitalplatoon.invoiceservice.service.invoice.InvoiceService#addInvoice
	 * (za.co.digitalplatoon.invoiceservice.model.invoice.Invoice)
	 */
	@Override
	public Invoice addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return invoiceRepository.save(invoice);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.digitalplatoon.invoiceservice.service.invoice.InvoiceService#
	 * viewAllInvoices()
	 */
	@Override
	public List<Invoice> viewAllInvoices() {
		// TODO Auto-generated method stub
		return invoiceRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.digitalplatoon.invoiceservice.service.invoice.InvoiceService#
	 * viewInvoice(java.lang.Long)
	 */
	@Override
	public Invoice viewInvoice(Long invoiceId) {
		// TODO Auto-generated method stub
		return invoiceRepository.findOne(invoiceId);
	}

}
