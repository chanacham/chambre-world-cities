package world_cities;

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
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(WorldCitiesServlet.class, "/definition");
        server.setHandler(handler);

        server.start();
    }
}
