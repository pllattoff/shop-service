package shop;

import java.util.List;

public record Order(Integer id, List<Product> products) {
}
