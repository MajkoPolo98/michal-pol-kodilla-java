package allegro;

public class OrderService {
    public boolean buy(OrderRequest orderRequest, Warehouse warehouse){
        return warehouse.getProducts().containsKey(orderRequest.getItem()) &&
                orderRequest.getQuantity() <= warehouse.getQuantity(orderRequest.getItem());
    }

}
