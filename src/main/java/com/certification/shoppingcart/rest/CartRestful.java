package com.certification.shoppingcart.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.certification.shoppingcart.Dao.ShoppingCartDao;
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

}
