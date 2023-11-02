package org.example.controller;

import org.example.main.CartItem;
import org.example.main.Order;
import org.example.repository.OrdersRepository;

import java.util.ArrayList;
import java.util.List;

public class OrdersController {
    private OrdersRepository ordersRepository;
    List<CartItem> cartItems = new ArrayList<>();

    public OrdersController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void createOrder(int orderId, String date, int clientId, int totalPrice, String status, List<CartItem>cartItems) {
        Order order = new Order(orderId, date, clientId, totalPrice, status, cartItems);
        ordersRepository.save(order);
    }


    public Order findOrderById(int orderId) {
        return ordersRepository.findById(orderId);
    }

    public List<Order> viewAllOrders() {
        return ordersRepository.findAll();
    }

    public void updateOrder(int orderId, String date, int totalPrice, int clientId, String status,List<CartItem>cartItems) {
        Order updatedOrder = new Order(orderId, date, totalPrice,clientId, status,cartItems);
        ordersRepository.update(updatedOrder);
    }

    public void deleteOrder(int orderId) {
        ordersRepository.delete(orderId);
    }
}
