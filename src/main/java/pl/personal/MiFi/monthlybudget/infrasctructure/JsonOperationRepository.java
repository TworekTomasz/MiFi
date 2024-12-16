package pl.personal.MiFi.monthlybudget.infrasctructure;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pl.personal.MiFi.monthlybudget.domain.entities.Operation;
import pl.personal.MiFi.monthlybudget.domain.repository.OperationRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

@Repository
public class JsonOperationRepository implements OperationRepository {

    private static final Logger log = LoggerFactory.getLogger(JsonOperationRepository.class);

    @Override
    public void saveOperation(Operation operation) {
        Gson gson = new Gson();
        // Save operation to json file
        String json = gson.toJson(operation);

        try(FileWriter file = new FileWriter(Paths.get("src", "main", "resources", "income.json").toString())) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            log.error("Error while saving operation to json file", e);
        }
    }
}
