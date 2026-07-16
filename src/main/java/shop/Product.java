package shop;

import java.math.BigDecimal;

public record Product(Integer id, String name, BigDecimal price) {

    public Product withPrice(BigDecimal price) {
        return new Product(id, name, price);
    }

}
