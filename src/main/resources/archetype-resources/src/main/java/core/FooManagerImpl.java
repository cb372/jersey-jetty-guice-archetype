package ${package}.core;

class FooManagerImpl implements FooManager {
	private String theFoo = "bar";
	
	public synchronized String getFoo() {
		return theFoo;
	}

	public synchronized void setFoo(String foo) {
		this.theFoo = foo;
	}

}
