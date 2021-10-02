package allegro;

public class OrderRequest {
    private User user;
    private Item item;
    private Integer quantity;

    public OrderRequest(User user, Item item, int quantity) {
        this.user = user;
        this.item = item;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
