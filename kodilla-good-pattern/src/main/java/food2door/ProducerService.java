package food2door;

public interface ProducerService {
    OrderDto process(OrderRequest orderRequest, InformationService informationService);

    String getProducerName();
}
