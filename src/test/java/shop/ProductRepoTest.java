package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    private ProductRepo productRepo;
    private List<Product> products;

    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
        products.add(new Product(1, "Smartphone", new BigDecimal("699.50")));
        products.add(new Product(2, "Laptop", new BigDecimal("999.99")));
        products.add(new Product(3, "Monitor", new BigDecimal("249.00")));

        productRepo = new ProductRepo(products);
    }

    @Test
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void getById() {
        //GIVEN
        Product expectedProduct = products.getFirst();

        //WHEN
        Product actualProduct = productRepo.getById(expectedProduct.id());

        //THEN
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getByIds() {
        //GIVEN
        List<Product> expectedProducts = products;
        List<Integer> productIds = expectedProducts.stream()
                .map(Product::id)
                .toList();

        //WHEN
        List<Product> actualProducts = productRepo.getByIds(productIds);

        //THEN
        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    void getAll() {
        //GIVEN
        List<Product> expectedProducts = products;

        //WHEN
        List<Product> actualProducts = productRepo.getAll();

        //THEN
        assertEquals(expectedProducts, actualProducts);
    }
}