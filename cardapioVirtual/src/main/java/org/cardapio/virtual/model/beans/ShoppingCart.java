package org.cardapio.virtual.model.beans;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private List<Item> cart;
	
	public ShoppingCart(){
		cart = new ArrayList<Item>();
	}
	
	public List<Item> getCart(){
		return cart;
	}
	
	public void addProduct(Item i){
		cart.add(i);
	}
}
