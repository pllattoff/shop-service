import shop.ShopService;

import java.util.List;

public class Main {
    static void main() {

        ShopService shopService = new ShopService();

        shopService.placeOrder(List.of(1,2));

    }
}
