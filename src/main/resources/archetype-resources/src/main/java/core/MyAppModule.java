package ${package}.core;

import com.google.inject.AbstractModule;

public class MyAppModule extends AbstractModule {
	@Override
	public void configure() {
		bind(FooManager.class).to(FooManagerImpl.class).asEagerSingleton();
	}
}
