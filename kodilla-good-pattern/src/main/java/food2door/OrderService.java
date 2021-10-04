package food2door;

public class OrderService {
    public OrderDto process(OrderRequest orderRequest){
        return orderRequest.getProducerService().process(orderRequest, orderRequest.getInformationService());
    }
}
