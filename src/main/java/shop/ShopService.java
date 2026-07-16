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

    public void placeOrder(List<Integer> productIds) {
        System.out.println("ShopService::placeOrder: productIds = " + productIds);

        List<Product> products = productRepo.getByIds(productIds);
        if (products.isEmpty()) {
            System.out.println("ShopService::placeOrder: The order was not placed: Such products do not exist");
            return;
        }

        int nextId = orderRepo.getMaxId() + 1;
        BigDecimal totalPrice = calculateTotalPrice(products);

        Order newOrder = new Order(nextId, products, totalPrice);
        orderRepo.add(newOrder);
    }

    private BigDecimal calculateTotalPrice(List<Product> products) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : products) {
            totalPrice = totalPrice.add(product.price());
        }
        return totalPrice;
    }

}
