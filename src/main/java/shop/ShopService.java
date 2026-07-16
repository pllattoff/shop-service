package shop;

import java.util.List;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public void placeOrder(List<Integer> productIds) {
        System.out.println("ShopService::placeOrder: productIds = " + productIds);

        List<Product> products = productRepo.getByIds(productIds);
        int nextId = orderRepo.getMaxId() + 1;

        if (products != null) {
            Order newOrder = new Order(nextId, products);
            orderRepo.add(newOrder);
        } else {
            System.out.println("ShopService::placeOrder: The order was not placed: Such products do not exist");
        }
    }

}
