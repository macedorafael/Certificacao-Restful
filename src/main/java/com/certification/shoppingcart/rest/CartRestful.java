package com.certification.shoppingcart.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.certification.shoppingcart.Dao.ShoppingCartDao;
import com.certification.shoppingcart.model.ShoppingCart;

@Path("cart")
public class CartRestful {
	
	ShoppingCartDao dao = new ShoppingCartDao();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ShoppingCart getCartById(){
		return dao.getCartByID(1L);
	}

}
