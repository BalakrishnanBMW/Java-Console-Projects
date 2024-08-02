package inventory;

public class Product {

    private int productId;
    private int count;
    private double pricePerUnit;
    private String productName;
    private int sellerId;
    private static int id = 1;
    private double soldPrice;

    public Product(String productName, int count, double pricePerUnit, int sellerId) {

        this.productId = id++;
        this.setProductName(productName);
        this.setCount(count);
        this.setPricePerUnit(pricePerUnit);
        this.setSellerId(sellerId);

    }

    public Product(String productName, int count, double soldPrice) {
        this.productName = productName;
        this.count = count;
        this.soldPrice = soldPrice;
    }

    public String toString() {
        return "" + this.getProductId() +". "+ this.getProductName() +
                "  $"+ this.getPricePerUnit() +
                " \tavailable stock:"+ this.getCount();
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerName) {
        this.sellerId = sellerName;
    }

    public int getProductId() {
        return productId;
    }

    public double getSoldProd() { return soldPrice; }
}