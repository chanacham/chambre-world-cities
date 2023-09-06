package world_cities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ParseWorldCities {
    private double lon;
    private double lat;

    private List<City> cities;

    public ParseWorldCities(double lat, double lon) throws IOException {
        this.lat = lat;
        this.lon = lon;
        cities = loadCityListFromCSV();
    }

    public City findClosestCity(List<City> cities, double lat, double lon) {
        City closestCity = null;
        double minDistance = cities.get(0).calculateDistance(lon, lat);

        for (int i = 1; i < cities.size(); i++) {
            City city = cities.get(i);
            double distance = city.calculateDistance(lon, lat);
            if (distance < minDistance) {
                minDistance = distance;
                closestCity = city;
            }
        }
        return closestCity;
    }

    private List<City> loadCityListFromCSV() throws IOException {
        List<City> cityList = new ArrayList<>();

        File csvData = new File("src/main/resources/WorldCitiesFile.csv");
        CSVParser parser = CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.RFC4180);
        List<CSVRecord> csvRecordList = parser.getRecords();


        for (int i = 1; i < csvRecordList.size(); i++) {
            String cityName = csvRecordList.get(i).get(0);
            double lat = Double.parseDouble(csvRecordList.get(i).get(1));
            double lon = Double.parseDouble(csvRecordList.get(i).get(2));
            cityList.add(new City(cityName, lat, lon));
        }
        return cityList;
    }

    public List<City> getCities() {
        return cities;
    }

}
