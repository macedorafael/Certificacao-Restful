package com.certification.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import static org.junit.Assert.*;
import org.junit.Test;

public class ClentTesteMock {
	
	@Test
	public void test(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io");
		String c = target.path("/v2/52aaf5bbee7ba8c60329fb7b").request().get(String.class);
		assertTrue(c.contains("Rua Vergueiro"));
	}

}
