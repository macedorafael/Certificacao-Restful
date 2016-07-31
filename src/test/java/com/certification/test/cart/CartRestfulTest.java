package com.certification.test.cart;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.certification.shoppingcart.model.Item;
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
	
	@Test
	public void testAddItemInCart(){
		Item item = new Item(7L, new BigDecimal(9), "TesteItem");
		Entity<Item> entity = Entity.entity(item, MediaType.APPLICATION_XML);
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Response reponse = target.path("/cart/3/item").request().post(entity);
		
		assertEquals(Status.CREATED.getStatusCode(), reponse.getStatus());
	}

}
