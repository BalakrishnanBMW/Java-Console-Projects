package user;

import inventory.Product;
import order.Order;
import payment.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer extends User {

    private static HashMap<String, Buyer> buyers = new HashMap<>();
    private List<Integer> myCart = new ArrayList<Integer>();
    private HashMap<Integer, Order> myOrders = new HashMap<>();
    private HashMap<Integer, Payment> madePayments = new HashMap<>();

    public Buyer(String name, String mail, String address, String password) {
        super(name, mail, address, "buyer", password);
        getBuyers().put(mail,this);
    }


    public static HashMap<String, Buyer> getBuyers() {
        return buyers;
    }


    public List<Integer> getMyCart() {
        return this.myCart;
    }

    public void addToMyCart(int pid) {
	if(!this.myCart.contains(pid))
            this.myCart.add(pid);
    }

    public void removeFromMyCart(int pid) {
        this.myCart.remove(Integer.valueOf(pid));
    }


    public HashMap<Integer, Order> getMyOrders() {
        return this.myOrders;
    }

    public void addToMyOrders(Order order) {
        this.myOrders.put(order.getOrderId() , order);
    }


    public void addToMadePayments(Payment payment) {
        this.madePayments.put(payment.getPaymentId(), payment);
    }

}
