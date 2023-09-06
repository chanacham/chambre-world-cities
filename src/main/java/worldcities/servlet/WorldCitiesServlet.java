package worldcities.servlet;

import com.google.gson.Gson;
import worldcities.ParseWorldCities;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet which given two parameters of long and lat, returns a json object of closest city
 */
public class WorldCitiesServlet extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        //find the closest city to the given coordinate
        double lat = Double.parseDouble(req.getParameter("lat"));
        double lon = Double.parseDouble(req.getParameter("lon"));
        ParseWorldCities cities = new ParseWorldCities();
        String cityName = cities.findClosestCity(cities.getCities(), lat, lon).getCityName();

        //servlet response
        ServletResponse worldCitiesRs = new ServletResponse(cityName,lat,lon);
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(worldCitiesRs));
    }
}
