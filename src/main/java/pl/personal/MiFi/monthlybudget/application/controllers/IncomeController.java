package pl.personal.MiFi.monthlybudget.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.personal.MiFi.monthlybudget.application.request.IncomeRequest;
import pl.personal.MiFi.monthlybudget.domain.entities.Income;
import pl.personal.MiFi.monthlybudget.domain.services.CashRegisterService;

@RestController
public class IncomeController {

    private final CashRegisterService cashRegisterService;

    public IncomeController(CashRegisterService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }

    @PostMapping("/income")
    public ResponseEntity<Void> saveIncome(@RequestBody IncomeRequest request) {
        final Income income = Income.from(request.getName()).of(request.getAmount());
        cashRegisterService.saveIncome(income);
        return ResponseEntity.ok().build();
    }
}
