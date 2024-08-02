package inventory;

import java.util.*;
import user.*;

public class Inventory {
    static List<Product> inventoryList = new ArrayList<>();

    public List<Product> getInventoryList() {
        return inventoryList;
    }

    public void addProductToInv(Product p) {
        inventoryList.add(p);
    }

    public void deleteProductFromInv(Product p) {
        inventoryList.remove(p);
    }

    public Product getProductById(int pid) {
        for(Product p:inventoryList) {
            if(p.getProductId() == pid) {
                return p;
            }
        }
        return null;
    }


    public boolean validateProduct(int pid, int count) {
        Product p = getProductById(pid);
        if(p!=null){
            if(p.getCount()>=count)
                return true;
        }
        return false;

    }
}
