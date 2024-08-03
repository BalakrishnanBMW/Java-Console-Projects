package user;

import inventory.Inventory;
import inventory.Product;
import order.Order;
import payment.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Seller extends User{

    private static HashMap<String, Seller> sellers = new HashMap<>();
    private List<Integer> myProducts = new ArrayList<>();
    private HashMap<Integer, Order> mySoldProducts = new HashMap<>();
    private HashMap<Integer, Payment> recievedPayments = new HashMap<>();


    Inventory inventory = new Inventory();

    public Seller(String name, String mail, String address, String password) {
        super(name, mail, address, "seller", password);
        getSellers().put(mail,this);
    }

    public static HashMap<String, Seller> getSellers() {
        return sellers;
    }

    public List<Integer> getMyProducts() {
        return this.myProducts;
    }

    public void addProduct(String productName, int count, double pricePerUnit) {
        Product product = new Product(productName, count, pricePerUnit, this);
        this.myProducts.add(product.getProductId());
        inventory.addProductToInventory(product);
    }

    public HashMap<Integer, Order> getMySoldProducts() {
        return this.mySoldProducts;
    }

    public void addToMySoldProducts(Order order) {
        this.mySoldProducts.put(order.getOrderId() , order);
    }

    public void addToRecievedPayments(Payment payment) {
        this.recievedPayments.put(payment.getPaymentId(), payment);
    }

    public boolean updateProduct(int pid, String productName, int count, double pricePerUnit) {
        if(myProducts.contains(pid)) {
            Product product = inventory.getInventoryList().get(pid);
            product.setProductName(productName);
            product.setCount(count);
            product.setPricePerUnit(pricePerUnit);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(int pid) {
        if(myProducts.contains(pid)) {
            inventory.deleteProductFromInventory(pid);
            myProducts.remove(Integer.valueOf(pid));
            return true;
        }
        return false;
    }
}
