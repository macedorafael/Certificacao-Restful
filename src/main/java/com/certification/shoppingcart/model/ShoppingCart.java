package com.certification.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoppingCart {
	
	private Long id;
	private List<Item> items;
	private String client;
	
	ShoppingCart() {
		super();
	}

	public ShoppingCart(Long id, String client) {
		this.id = id;
		this.client = client;
		items = new ArrayList<Item>();
	}
	
	public ShoppingCart addItem(Item item){
		items.add(item);
		return this;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}
	
	public String toXML(){
		return "Retornei um XML";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

	
}
