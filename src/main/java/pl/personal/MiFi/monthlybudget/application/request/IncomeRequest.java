package pl.personal.MiFi.monthlybudget.application.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class IncomeRequest {

    private final String name;
    private final String type;
    private final BigDecimal amount;

}
