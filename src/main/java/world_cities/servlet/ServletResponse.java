package world_cities.servlet;


/**
 * Json response from WorldCitiesServlet
 * @param lon
 * @param lat
 */
public record ServletResponse (String cityName, String lon, String lat) {

}
