package shop;

import java.util.List;

public class ShopService {

    private ProductRepo productRepo = new ProductRepo();
    private OrderListRepo orderListRepo = new OrderListRepo();

    public void placeOrder(List<Integer> productIds) {
        System.out.println("shop.ShopService::placeOrder: productIds = " + productIds);

        List<Product> products = productRepo.get(productIds);
        int nextId = orderListRepo.getMaxId() + 1;

        if (products != null) {
            Order newOrder = new Order(nextId, products);
            orderListRepo.add(newOrder);
        } else {
            System.out.println("shop.ShopService::placeOrder: The order was not placed: products is null");
        }
    }

}
