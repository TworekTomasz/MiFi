package pl.personal.MiFi.monthlybudget.infrasctructure;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pl.personal.MiFi.monthlybudget.domain.entities.Income;
import pl.personal.MiFi.monthlybudget.domain.repository.IncomeRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

@Repository
public class JsonIncomeRepository implements IncomeRepository {

    private static final Logger log = LoggerFactory.getLogger(JsonIncomeRepository.class);

    @Override
    public void saveIncome(Income income) {
        Gson gson = new Gson();
        // Save income to json file
        String json = gson.toJson(income);

        try(FileWriter file = new FileWriter(Paths.get("src", "main", "resources", "income.json").toString())) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            log.error("Error while saving income to json file", e);
        }
    }
}
