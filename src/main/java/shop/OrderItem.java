package shop;

import java.math.BigDecimal;

public record OrderItem(Product product, int quantity) {

    public BigDecimal getTotalPrice() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }

}
