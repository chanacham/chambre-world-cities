package worldcities.servlet;


/**
 * Json response from WorldCitiesServlet
 *
 * @param cityName name of city
 * @param lat string of lat
 * @param lon string of lon
 */
public record ServletResponse(String cityName, double lat, double lon) {

}
