package food2door;

public class OrderRequest {
    private Product product;
    private InformationService informationService;
    ProducerService producerService;
    private int quantity;

    public OrderRequest(Product product, InformationService informationService, ProducerService producerService, int quantity) {
        this.product = product;
        this.informationService = informationService;
        this.quantity = quantity;
        this.producerService = producerService;
    }

    public Product getProduct() {
        return product;
    }

    public InformationService getInformationService() {
        return informationService;
    }

    public int getQuantity() {
        return quantity;
    }

    public String orderDetails(){
        String details = "Produkt: " + product.getItem() + "\nIlość: " + quantity + "\nDostawca: " + producerService.getProducerName();
        return details;
    }

    public ProducerService getProducerService() {
        return producerService;
    }
}
