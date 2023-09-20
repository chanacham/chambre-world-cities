package worldcities.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import worldcities.City;
import worldcities.ParseWorldCities;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WorldCitiesServletTest {
    @Test
    public void doGet() throws ServletException, IOException {
        //given
        City mockCity = mock();
        ParseWorldCities parseWorldCities = mock();
        doReturn(mockCity).when(parseWorldCities).findClosestCity(40.771724,-73.988326);

        Gson gson = new Gson();

        final WorldCitiesServlet servlet = new WorldCitiesServlet(gson, parseWorldCities);
        HttpServletRequest request = mock();
        doReturn("40.771724").when(request).getParameter("lat");
        doReturn("-73.988326").when(request).getParameter("lon");

        HttpServletResponse response = mock();
        PrintWriter out = mock();
        doReturn(out).when(response).getWriter();

        //when
        servlet.doGet(request,response);

        //then
        verify(response).setContentType("text/json");
        verify(out).println(anyString());

    }

}