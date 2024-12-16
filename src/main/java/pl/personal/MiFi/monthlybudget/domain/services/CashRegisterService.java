package pl.personal.MiFi.monthlybudget.domain.services;

import pl.personal.MiFi.monthlybudget.domain.entities.Operation;
import pl.personal.MiFi.monthlybudget.domain.repository.OperationRepository;

public class CashRegisterService {

    private final OperationRepository operationRepository;

    public CashRegisterService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void saveIncome(Operation operation){
        operationRepository.saveOperation(operation);
    }
}
