import api.models.Planet;
import base.BaseStarWarsApiTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SmokeTests extends BaseStarWarsApiTest {

    @Test(groups = "smoke", description = "Get and check planet data")
    public void thirdPlanetSmokeTest() {
        Planet actual = api.getPlanet(3).then().statusCode(HttpStatus.SC_OK).extract().body().as(Planet.class);
        Assert.assertEquals(actual, getPlanetData("thirdPlanetData"), "Planet does not match");
    }

    @Test(groups = "smoke", description = "Get planet with wrong id")
    public void zeroPlanetSmokeTest() {
        api.getPlanet(0).then().statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
