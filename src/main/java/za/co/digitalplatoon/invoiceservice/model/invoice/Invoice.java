/**
 * 
 */
package za.co.digitalplatoon.invoiceservice.model.invoice;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author w5100593
 *
 */
@Entity
public class Invoice {
	@Id
	@GeneratedValue
	private Long id;

	private String client;

	private Long vatRate;

	private Date invoiceDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the vatRate
	 */
	public Long getVatRate() {
		return vatRate;
	}

	/**
	 * @param vatRate
	 *            the vatRate to set
	 */
	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}

	/**
	 * @return the invoiceDate
	 */
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	/**
	 * @param invoiceDate
	 *            the invoiceDate to set
	 */
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	/**
	 * 
	 * @return
	 */
	public BigDecimal getSubTotal() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public BigDecimal getVat() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public BigDecimal getTotal() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", client=" + client + ", vatRate=" + vatRate + ", invoiceDate=" + invoiceDate
				+ "]";
	}

}
