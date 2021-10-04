package food2door.producers;

import food2door.*;
import food2door.informMethods.InformViaMail;

import java.util.HashMap;

public class GlutenFreeShop implements ProducerService {

    private HashMap<Product, Integer> products = new HashMap<>();


    public OrderDto process(OrderRequest orderRequest, InformationService informationService){

        if(!products.containsKey(orderRequest.getProduct())){
            return new OrderDto(orderRequest, false);
        }
        boolean isOrdered = orderRequest.getQuantity() <= products.get(orderRequest.getProduct());

        if (isOrdered) {
            informationService.inform(orderRequest, true);
        } else {
            informationService.inform(orderRequest, false);
        }
        return new OrderDto(orderRequest, isOrdered);
    }

    public String getProducerName() {
        return "GlutenFreeShop";
    }

    public void addProduct(Product product, Integer amount){
        products.put(product, amount);
    }
}
