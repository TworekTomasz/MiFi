package pl.personal.MiFi.monthlybudget.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.personal.MiFi.monthlybudget.application.request.IncomeRequest;
import pl.personal.MiFi.monthlybudget.domain.entities.Income;
import pl.personal.MiFi.monthlybudget.domain.services.CashTransferService;

@RestController
public class IncomeController {

    private final CashTransferService cashTransferService;

    public IncomeController(CashTransferService cashTransferService) {
        this.cashTransferService = cashTransferService;
    }

    @PostMapping("/income")
    public ResponseEntity<Void> saveIncome(@RequestBody IncomeRequest request) {
        final Income income = Income.from(request.getName()).of(request.getAmount());
        cashTransferService.saveIncome(income);
        return ResponseEntity.ok().build();
    }
}
