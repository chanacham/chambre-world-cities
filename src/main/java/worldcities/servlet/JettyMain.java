package worldcities.servlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Runs the WorldCities servlet locally.
 * It can be accessed through the broswer at
 http://localhost:8080/worldCities?lat=40.771724&lon=-73.988326
 */
public class JettyMain {
    public static void main(String[] args) throws Exception {
        //starts and loads server on port 8080
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});

        //adds the servlet to the Server
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(WorldCitiesServlet.class, "/worldCities");
        server.setHandler(handler);

        //Starts the server until this program exists
        //you must stop the program manually
        server.start();
    }
}
