package world_cities.servlet;

import com.google.gson.Gson;
import world_cities.ParseWorldCities;
import world_cities.servlet.ServletResponse;

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
        double lon = Double.parseDouble(req.getParameter("lon"));
        double lat = Double.parseDouble(req.getParameter("lat"));
        ParseWorldCities cities = new ParseWorldCities(lat,lon);
        String cityName = cities.findClosestCity(cities.getCities(), lat,lon).getCityName();

        //servlet response
        ServletResponse worldCitiesRs = new ServletResponse(cityName,String.valueOf(lon), String.valueOf(lat));
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(worldCitiesRs));
    }
}
