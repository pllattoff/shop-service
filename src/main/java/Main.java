import shop.*;

import java.util.List;

public class Main {
    static void main() {

        ProductRepo productRepo = new ProductRepo();
//        OrderRepo orderRepo = new OrderListRepo();
        OrderRepo orderRepo = new OrderMapRepo();

        ShopService shopService = new ShopService(orderRepo, productRepo);

        shopService.placeOrder(List.of(1,2));

    }
}
