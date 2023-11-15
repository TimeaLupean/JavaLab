package org.example.controller;
import org.example.main.CartItem;

import org.example.repository.CartItemRepository;

import org.example.main.Books;


import java.util.ArrayList;
import java.util.List;

public class CartController {

    private CartItemRepository cartItemRepository;
    List<CartItem> cartItems = new ArrayList<>();

    public CartController(CartItemRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void createcartItem(Books book,int quantity) {
        CartItem cartItem = new CartItem(book,quantity);
        cartItemRepository.save(cartItem);
    }

    public List<CartItem> viewAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void updatecartItem(Books book, int quantity) {
        CartItem updatedcartItem = new CartItem(book,quantity);
        cartItemRepository.update(updatedcartItem);
    }

    public void deletecartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }
}
