package shop;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo {

    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        if (order == null) {
            System.out.println("shop.OrderListRepo::add: order is null");
        }
        if (orders.contains(order)) {
            System.out.println("shop.OrderListRepo::add: This order already exists");
        }
        orders.add(order);
        System.out.println("shop.OrderListRepo::add: shop.Order added: " + order);
    }

    public void remove(Order order) {
        if (order == null) {
            System.out.println("shop.OrderListRepo::remove: order is null");
        }
        if (!orders.contains(order)) {
            System.out.println("shop.OrderListRepo::remove: This order does not exist: " + order);
        }
        orders.remove(order);
        System.out.println("shop.OrderListRepo::remove: shop.Order removed: " + order);
    }

    public Order get(Integer orderId) {
        if (orderId == null) {
            System.out.println("shop.OrderListRepo::get: orderId is null");
        }

        for (Order order : orders) {
            if (order.id().equals(orderId)) {
                return order;
            }
        }
        System.out.println("shop.OrderListRepo::get: shop.Order not found: orderId = " + orderId);
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
