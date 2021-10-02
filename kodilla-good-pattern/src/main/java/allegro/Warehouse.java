package allegro;

import java.util.HashMap;

public class Warehouse {
    private HashMap<Item, Integer> products = new HashMap<>();

    public void add(Item item, Integer quantity){
        this.products.put(item, quantity);
    }

    public int getQuantity(Item item){
        return products.get(item);
    }

    public void setQuantity(Item item, Integer quantity){
        products.remove(item);
        products.put(item, quantity);
    }

    public HashMap<Item, Integer> getProducts() {
        return products;
    }
}
