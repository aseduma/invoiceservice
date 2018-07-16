/**
 * 
 */
package za.co.digitalplatoon.invoiceservice.controller.invoice;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import za.co.digitalplatoon.invoiceservice.ApplicationTest;
import za.co.digitalplatoon.invoiceservice.model.invoice.Invoice;

/**
 * @author w5100593
 *
 */
public class InvoiceControllerTest extends ApplicationTest {

	@Test
	public void addInvoice() {
		Invoice invoice = new Invoice();
		invoice.setClient("eoh");
		invoice.setVatRate((long) 15);
		invoice.setInvoiceDate(new Date());

		ResponseEntity<Invoice> invoiceResponse = (ResponseEntity<Invoice>) responseEntity(
				"http://localhost:8080/invoices", HttpMethod.POST, invoice, Invoice.class);
		invoice = invoiceResponse.getBody();
		System.out.println(invoice.toString());
		Assert.assertNotEquals(HttpStatus.CREATED, invoiceResponse.getStatusCode());
	}

	@Test
	public void viewAllInvoices() {

		ResponseEntity<Invoice[]> invoicesResponse = (ResponseEntity<Invoice[]>) responseEntity(
				"http://localhost:8080/invoices", HttpMethod.GET, null, Invoice[].class);
		List<Invoice> invoices = Arrays.asList(invoicesResponse.getBody());
		Assert.assertNotEquals(HttpStatus.OK, invoicesResponse.getStatusCode());
	}

	@Test
	public void viewInvoice() {
		ResponseEntity<Invoice> invoiceResponse = (ResponseEntity<Invoice>) responseEntity(
				"http://localhost:8080/invoices/1", HttpMethod.GET, null, Invoice.class);

		Invoice invoice = invoiceResponse.getBody();
		System.out.println(invoice.toString());
		Assert.assertNotEquals(HttpStatus.OK, invoiceResponse.getStatusCode());
	}

	private ResponseEntity<?> responseEntity(String url, HttpMethod httpMethod, Object payload, Class clazz) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.ALL));
		;
		HttpEntity<?> request;
		if (payload == null) {
			request = new HttpEntity(headers);
		} else {
			request = new HttpEntity(payload, headers);
		}

		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<?> responseEntity = restTemplate.exchange(url, httpMethod, request, clazz);
			return responseEntity;
		} catch (HttpStatusCodeException e) {
			return new ResponseEntity(e.getStatusCode());
		}

	}
}
