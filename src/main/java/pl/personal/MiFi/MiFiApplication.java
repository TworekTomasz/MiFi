package pl.personal.MiFi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import pl.personal.MiFi.monthlybudget.domain.entities.Operation;
import pl.personal.MiFi.monthlybudget.domain.repository.OperationRepository;
import pl.personal.MiFi.monthlybudget.domain.services.CashRegisterService;

import java.math.BigDecimal;

import static pl.personal.MiFi.monthlybudget.domain.enums.OperationType.INCOME;

@SpringBootApplication
@Component
public class MiFiApplication implements CommandLineRunner {

	private final CashRegisterService cashRegisterService;

	private OperationRepository operationRepository;

	public MiFiApplication(OperationRepository operationRepository) {
		this.operationRepository = operationRepository;
		this.cashRegisterService = new CashRegisterService(operationRepository);
    }

	public static void main(String[] args) {
		SpringApplication.run(MiFiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Operation income = Operation.builder().name("Test").type(INCOME).amount(BigDecimal.valueOf(1000L)).build();
		cashRegisterService.saveIncome(income);
	}
}
