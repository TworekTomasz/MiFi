package pl.personal.MiFi.monthlybudget.domain.services;

import pl.personal.MiFi.monthlybudget.domain.entities.Income;
import pl.personal.MiFi.monthlybudget.domain.repository.IncomeRepository;

public class CashTransferService {

    public CashTransferService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    private final IncomeRepository incomeRepository;

    public void saveIncome(Income income){
        incomeRepository.saveIncome(income);
    }
}
