package order;

import user.*;

public class Order {

    private int orderId;
    private static int id = 1;
    private String productName;
    private int count;
    private double pricePerCount;
    private Buyer payer;
    private Seller payee;

    public Order(String productName, int count, double pricePerCount, Buyer payer, Seller payee) {
        this.setOrderId(id++);
        this.setProductName(productName);
        this.setCount(count);
        this.setPricePerCount(pricePerCount);
        this.setPayee(payee);
        this.setPayer(payer);
    }

    public int getOrderId() {
        return orderId;
    }

    private void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPricePerCount() {
        return pricePerCount;
    }

    public void setPricePerCount(double pricePerCount) {
        this.pricePerCount = pricePerCount;
    }

    public Buyer getPayer() {
        return payer;
    }

    public void setPayer(Buyer payer) {
        this.payer = payer;
    }

    public Seller getPayee() {
        return payee;
    }

    public void setPayee(Seller payee) {
        this.payee = payee;
    }
}
