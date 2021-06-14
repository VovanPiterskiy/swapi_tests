package api.rest;

import api.endpoints.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;


import static utils.PropertyLoader.getProperty;

public class StarWarsApi extends RestHelper {
    public StarWarsApi() {
        this.url = getProperty("url");
    }

    @Step("Search planet with id = {id}")
    public Response getPlanet(long id) {
        return get(String.format(Endpoints.PLANETS, id));
    }

    @Step("Search planets with name = {searchQuery}")
    public Response searchPlanets(String searchQuery) {
        return get(String.format(Endpoints.SEARCH_PLANET, searchQuery));
    }
}
