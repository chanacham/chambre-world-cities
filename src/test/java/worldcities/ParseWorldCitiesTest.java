package worldcities;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ParseWorldCitiesTest {

    @Test
    void loadCityListFromCsv() throws IOException {
        ParseWorldCities cities = new ParseWorldCities();
        assertEquals(cities.getCities().size(), 44691);
    }

    @Test
    void findClosestCity() throws IOException {
        ParseWorldCities cities = new ParseWorldCities();
        City result = cities.findClosestCity(40.8, 30.7);
        assertEquals(result.cityName(), "Arar");

        assertEquals(result.lon(), 41.0167);
        assertEquals(result.lat(), 30.9833);

    }
}