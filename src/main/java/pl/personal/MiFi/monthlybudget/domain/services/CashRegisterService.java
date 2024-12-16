package pl.personal.MiFi.monthlybudget.domain.services;

import pl.personal.MiFi.monthlybudget.domain.entities.Income;
import pl.personal.MiFi.monthlybudget.domain.repository.IncomeRepository;

public class CashRegisterService {

    private final IncomeRepository incomeRepository;

    public CashRegisterService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public void saveIncome(Income income){
        incomeRepository.saveIncome(income);
    }
}
