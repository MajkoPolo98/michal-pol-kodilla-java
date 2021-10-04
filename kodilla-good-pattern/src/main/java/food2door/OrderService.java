package food2door;

public class OrderService {
    public OrderDto process(OrderRequest orderRequest, ProducerService producerService, InformationService informationService){
        return producerService.process(orderRequest, informationService);
    }
}
