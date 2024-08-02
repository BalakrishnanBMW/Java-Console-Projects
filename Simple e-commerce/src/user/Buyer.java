package user;

import inventory.Product;

import java.util.*;

public class Buyer extends User {

	private static List<Buyer> buyers = new ArrayList<Buyer>();

	private List<Product> cart = new ArrayList<>();
	private List<Product> orderedItem = new ArrayList<>();

	public Buyer(String name, String mail, String address, String password) {
		super(name, mail, address, "buyer" ,password);
		buyers.add(this);
	}

	public static List<Buyer> getBuyersList() {
		return buyers;
	}

	public void addToCart(Product p) {
		cart.add(p);
	}

	public void removeFromCart(Product p) {
		cart.remove(p);
	}

	public List<Product> getCart() {
		return cart;
	}


	public void putOrderHistory(Product soldProd) {
		this.orderedItem.add(soldProd);
	}

	public List<Product>  getOrderHistory() {
		return this.orderedItem;
	}

}