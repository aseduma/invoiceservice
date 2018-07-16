/**
 * 
 */
package za.co.digitalplatoon.invoiceservice.repository.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.digitalplatoon.invoiceservice.model.invoice.Invoice;

/**
 * @author w5100593
 *
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
