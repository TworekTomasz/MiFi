package pl.personal.MiFi.monthlybudget.domain.entities;

import java.math.BigDecimal;

public class Income {

    private String name;
    private BigDecimal amount;

    private Income() {}

    public static Income from(String name){
        Income income = new Income();
        income.name = name;
        return income;
    }

    public Income of(BigDecimal amount){
        this.amount = amount;
        return this;
    }
}
