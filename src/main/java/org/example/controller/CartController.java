package org.example.controller;
import org.example.main.CartItem;
import org.example.main.Clients;
import org.example.repository.CartItemRepository;

import java.util.List;

public class CartController {
    private CartItemRepository cartItemRepository;
    private Clients currentClient;

    public CartController(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void viewCart(){
        List<CartItem> userCart = cartItemRepository.findByUser(currentClient.getClient_id());
        if(userCart.isEmpty()){
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Your shopping cart: ");
            for(CartItem cartItem : userCart){
                System.out.println("Book: " + cartItem.getBook().getTitle());
                System.out.println("Quantity: " + cartItem.getQuantity());
                System.out.println("------------");
            }
        }
    }
}
