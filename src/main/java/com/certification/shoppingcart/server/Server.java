package com.certification.shoppingcart.server;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {
	
	private static HttpServer server;
	
	public static void main(String[] args) throws IOException {
		initServer();
		System.out.println("Iniciado...");
		System.in.read();	
		stopServer();
	}

	public static ClientConfig initServer() {
		ResourceConfig config = new ResourceConfig().packages("com.certification.shoppingcart");
		URI uri = URI.create("http://localhost:8080/");
		server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(new LoggingFilter());
		return clientConfig;
		
	}
	
	
	public static void stopServer(){
		server.stop();
	}

}
