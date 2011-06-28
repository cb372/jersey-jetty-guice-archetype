package ${package}.servlet;

import java.util.HashMap;
import java.util.Map;

import ${package}.core.MyAppModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new JerseyServletModule() {
			@Override
			protected void configureServlets() {
				install(new MyAppModule());

				// Set init params for Jersey
				Map<String, String> params = new HashMap<String, String>();
				params.put("com.sun.jersey.config.property.packages", "${package}.resources");
				params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

				// Route all requests through GuiceContainer
				serve("/*").with(GuiceContainer.class, params);
			}
		});
	}

}
