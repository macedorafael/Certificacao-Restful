package com.certification.shoppingcart.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.certification.shoppingcart.Dao.ShoppingCartDao;
import com.certification.shoppingcart.model.Item;
import com.certification.shoppingcart.model.ShoppingCart;

@Path("cart")
public class CartRestful {
	
	ShoppingCartDao dao = new ShoppingCartDao();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{id}")
	public ShoppingCart getCartById(@PathParam("id") long id){
		return dao.getCartByID(id);
		
	}
	
	@Path("{idCart}/item")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response addItemInCart(@PathParam("idCart") Long idCart, Item item){
		ShoppingCart cart = dao.addItemInCart(idCart, item);
		//Devolvendo um header chamado location para o cliente com a uri que acabamos de inserir.
		//Interface Uniforme
		URI uri = URI.create("/cart/" + cart.getId());
		return Response.created(uri).build();
		
	}
	
	@Path("remove/cart/{idCart}")
	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	public Response removeCart(@PathParam("idCart") Long idCart) {
		dao.removeCart(idCart);
		return Response.ok().build();
	}
	
	@Path("{idCart}/remove/item")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response removeItemOfCart(ShoppingCart cart, @PathParam("idCart") Long idCart) {
		dao.removeItemOfCart(cart, idCart);
		return Response.ok().build();
		
	}

}
