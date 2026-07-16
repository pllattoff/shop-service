package shop;

import java.util.*;

public class OrderMapRepo implements OrderRepo {

    private Map<Integer, Order> orders = new HashMap<>();

    @Override
    public void add(Order order) {
        if (order == null) {
            System.out.println("OrderMapRepo::add: order is null");
        }
        if (orders.containsKey(order.id())) {
            System.out.println("OrderMapRepo::add: This order already exists");
        }
        orders.put(order.id(), order);
        System.out.println("OrderMapRepo::add: Order added: " + order);

    }

    @Override
    public void remove(Order order) {
        if (order == null) {
            System.out.println("OrderMapRepo::remove: order is null");
        }
        if (!orders.containsKey(order.id())) {
            System.out.println("OrderMapRepo::remove: This order does not exist: " + order);
        }
        orders.remove(order.id());
        System.out.println("OrderMapRepo::remove: Order removed: " + order);
    }

    @Override
    public Order getById(Integer orderId) {
        if (orderId == null) {
            System.out.println("OrderMapRepo::getById: orderId is null");
        }

        if (!orders.containsKey(orderId)) {
            System.out.println("OrderMapRepo::getById: Order not found: orderId = " + orderId);
            return null;
        }

        return orders.get(orderId);
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public int getMaxId() {
        if (orders.isEmpty()) {
            return 0;
        }
        return Collections.max(orders.keySet());
    }
}
