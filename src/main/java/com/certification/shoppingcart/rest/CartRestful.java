package com.certification.shoppingcart.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import com.certification.shoppingcart.Dao.ShoppingCartDao;
import com.certification.shoppingcart.model.Item;
import com.certification.shoppingcart.model.Project;
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
		dao.addItemInCart(idCart, item);
		return Response.status(Status.CREATED).build();
	}

}
