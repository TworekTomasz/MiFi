package pl.personal.MiFi.monthlybudget.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.personal.MiFi.monthlybudget.domain.repository.OperationRepository;
import pl.personal.MiFi.monthlybudget.domain.services.CashRegisterService;

@Configuration
public class AppConfig {

    @Bean
    public CashRegisterService cashTransferService(OperationRepository operationRepository) {
        return new CashRegisterService(operationRepository);
    }
}
