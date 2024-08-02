package user;

import inventory.*;
import order.*;
import payment.Payment;

import java.util.*;

public class Buyer extends User {

	private static List<Buyer> buyers = new ArrayList<Buyer>();

	private List<Product> cart = new ArrayList<>();
	private List<Order> orderedItem = new ArrayList<>();
	private List<Payment> payments = new ArrayList<>();

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


	public void putOrderHistory(Order soldProd) {
		this.orderedItem.add(soldProd);
	}

	public List<Order>  getOrderHistory() {
		return this.orderedItem;
	}

	public void putPayments(Payment payment) {
		this.payments.add(payment);
	}

	public Payment getPaymentById(int oid) {
		for(Payment p : payments) {
			if(oid == p.getOrder().getOrderId()) {
				return p;
			}
		}
		return null;
	}
}