package pl.personal.MiFi.monthlybudget.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.personal.MiFi.monthlybudget.application.request.IncomeRequest;
import pl.personal.MiFi.monthlybudget.domain.entities.Operation;
import pl.personal.MiFi.monthlybudget.domain.enums.OperationType;
import pl.personal.MiFi.monthlybudget.domain.services.CashRegisterService;

@RestController
public class OperationController {

    private final CashRegisterService cashRegisterService;

    public OperationController(CashRegisterService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }

    @PostMapping("/income")
    public ResponseEntity<Void> saveIncome(@RequestBody IncomeRequest request) {
        final Operation income = Operation.builder().name(request.getName()).type(OperationType.valueOf(request.getType())).amount(request.getAmount()).build();
        cashRegisterService.saveIncome(income);
        return ResponseEntity.ok().build();
    }
}
