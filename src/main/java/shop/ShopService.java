package shop;

import java.math.BigDecimal;
import java.util.List;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(List<OrderItem> orderItems) {
        System.out.println("ShopService::placeOrder: orderItems = " + orderItems);

        if (orderItems == null || orderItems.isEmpty()) {
            System.out.println("ShopService::placeOrder: orderItems is null or empty");
            return;
        }

        int nextId = orderRepo.getMaxId() + 1;
        BigDecimal totalPrice = this.calculateTotalPrice(orderItems);

        Order newOrder = new Order(nextId, orderItems, totalPrice);
        orderRepo.add(newOrder);
    }

    private BigDecimal calculateTotalPrice(List<OrderItem> orderItems) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderItem orderItem : orderItems) {
            totalPrice = totalPrice.add(orderItem.getTotalPrice());
        }
        return totalPrice;
    }

}
