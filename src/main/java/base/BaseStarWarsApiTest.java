package base;

import api.models.Planet;
import api.rest.StarWarsApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static utils.PropertyLoader.getProperty;

public class BaseStarWarsApiTest {
    protected StarWarsApi api = new StarWarsApi();
    private ObjectMapper mapper = new ObjectMapper();

    @Step("Get planets list")
    protected List<Planet> getPlanets(String searchQuery) {
        return api.searchPlanets(searchQuery).then().statusCode(HttpStatus.SC_OK).extract()
                .jsonPath().getList("results", Planet.class);
    }

    @SneakyThrows(IOException.class)
    @Step("Read planet data from json file")
    protected Planet getPlanetData(String dataName) {
        return mapper.readValue(new FileReader(getProperty(dataName)), Planet.class);
    }
}
