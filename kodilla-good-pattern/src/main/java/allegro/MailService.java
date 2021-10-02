package allegro;

public class MailService implements InformationService {

    @Override
    public void inform(OrderRequest orderRequest, boolean isAccepted) {
        if(isAccepted){
            System.out.println(orderRequest.getUser().getName() + " has successfully ordered an item.");
        } else {
            System.out.println("Something went wrong");
        }
    }
}
