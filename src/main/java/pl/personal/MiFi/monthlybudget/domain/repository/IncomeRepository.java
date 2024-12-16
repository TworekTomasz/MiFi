package pl.personal.MiFi.monthlybudget.domain.repository;

import pl.personal.MiFi.monthlybudget.domain.entities.Income;

public interface IncomeRepository {

    void saveIncome(Income income);
}
