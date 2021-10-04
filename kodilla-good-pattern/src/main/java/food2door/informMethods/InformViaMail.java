package food2door.informMethods;

import food2door.InformationService;
import food2door.OrderDto;
import food2door.OrderRequest;

public class InformViaMail implements InformationService {
    public void inform(OrderRequest orderRequest, boolean isOrdered){
        if(isOrdered){
            System.out.println("Zamówienie: \n" + orderRequest.orderDetails() +"\nzłożone pomyślnie.");
        } else {
            System.out.println("Coś poszło nie tak.");
        }
    }
}
