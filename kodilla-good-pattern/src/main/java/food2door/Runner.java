package food2door;


import food2door.informMethods.InformViaMail;
import food2door.producers.ExtraFoodShop;
import food2door.producers.GlutenFreeShop;
import food2door.producers.HealthyShop;

public class Runner {
    public static void main(String args[]) {
        InformViaMail mailService = new InformViaMail();
        Product product = new Product("Marchew");

        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HealthyShop healthyShop = new HealthyShop();

        extraFoodShop.addProduct(product, 100);
        glutenFreeShop.addProduct(product, 10);
        healthyShop.addProduct(product, 30);

        OrderService orderService = new OrderService();

        OrderRequest orderRequest = new OrderRequest(product, 50);

        orderService.process(orderRequest, extraFoodShop, mailService);




    }
}
