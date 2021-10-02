package allegro;

public class OrderDto {
    private boolean isTransactionOk;
    private OrderRequest orderRequest;

    public OrderDto(OrderRequest orderRequest, boolean isTransactionOk) {
        this.orderRequest = orderRequest;
        this.isTransactionOk = isTransactionOk;
    }

    public boolean isTransactionOk() {
        return isTransactionOk;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

}
