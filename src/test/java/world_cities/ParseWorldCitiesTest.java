package world_cities;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ParseWorldCitiesTest {

    @Test
    void loadCityListFromCSV() throws IOException {
        ParseWorldCities cities = new ParseWorldCities(-70, 40);
        assertEquals(cities.getCities().size(), 44691);
    }

    @Test
    void findClosestCity() throws IOException {
        ParseWorldCities cities = new ParseWorldCities(40, 30);
        City testObject = new City("Arar", 40.7, 30.8);
        City result = cities.findClosestCity(cities.getCities(), 40.8, 30.7);
        assertEquals(testObject.getCityName(), result.getCityName());
        
        assertEquals(testObject.getLatitude(), 40.7);
        assertEquals(testObject.getLongitude(), 30.8);

        assertEquals(result.getLongitude(),41.0167);
        assertEquals(result.getLatitude(),30.9833);

    }
}