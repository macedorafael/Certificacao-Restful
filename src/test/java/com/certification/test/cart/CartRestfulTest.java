package com.certification.test.cart;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.certification.shoppingcart.model.ShoppingCart;
import com.certification.shoppingcart.server.Server;

public class CartRestfulTest {
	
	@BeforeClass
	public static void startServer() throws IOException{
		Server.initServer();
	}
	
	@AfterClass
	public static void stopServer(){
		Server.stopServer();
	}
	
	@Test
	public void testGetCart(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		ShoppingCart car = target.path("/cart/3").request().get(ShoppingCart.class);
		assertEquals("Isis", car.getClient());
	}

}
