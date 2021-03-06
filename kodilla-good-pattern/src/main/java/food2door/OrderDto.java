package food2door;

public class OrderDto {
    private OrderRequest orderRequest;
    private boolean isOrdered;

    public OrderDto(OrderRequest orderRequest, boolean isOrdered) {
        this.orderRequest = orderRequest;
        this.isOrdered = isOrdered;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
