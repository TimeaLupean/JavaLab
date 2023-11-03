package org.example;
import org.example.controller.ClientController;
import org.example.main.Books;
import org.example.main.CartItem;
import org.example.main.Clients;
import org.example.repository.BooksRepository;
import org.example.repository.CartItemRepository;
import org.example.repository.ClientsRepository;
import org.example.controller.BookController;
import org.example.controller.CartController;

import java.util.List;
import java.util.Scanner;

public class BookShopUI {
    private Scanner scanner = new Scanner(System.in);
    private Clients currentClient;
    private BookController bookController;
    private CartController cartController;
    private ClientController clientController;

    public BookShopUI(BookController bookController, CartController cartController, ClientController clientController) {
        this.bookController = bookController;
        this.cartController = cartController;
        this.clientController = clientController;
    }

    public void start() {
        while (true) {
            if (currentClient == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        clientController.register();
                        break;
                    case 2:
                        clientController.login();
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

            } else {
                System.out.println("Bookshop Application");
                System.out.println("1. View Books");
                System.out.println("2.Add Book to Cart");
                System.out.println("View Cart");
                System.out.println("Exit");
                System.out.println("Select an option");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        bookController.viewBooks();
                        break;
                    case 2:
                        bookController.addBookToCart();
                        break;
                    case 3:
                        cartController.viewCart();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }

}
