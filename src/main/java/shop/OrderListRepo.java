package shop;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo {

    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        if (order == null) {
            System.out.println("OrderListRepo::add: order is null");
        }
        if (orders.contains(order)) {
            System.out.println("OrderListRepo::add: This order already exists");
        }
        orders.add(order);
        System.out.println("OrderListRepo::add: Order added: " + order);
    }

    public void remove(Order order) {
        if (order == null) {
            System.out.println("OrderListRepo::remove: order is null");
        }
        if (!orders.contains(order)) {
            System.out.println("OrderListRepo::remove: This order does not exist: " + order);
        }
        orders.remove(order);
        System.out.println("OrderListRepo::remove: Order removed: " + order);
    }

    public Order getById(Integer orderId) {
        if (orderId == null) {
            System.out.println("OrderListRepo::getById: orderId is null");
        }

        for (Order order : orders) {
            if (order.id().equals(orderId)) {
                return order;
            }
        }
        System.out.println("OrderListRepo::getById: Order not found: orderId = " + orderId);
        return null;
    }

    public List<Order> getAll() {
        return orders;
    }

    public int getMaxId() {
        if (orders.isEmpty()) {
            return 0;
        }
        return orders.getLast().id();
    }
}
