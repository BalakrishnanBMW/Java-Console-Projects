package inventory;

import user.Seller;

public class Product {

    private int productId;
    private String productName;
    private int count;
    private double pricePerUnit;
    private Seller seller;
    private static int id = 1;

    public Product(String productName, int count, double pricePerUnit, Seller seller) {
        this.setProductId(this.incId());
        this.setProductName(productName);
        this.setCount(count);
        this.setPricePerUnit(pricePerUnit);
        this.setSeller(seller);
    }

    private int incId() {
        return id++;
    }

    public int getProductId() {
        return productId;
    }

    private void setProductId(int productId) {
        this.productId = productId;
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

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Seller getSeller() {
        return seller;
    }

    private void setSeller(Seller seller) {
        this.seller = seller;
    }
}
