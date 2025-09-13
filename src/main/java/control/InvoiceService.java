package control;

import java.time.LocalDate;
import java.util.Objects;

import entity.Invoice;
import enums.InvoiceStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InvoiceService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public Invoice save(Invoice invoice) {
		if (Objects.isNull(invoice)) {
			return null;
		}

		if (invoice.getAmount() <= 0) {
			throw new IllegalArgumentException("Invoice amount can't be lower or equals 0.");
		}

		if (invoice.getProcedureId() < 0 || invoice.getProviderId() < 0 || invoice.getUtente() < 0) {
			throw new IllegalArgumentException("A error ocurred, please check informations and try again.");
		}

		invoice.setStatus(InvoiceStatus.RECEIVED);
		invoice.setIssueDate(LocalDate.now());
		em.persist(invoice);

		return invoice;
	}
}
