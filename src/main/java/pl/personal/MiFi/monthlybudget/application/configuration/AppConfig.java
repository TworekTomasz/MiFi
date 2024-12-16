package pl.personal.MiFi.monthlybudget.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.personal.MiFi.monthlybudget.domain.repository.IncomeRepository;
import pl.personal.MiFi.monthlybudget.domain.services.CashRegisterService;

@Configuration
public class AppConfig {

    @Bean
    public CashRegisterService cashTransferService(IncomeRepository incomeRepository) {
        return new CashRegisterService(incomeRepository);
    }
}
