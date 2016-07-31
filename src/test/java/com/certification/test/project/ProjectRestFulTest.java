package com.certification.test.project;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.certification.shoppingcart.model.Project;
import com.certification.shoppingcart.server.Server;

public class ProjectRestFulTest {
	
	@BeforeClass
	public static void startServer() throws IOException{
		Server.initServer();
	}
	
	@AfterClass
	public static void stopServer(){
		Server.stopServer();
	}
	
	@Test
	public void testGetProject(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Project project = target.path("/project").request().get(Project.class);
		assertEquals(2014, project.getBeganYear());
	}

}
