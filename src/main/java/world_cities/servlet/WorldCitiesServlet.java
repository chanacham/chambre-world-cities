package world_cities.servlet;

import com.google.gson.Gson;
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
        String lon = req.getParameter("lon");
        String lat = req.getParameter("lat");
        String cityName = "";
        ServletResponse worldCitiesRs = new ServletResponse(cityName,lon, lat);
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(worldCitiesRs));
    }
}
