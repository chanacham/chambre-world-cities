package world_cities;

import static java.lang.Math.sqrt;

public class City {
    String cityName;
    double latitude;

    public String getCityName() {
        return cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    double longitude;

    public City(String name, double latitude, double longitude) {
        this.cityName = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double calculateDistance(double lon, double lat) {
        return sqrt(((lon-longitude) * (lon-longitude)) + ((lat - latitude) * (lat - latitude)));
    }
}
