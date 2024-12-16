package pl.personal.MiFi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import pl.personal.MiFi.monthlybudget.domain.entities.Income;
import pl.personal.MiFi.monthlybudget.domain.repository.IncomeRepository;
import pl.personal.MiFi.monthlybudget.domain.services.CashTransferService;

import java.math.BigDecimal;

@SpringBootApplication
@Component
public class MiFiApplication implements CommandLineRunner {

	private final CashTransferService cashTransferService;

	private IncomeRepository incomeRepository;

	public MiFiApplication(IncomeRepository incomeRepository) {
		this.incomeRepository = incomeRepository;
		this.cashTransferService = new CashTransferService(incomeRepository);
    }

	public static void main(String[] args) {
		SpringApplication.run(MiFiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Income income = Income.from("Salary").of(new BigDecimal(1000));
		cashTransferService.saveIncome(income);
	}
}