import base.BaseStarWarsApiTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SearchTests extends BaseStarWarsApiTest {
    @Test(groups = "search", description = "Search planet positive", dataProvider = "positiveSearch")
    public void searchPlanetPositive(String searchQuery) {
        Assert.assertTrue(getPlanets(searchQuery).contains(getPlanetData("alderaanData")),
                "Planets not found");
    }

    @Test(groups = "search", description = "Search planet negative", dataProvider = "negativeSerch")
    public void searchPlanetNegative(String searchQuery) {
        Assert.assertFalse(getPlanets(searchQuery).contains(getPlanetData("alderaanData")),
                "Planets found");
    }

    @DataProvider(name = "positiveSearch")
    public static Object[][] positiveSearchDataProvider() {
        return new Object[][]{{"Alderaan"}, {"alderaan"}, {"Alder"}, {"A"}, {""}};
    }

    @DataProvider(name = "negativeSerch")
    public static Object[][] negativeSearchDataProvider() {
        return new Object[][]{{"1"}, {"*"}, {"Tatoo"}, {"T"}};
    }
}
