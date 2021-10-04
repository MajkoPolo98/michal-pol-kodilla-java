package food2door.producers;

import food2door.*;
import food2door.informMethods.InformViaMail;

import java.util.HashMap;

public class ExtraFoodShop implements ProducerService {

    private HashMap<Product, Integer> products = new HashMap<>();


    public OrderDto process(OrderRequest orderRequest, InformationService informationService){

        if(!products.containsKey(orderRequest.getProduct())){
            return new OrderDto(orderRequest, false);
        }
        boolean isOrdered = orderRequest.getQuantity() <= products.get(orderRequest.getProduct());

        if (isOrdered) {
            informationService.inform(orderRequest, true, getProducerName());
        } else {
            informationService.inform(orderRequest, false, getProducerName());
        }
        return new OrderDto(orderRequest, isOrdered);
    }

    public String getProducerName() {
        return "ExtraFoodShop";
    }

    public void addProduct(Product product, Integer amount){
        products.put(product, amount);
    }
}
