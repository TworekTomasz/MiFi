package pl.personal.MiFi.monthlybudget.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.personal.MiFi.monthlybudget.domain.enums.OperationType;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class Operation {
    private String name;
    private OperationType type;
    private BigDecimal amount;
}
