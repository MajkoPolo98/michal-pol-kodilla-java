package allegro;

public class ProductOrderService {
    private MailService mailService;
    private OrderService orderService;
    private OrderRepository orderRepository;
    private Warehouse warehouse;

    public ProductOrderService(final MailService mailService,
                           final OrderService orderService,
                           final OrderRepository orderRepository,
                               Warehouse warehouse) {
        this.mailService = mailService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.warehouse = warehouse;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isAvailableToBuy = orderService.buy(orderRequest, warehouse);

        if (isAvailableToBuy) {
            mailService.inform(orderRequest, isAvailableToBuy);
            orderRepository.makeOrder(orderRequest);
            return new OrderDto(orderRequest, true);
        } else {
            mailService.inform(orderRequest, isAvailableToBuy);
            return new OrderDto(orderRequest, false);
        }
    }
}
