package shop;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void getById() {
    }

    @Test
    void getByIds() {
    }

    @Test
    void getAll() {
        //GIVEN
        ProductRepo productRepo = new ProductRepo();

        //WHEN
        List<Product> actual = productRepo.getAll();

        //THEN
        assertEquals(Collections.EMPTY_LIST, actual);
    }
}