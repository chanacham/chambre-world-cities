package worldcities;

import static java.lang.Math.sqrt;

public class City {
    String cityName;
    double latitude;
    double longitude;

    public String getCityName() {
        return cityName;
    }

    public City(String name, double latitude, double longitude) {
        this.cityName = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double calculateDistance(double lat, double lon) {
        return sqrt(((lon - longitude) * (lon - longitude)) + ((lat - latitude) * (lat - latitude)));
    }
}
