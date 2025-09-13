package entity;

import java.time.LocalDate;

import enums.InvoiceStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long providerId;
	private long utente;
	private long procedureId;
	private double amount;
	private LocalDate issueDate;
	
	@Enumerated(EnumType.STRING)
    private InvoiceStatus status;
	
}
