package shop;

import java.util.List;

public interface OrderRepo {

    void add(Order order);
    void remove(Order order);
    Order getById(Integer orderId);
    List<Order> getAll();

}
