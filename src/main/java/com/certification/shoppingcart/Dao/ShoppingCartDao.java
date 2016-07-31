package com.certification.shoppingcart.Dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.certification.shoppingcart.model.Item;
import com.certification.shoppingcart.model.ShoppingCart;

public class ShoppingCartDao {
	
	private static List<ShoppingCart> carts = new ArrayList<ShoppingCart>();
	
	static{
		carts.add(new ShoppingCart(1L, "Rafael")
			.addItem(new Item(1L, new BigDecimal(4.8), "Chocolate"))
			.addItem(new Item(2L, new BigDecimal(5.7), "Arroz"))
			.addItem(new Item(3L, new BigDecimal(10.7), "Carne"))
			.addItem(new Item(4L, new BigDecimal(100.7), "Tomate"))
			);
		
		carts.add(new ShoppingCart(2L, "Amanda")
			.addItem(new Item(5L, new BigDecimal(7.8), "Sapato"))
			.addItem(new Item(6L, new BigDecimal(8.7), "Bolsa"))
			.addItem(new Item(7L, new BigDecimal(17.7), "Chocolate"))
			.addItem(new Item(8L, new BigDecimal(170.7), "Ursinho"))
			);
		
		carts.add(new ShoppingCart(3L, "Isis")
			.addItem(new Item(9L, new BigDecimal(74.8), "Ração"))
			.addItem(new Item(9L, new BigDecimal(59.7), "coleira"))
			.addItem(new Item(11L, new BigDecimal(180.7), "Petisco"))
			.addItem(new Item(12L, new BigDecimal(10440.7), "Brinquedos"))
			);
	}
	
	public List<ShoppingCart> getCarts(){
		return carts;
	}

	public ShoppingCart getCartByID(Long id){
		for(ShoppingCart cart : carts)
			if(cart.getId().equals(id))
				return cart;
		return null;
	}
	
	public Item getItemOfCartByID(Long idCart, Long ItemId){
		
		for(ShoppingCart cart : carts)
			if(cart.getId().equals(idCart)){
				for(Item item : cart.getItems())
					if(item.getId().equals(ItemId))
						return item;
				return null;
				}
		return null;
		
	}
	
	public ShoppingCart addItemInCart(Long idCart, Item item){
		ShoppingCart cart = getCartByID(idCart);
		return cart.addItem(item);
	}
	
	
	public void removeItemOfCart(Long idCart, Long idItem) {
		ShoppingCart cart = getCartByID(idCart);
		cart.removeItem(idItem);
	}
	
}
