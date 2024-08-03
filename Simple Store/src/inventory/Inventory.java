package inventory;

import java.util.HashMap;

public class Inventory {

    private static HashMap<Integer, Product> inventoryList = new HashMap<>();


    public HashMap<Integer, Product> getInventoryList() {
        return inventoryList;
    }

    public void addProductToInventory(Product p) {
        inventoryList.put(p.getProductId(), p);
    }

    public void deleteProductFromInventory(int pid) {
        inventoryList.remove(pid);
    }

    public boolean validateProduct(Product product, int count) {
        return product.getCount() >= count;
    }
}
