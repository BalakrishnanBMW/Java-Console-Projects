package order;

import user.Buyer;
import user.Seller;

public class Order {
    private int orderId;
    private static int id = 1;
    private String productName;
    private int count;
    private double pricePerUnit;
    private Buyer payer;
    private Seller payee;

    public Order(String productName, int count, double pricePerCount, Buyer payer, Seller payee) {
        this.setOrderId(this.incId());
        this.setProductName(productName);
        this.setCount(count);
        this.setPricePerUnit(pricePerCount);
        this.setPayee(payee);
        this.setPayer(payer);
    }

    private int incId() {
        return id++;
    }

    public int getOrderId() {
        return this.orderId;
    }

    private void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return this.productName;
    }

    private void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return this.count;
    }

    private void setCount(int count) {
        this.count = count;
    }

    public double getPricePerUnit() {
        return this.pricePerUnit;
    }

    private void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Buyer getPayer() {
        return this.payer;
    }

    private void setPayer(Buyer payer) {
        this.payer = payer;
    }

    public Seller getPayee() {
        return this.payee;
    }

    private void setPayee(Seller payee) {
        this.payee = payee;
    }
}
