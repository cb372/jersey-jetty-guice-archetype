package ${package};

import ${package}.servlet.GuiceConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.servlet.GuiceFilter;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Starting server on port 8080");

		// Create the server
		Server server = new Server(8080);

		// Create a servlet context and add the jersey servlet
		ServletContextHandler sch = new ServletContextHandler(server, "/");

		// Add our Guice listener that includes our bindings
		sch.addEventListener(new GuiceConfig());

		// Then add GuiceFilter and configure the server to
		// reroute all requests through this filter.
		sch.addFilter(GuiceFilter.class, "/*", null);

		// Must add DefaultServlet for embedded Jetty.
		// Failing to do this will cause 404 errors.
		sch.addServlet(DefaultServlet.class, "/");

		// Start the server
		server.start();
		
		// Wait for server to shutdown
		server.join();
	}

}
