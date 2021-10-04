package food2door.informMethods;

import food2door.InformationService;
import food2door.OrderRequest;
import food2door.ProducerService;

public class InformViaMail implements InformationService {
    public void inform(OrderRequest orderRequest, boolean isOrdered, String producerName){
        if(isOrdered){
            System.out.println("Zamówienie: \n" + orderDetails(orderRequest, producerName) +"\nzłożone pomyślnie.");
        } else {
            System.out.println("Coś poszło nie tak.");
        }
    }
    public String orderDetails(OrderRequest orderRequest, String producerName){
        String details = "Produkt: " + orderRequest.getProduct().getItem() + "\nIlość: " + orderRequest.getQuantity() + "\nDostawca: " + producerName;
        return details;
    }
}
