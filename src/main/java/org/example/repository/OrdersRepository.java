package org.example.repository;

import org.example.main.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersRepository {

    private List<Order> orders = new ArrayList<>();

    public Order findById(int targetOrderId) {
        for (Order order : orders) {
            if (order.getOrder_id() == targetOrderId) {
                return order;
            }
        }
        System.out.println("Could not find order with Id: " + targetOrderId);
        return null;
    }

    public List<Order> findAll() {
        if (orders.isEmpty()) {
            System.out.println("There are no orders");
            return null;
        }
        return orders;
    }


    public boolean save(Order order) {
        boolean saved = false;
        for (Order item : orders) {
            if (order.getOrder_id() == item.getOrder_id()) {
                System.out.println("Order already exists");
                return saved;
            }

        }
        orders.add(order);
        for (Order item : orders) {
            if (order.getOrder_id() == item.getOrder_id())
                saved = true;
        }

        return saved;
    }

    public boolean update(Order updatedOrder) {
        boolean updated = false;
        for (Order order : orders) {
            if (order.getOrder_id() == updatedOrder.getOrder_id()) {
                order.setDate(updatedOrder.getDate());
                order.setClient_id(updatedOrder.getClient_id());
                order.setStatus(updatedOrder.getStatus());
                order.calculateTotalPrice();
                updated = true;
                break;
            }
        }
        if (updated == false)
            System.out.println("Order was not updated");

        return updated;
    }

    public boolean delete(int targetOrderId) {
        boolean deleted = false;
        Order orderToRemove = null;
        for (Order order : orders) {
            if (order.getOrder_id() == targetOrderId) {
                orderToRemove = order;
                break;
            }
        }
        if (orderToRemove == null) {
            System.out.println("Order does not exist");
            deleted = false;
        }
        if (orderToRemove != null) {
            orders.remove(orderToRemove);
            deleted = true;
        }
        return deleted;


    }


}
