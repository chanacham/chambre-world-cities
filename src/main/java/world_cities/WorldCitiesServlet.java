package world_cities;

import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Servlet which given two parameters of long and lat, returns a json object of closest city
 */
public class WorldCitiesServlet extends HttpServlet {
    File csvData = new File("WorldCitiesCleanedFile.csv");

    CSVParser parser = CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.RFC4180);
    private Gson gson = new Gson();

    public WorldCitiesServlet() throws IOException {
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String lon = req.getParameter("lon");
        String lat = req.getParameter("lat");
        String cityName = "";
        ServletResponse dictionaryResponse = new ServletResponse(cityName,lon, lat);
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(dictionaryResponse));
    }
}
