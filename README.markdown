Jersey-Jetty-Guice
====================

A sample standalone server showing how to wire up Jersey, Jetty and Guice together to achieve RESTful bliss.

To install
-----------

Simply:

	$ mvn install
  
To use
-------

1. Create project from archetype

		$ mvn archetype:generate -DarchetypeGroupId=org.birchall -DarchetypeArtifactId=jersey-jetty-guice-archetype -DarchetypeVersion=1.0
  
2. Start the server

		$ mvn compile exec:java -Dexec.mainClass=com.mycorp.Main
  
3. Check it works

		$  curl "http://localhost:8080/foo"
		bar
