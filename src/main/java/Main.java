import shop.*;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    static void main() {

        ProductRepo productRepo = new ProductRepo();
        //OrderRepo orderRepo = new OrderListRepo();
        OrderRepo orderRepo = new OrderMapRepo();

        ShopService shopService = new ShopService(productRepo, orderRepo);


        productRepo.add(new Product(1, "Smartphone", new BigDecimal("699.50")));
        productRepo.add(new Product(2, "Laptop", new BigDecimal("999.99")));
        productRepo.add(new Product(3, "Monitor", new BigDecimal("249.00")));
        productRepo.add(new Product(4, "Headphones", new BigDecimal("149.95")));

        shopService.placeOrder(List.of(1,2,3,4));

    }
}
