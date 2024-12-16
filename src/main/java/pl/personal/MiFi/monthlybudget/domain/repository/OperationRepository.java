package pl.personal.MiFi.monthlybudget.domain.repository;

import pl.personal.MiFi.monthlybudget.domain.entities.Operation;

public interface OperationRepository {

    void saveOperation(Operation operation);
}
