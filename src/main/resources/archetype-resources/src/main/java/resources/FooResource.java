package ${package}.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ${package}.core.FooManager;

import com.google.inject.Inject;

@Path("/foo")
public class FooResource {
	private final FooManager manager;

	@Inject
	public FooResource(FooManager manager) {
		this.manager = manager;
	}

	@GET
	@Produces("application/json")
	public String retrieve() {
		return manager.getFoo();
	}

	@PUT
	@Consumes("application/json")
	public void update(String foo) {
		manager.setFoo(foo);
	}
}
