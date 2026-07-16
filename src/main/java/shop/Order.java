package shop;

import java.math.BigDecimal;
import java.util.List;

public record Order(Integer id, List<OrderItem> orderItems, BigDecimal totalPrice) {
}
