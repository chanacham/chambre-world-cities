package worldcities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ParseWorldCities {

    private List<City> cities;

    public ParseWorldCities() throws IOException {
        cities = loadCityListFromCsv();
    }

    public City findClosestCity(double lat, double lon) {
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

    private List<City> loadCityListFromCsv() throws IOException {
        List<City> cityList = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("WorldCitiesFile.csv");
        CSVParser parser = CSVParser.parse(inputStream, Charset.defaultCharset(), CSVFormat.RFC4180);
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
