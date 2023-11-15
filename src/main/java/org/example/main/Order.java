package org.example.main;

import org.example.main.patterns.Observer.CartItemObserver;

import java.util.ArrayList;
import java.util.List;

public class Order implements CartItemObserver {
    private int order_id;
    private String date;
    private int total_price;
    private int client_id;
    private String status;
    private List<CartItem> cartItems;
    private List<CartItemObserver> cartItemObservers = new ArrayList<>();

    public Order(int order_id, String date, int total_price, int client_id, String status, List<CartItem> cartItems) {
        this.order_id = order_id;
        this.date = date;
        this.total_price = total_price;
        this.client_id = client_id;
        this.status = status;
        this.cartItems = cartItems;

        for (CartItem cartItem : cartItems)
            cartItem.addObserver(this);
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getQuantity() * item.getBook().getPrice();
        }
        return totalPrice;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItems.remove(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public void update(CartItem cartItem) {
        calculateTotalPrice();
    }


}
