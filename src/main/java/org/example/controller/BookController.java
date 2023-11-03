package org.example.controller;
import java.util.Scanner;
import org.example.main.Books;
import org.example.main.CartItem;
import org.example.main.Clients;
import org.example.repository.BooksRepository;
import org.example.repository.CartItemRepository;

import java.util.List;

public class BookController {
    private BooksRepository bookRepository;
    private CartItemRepository cartItemRepository;
    private Scanner scanner = new Scanner(System.in);
    private Clients currentClient;

    public BookController(BooksRepository bookRepository, CartItemRepository cartItemRepository) {
        this.bookRepository = bookRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public void viewBooks(){
        System.out.println("List of available books:");
        List<Books> availableBooks = bookRepository.findAll();
        if(availableBooks.isEmpty()){
            System.out.println("No books available.");
        } else {
            for(Books book : availableBooks){
                System.out.println("Book ID: " + book.getBook_id());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Publishing year: " + book.getPublishing_year());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Price: " + book.getPrice());
                System.out.println("Category: " + book.getCategory());
                System.out.println("------------");
            }
        }
    }

    public void addBookToCart(){
        System.out.println("Enter the book ID to add to the cart: ");
        int bookid = scanner.nextInt();
        scanner.nextLine();

        Books selectedbook = bookRepository.findById(bookid);
        if(selectedbook == null){
            System.out.println("Book not found.");
            return;
        }

        System.out.println("Enter the quantity: ");
        int quantity = scanner.nextInt();

        CartItem cartItem = new CartItem(selectedbook, quantity, currentClient.getClient_id());
        cartItemRepository.save(cartItem);
        System.out.println("Book added to the cart.");
    }


}