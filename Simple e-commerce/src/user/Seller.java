package user;

import inventory.*;
import order.*;
import payment.Payment;

import java.util.*;

public class Seller extends User {

	private static List<Seller> sellers = new ArrayList<Seller>();

	private List<Product> MyInventories = new ArrayList<>();

	private List<Order> soldItems = new ArrayList<>();

	Inventory inventory = new Inventory();

	public Seller(String name, String mail, String address, String password) {
		super(name, mail, address, "seller" ,password);
		sellers.add(this);
	}

	public static Seller getSellerById(int sellerId) {
		for(Seller s : sellers) {
			if(s.getUserId() == sellerId) {
				return s;
			}
		}
		return null;
	}

	public boolean updateProduct(int pid, String productName, int count, double pricePerUnit) {
		for(Product p : MyInventories) {
			if(p.getProductId() == pid) {
				p.setProductName(productName);
				p.setCount(count);
				p.setPricePerUnit(pricePerUnit);
				return true;
			}
		}
		return false;
	}

	public List<Product> getMyInventories() {
		return MyInventories;
	}

	public void addProduct(String productName, int count, double pricePerUnit) {
		Product product = new Product(productName, count, pricePerUnit, this.getUserId());
		MyInventories.add(product);
		inventory.addProductToInv(product);
	}



	public static List<Seller> getSellersList() {
		return sellers;
	}

	public Product getproductById(int pid){
        for(Product p : MyInventories) {
			if(p.getProductId() == pid) {
				return p;
			}
		}
		return null;
	}

	public void deleteProduct(int pid) {
		Product p = getproductById(pid);
		MyInventories.remove(p);
		inventory.deleteProductFromInv(p);
	}

	public void putSoldHistory(Order sp) {
		soldItems.add(sp);
	}


	/**
	 * return the sold Item of the user
	 * */
	public List<Order> getSoldItems() {
		return soldItems;
	}

	public void recievedPayments(Payment payment) {
	}
}