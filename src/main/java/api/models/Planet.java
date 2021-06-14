package api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Planet {
    @JsonProperty("name")
    public String name;
    @JsonProperty("rotation_period")
    public String rotationPeriod;
    @JsonProperty("orbital_period")
    public String orbitalPeriod;
    @JsonProperty("diameter")
    public String diameter;
    @JsonProperty("climate")
    public String climate;
    @JsonProperty("gravity")
    public String gravity;
    @JsonProperty("terrain")
    public String terrain;
    @JsonProperty("surface_water")
    public String surfaceWater;
    @JsonProperty("population")
    public String population;
    @JsonProperty("residents")
    public List<String> residents = null;
    @JsonProperty("films")
    public List<String> films = null;
    @JsonProperty("created")
    public String created;
    @JsonProperty("edited")
    public String edited;
    @JsonProperty("url")
    public String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        residents.sort(Comparator.naturalOrder());
        planet.residents.sort(Comparator.naturalOrder());
        films.sort(Comparator.naturalOrder());
        planet.films.sort(Comparator.naturalOrder());
        return Objects.equals(name, planet.name) &&
                Objects.equals(rotationPeriod, planet.rotationPeriod) &&
                Objects.equals(orbitalPeriod, planet.orbitalPeriod) &&
                Objects.equals(diameter, planet.diameter) &&
                Objects.equals(climate, planet.climate) &&
                Objects.equals(gravity, planet.gravity) &&
                Objects.equals(terrain, planet.terrain) &&
                Objects.equals(surfaceWater, planet.surfaceWater) &&
                Objects.equals(population, planet.population) &&
                Objects.equals(residents, planet.residents) &&
                Objects.equals(films, planet.films) &&
                Objects.equals(created, planet.created) &&
                Objects.equals(edited, planet.edited) &&
                Objects.equals(url, planet.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rotationPeriod, orbitalPeriod, diameter, climate, gravity, terrain, surfaceWater, population, residents, films, created, edited, url);
    }
}
