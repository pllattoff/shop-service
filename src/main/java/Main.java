import shop.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Smartphone", new BigDecimal("699.50")));
        products.add(new Product(2, "Laptop", new BigDecimal("999.99")));
        products.add(new Product(3, "Monitor", new BigDecimal("249.00")));
        products.add(new Product(4, "Headphones", new BigDecimal("149.95")));
        products.add(new Product(5, "USB-C Cable", new BigDecimal("12.99")));
        products.add(new Product(6, "USB Flash Drive", new BigDecimal("14.00")));
        // Adding products to the repository
        ProductRepo productRepo = new ProductRepo(products);

        //OrderRepo orderRepo = new OrderListRepo();
        OrderRepo orderRepo = new OrderMapRepo();

        ShopService shopService = new ShopService(productRepo, orderRepo);


        // Specifying products and quantities for placing an order
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(productRepo.getById(2), 1));  // Laptop
        orderItems.add(new OrderItem(productRepo.getById(3), 1));  // Monitor
        orderItems.add(new OrderItem(productRepo.getById(5), 3));  // USB-C Cable
        orderItems.add(new OrderItem(productRepo.getById(6), 2));  // USB Flash Drive

        // Placing an order
        shopService.placeOrder(orderItems);

    }
}
