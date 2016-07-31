package com.certification.test.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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

import com.certification.shoppingcart.Dao.ShoppingCartDao;
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
		
		ShoppingCart car = target.path("/cart/3").request().get(ShoppingCart.class);
		int lastPosition = ( car.getItems().size() -1 );
		assertTrue("TesteItem".equalsIgnoreCase( car.getItems().get( lastPosition ).getName() ));
		
		car.getItems().remove(lastPosition);
		Entity<ShoppingCart> entity = Entity.entity(car, MediaType.APPLICATION_XML);
		
		Response reponse = target.path("/cart/3/remove/item").request().put(entity);
		assertEquals(Status.OK.getStatusCode(), reponse.getStatus());
		
		ShoppingCart car2 = target.path("/cart/3").request().get(ShoppingCart.class);
		assertEquals(car2.getItems().size(), lastPosition);
	}
	
	@Test
	public void testRemoveCart(){
		ShoppingCartDao dao = new ShoppingCartDao();
		List<ShoppingCart> carts = dao.getCarts();
		int size = carts.size();
		
		Response response = target.path("/cart/remove/cart/" + carts.get(0).getId()).request().delete();
		assertEquals(Status.OK.getStatusCode(), response.getStatus());

		List<ShoppingCart> carts2 = dao.getCarts();
		assertEquals(carts2.size(), (size-1) );
		
	}
	

}
















