package worldcities.servlet;


/**
 * Json response from WorldCitiesServlet
 *
 * @param cityName name of city
 * @param lon string of lon
 * @param lat string of lat
 */
public record ServletResponse(String cityName, String lon, String lat) {

}
