package worldcities;

import static java.lang.Math.sqrt;

public record City(String cityName, double lat, double lon) {
    public double calculateDistance(double lat2, double lon2) {
        return sqrt(((lon2 - lon) * (lon2 - lon)) + ((lat2 - lat) * (lat2 - lat)));
    }
}
