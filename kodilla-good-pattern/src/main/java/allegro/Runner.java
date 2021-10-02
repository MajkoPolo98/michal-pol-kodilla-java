package allegro;

public class Runner {
    public static void main(String args[]){
        MailService mailService = new MailService();
        OrderService orderService = new OrderService();
        OrderRepository orderRepository = new OrderRepository();
        Warehouse warehouse = new Warehouse();
        Item item = new Item("Kapcie", 25.45);
        warehouse.add(item, 50);
        ProductOrderService allegro = new ProductOrderService(mailService, orderService, orderRepository, warehouse);

        OrderRequest order = new OrderRequest(new User("Krzysiek"), item, 2);

        allegro.process(order);
    }
}
