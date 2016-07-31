package com.certification.test.cart;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.certification.shoppingcart.model.Item;
import com.certification.shoppingcart.model.ShoppingCart;
import com.certification.shoppingcart.server.Server;

public class CartRestfulTest {
	
	private static Client client;
	private static WebTarget target;

	@BeforeClass
	public static void startServer() throws IOException{
		ClientConfig clientConfig = Server.initServer();
		client = ClientBuilder.newClient(clientConfig);
		target = client.target("http://localhost:8080");
	}
	
	@AfterClass
	public static void stopServer(){
		Server.stopServer();
	}
	
	@Test
	public void testGetCart(){
		ShoppingCart car = target.path("/cart/3").request().get(ShoppingCart.class);
		assertEquals("Isis", car.getClient());
	}
	
	@Test
	public void testAddItemInCart(){
		Item item = new Item(7L, new BigDecimal(9), "TesteItem");
		Entity<Item> entity = Entity.entity(item, MediaType.APPLICATION_XML);
		
		Response reponse = target.path("/cart/3/item").request().post(entity);
		reponse.getHeaders().get("location");// Deveria fazer outro asset com a uri do location
		assertEquals(Status.CREATED.getStatusCode(), reponse.getStatus());
	}
	
	@Test
	public void testRemoveItemInCart(){
		
		String car = target.path("/cart/3").request().get(String.class);
		assertTrue(car.contains("TesteItem"));
		
		Response reponse = target.path("/cart/3/remove/item/7").request().delete();
		assertEquals(Status.OK.getStatusCode(), reponse.getStatus());
		
		String car2 = target.path("/cart/3").request().get(String.class);
		assertTrue(!car2.contains("TesteItem"));
	}

}
