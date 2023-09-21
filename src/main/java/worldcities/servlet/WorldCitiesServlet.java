package worldcities.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import worldcities.City;
import worldcities.ParseWorldCities;

import java.io.IOException;

/**
 * Servlet which given two parameters of long and lat, returns a json object of closest city
 */
public class WorldCitiesServlet extends HttpServlet {
    ParseWorldCities cities;
    private Gson gson = new Gson();

    /**
     * This is used by Jetty
     */
    public WorldCitiesServlet() throws IOException {
        this(new Gson(), new ParseWorldCities());
    }

    /**
     * This is used in tests
     *
     * @param gson
     * @param cities
     */
    public WorldCitiesServlet(Gson gson, ParseWorldCities cities) {
        this.gson = gson;
        this.cities = cities;
    }


    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        //find the closest city to the given coordinate
        double lat = Double.parseDouble(req.getParameter("lat"));
        double lon = Double.parseDouble(req.getParameter("lon"));
        String cityName = cities.findClosestCity(lat, lon).cityName();

        //servlet response
        ServletResponse worldCitiesRs = new ServletResponse(cityName, lat, lon);
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(worldCitiesRs));
    }
}
