package org.example;

import org.example.controller.ClientController;
import org.example.controller.OrdersController;
import org.example.main.Books;
import org.example.main.CartItem;
import org.example.main.Clients;
import org.example.controller.BookController;
import org.example.controller.CartController;
import org.example.controller.ReviewController;
import org.example.controller.PaymentMethodController;
import org.example.main.Order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientUI {
    private final Scanner scanner = new Scanner(System.in);

    private Clients currentClient;
    private int orderid = 0;
    private int reviewID = 0;
    private final BookController bookController;
    private final OrdersController ordersController;
    private final ClientController clientController;
    private final CartController cartItemController;
    private final ReviewController reviewController;
    private final PaymentMethodController paymentMethodController;


    public ClientUI(BookController bookController, OrdersController ordersController, ClientController clientController, CartController cartItemController, ReviewController reviewController, PaymentMethodController paymentMethodController) {
        this.bookController = bookController;
        this.ordersController = ordersController;
        this.clientController = clientController;
        this.cartItemController = cartItemController;
        this.reviewController = reviewController;
        this.paymentMethodController = paymentMethodController;
    }

    //Clients client1 = new Clients(1, "Ana", "Aana","11-12-2002","Ploiesti","a");
    public void start() {
        while (true) {
            System.out.println("Welcome!");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Update data");
            System.out.println("4.Go to bookshop");
            System.out.println("5.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    bookshop();
                    break; //sau return; ?
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void bookshop() {
        while (true) {
            System.out.println("Welcome to Bookshop!");
            System.out.println("1.View Books");
            System.out.println("2.Add Book to Cart");
            System.out.println("3.View Cart");
            System.out.println("4.Leave review");
            System.out.println("5.Finalize order");
            System.out.println("6.Exit");
            System.out.println("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    addBookToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    leaveReview();
                    break;
                case 5:
                    finalizeOrder();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void leaveReview() {
        reviewID++;
        System.out.println("Give book id: ");
        int bookid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Give number of stars(1-5): ");
        int stars = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Give feedback: ");
        String feedback = scanner.nextLine();
        scanner.nextLine();
        String date = getCurrentDateAsString();
        reviewController.createReview(reviewID, stars, feedback, bookid, date);
    }

    public void viewBooks() {
        System.out.println("List of available books:");
        List<Books> availableBooks = bookController.viewAllBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Books book : availableBooks) {
                System.out.println("Book ID: " + book.getBook_id());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Publishing year: " + book.getPublishing_year());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Price: " + book.getPrice());
                System.out.println("Category: " + book.getCategory());
            }
        }
    }

    public void addBookToCart() {
        if (currentClient != null) {
            System.out.println("Enter the book ID to add to the cart: ");
            int bookid = scanner.nextInt();
            scanner.nextLine();
            Books selectedbook = bookController.findBookById(bookid);

            if (selectedbook != null) {
                System.out.println("Enter the quantity: ");
                int quantity = scanner.nextInt();
                CartItem cartItem = new CartItem(selectedbook, quantity);
                ordersController.addItemToOrder(orderid, cartItem);
                System.out.println("Book added to cart.");
            } else {
                System.out.println("Book not found.");
            }
        } else {
            System.out.println("Please log in before adding a book to the cart.");
        }
    }

    public void deleteBookFromCart() {
        if (currentClient != null) {
            System.out.println("Enter the book id you want to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Books booktodelete = bookController.findBookById(id);
            Order order = ordersController.findOrderById(orderid);
            if (booktodelete != null) {
                List<CartItem> cartItems = order.getCartItems();
                for (CartItem cartItem : cartItems) {
                    if (booktodelete == cartItem.getBook()) {
                        if (cartItem.getQuantity() == 1) {
                            order.removeCartItem(cartItem);
                        } else {
                            int quantity = cartItem.getQuantity();
                            cartItem.setQuantity(quantity - 1);
                        }
                    }
                }
            }
        }
    }


    public void finalizeOrder() {
        if (currentClient != null) {
            Order order = ordersController.findOrderById(orderid);
            order.setStatus("processing");
            System.out.println("How would you like to pay?(cahs/card/bank transfer): ");
            String pay_method = scanner.nextLine();
            scanner.nextLine();
            if (pay_method.equalsIgnoreCase("cash")) {
                paymentMethodController.createPaymentMethod(1, "cash", "at delevery");
            } else if (pay_method.equalsIgnoreCase("card")) {
                paymentMethodController.createPaymentMethod(2, "card", "paid");
            } else {
                paymentMethodController.createPaymentMethod(3, "bank transfer", "waiting");
            }
            System.out.println("Order finalized. Thank you for your purchase!");
        } else {
            System.out.println("Please log in before finalizing the order.");
        }
    }

    public void viewCart() {
        if (currentClient != null) {
            Order order = ordersController.findOrderById(orderid);
            List<CartItem> cartItems = order.getCartItems();
            if (cartItems.isEmpty()) {
                System.out.println("Your shopping cart is empty.");
            } else {
                System.out.println("Your shopping cart: ");
                for (CartItem cartItem : cartItems) {
                    System.out.println("Book: " + cartItem.getBook().getTitle());
                    System.out.println("Quantity: " + cartItem.getQuantity());
                }
            }
        } else {
            System.out.println("Please log in to view your shopping cart.");
        }
    }

    public void register() {
        System.out.print("Enter a user ID: ");
        int user_id = scanner.nextInt();
        scanner.nextLine();

        if (clientController.findClientById(user_id) != null) {
            System.out.println("Client ID is already in use. Please choose a different one.");
            return;
        }
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your first name: ");
        String fname = scanner.nextLine();

        System.out.println("Enter your last name: ");
        String lname = scanner.nextLine();

        System.out.println("Enter your birth date: ");
        String birthdate = scanner.nextLine();

        System.out.println("Enter your address: ");
        String address = scanner.nextLine();

        clientController.createClient(user_id, fname, lname, birthdate, address, email);

        System.out.println("Registration successful. You can now log in.");
        //System.out.println("Number of clients in the repository: " + clientsRepository.findAll().size());
    }

    public static String getCurrentDateAsString() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return currentDate.format(formatter);
    }

    public void login() {
        System.out.print("Enter your client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        Clients client = clientController.findClientById(clientId);

        if (client != null && client.getEmail().equals(email)) {
            orderid += 1;
            String date = getCurrentDateAsString();
            List<CartItem> empty = new ArrayList<>();
            ordersController.createOrder(orderid, date, 0, clientId, "initialized", empty);

            currentClient = client;
            System.out.println("Login successful. Welcome, Client ID " + currentClient.getClient_id() + "!");
        } else {
            System.out.println("Invalid client ID or email. Please try again.");
        }
    }

    public void updateData() {
        System.out.print("Enter your ID: ");
        int user_id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your first name: ");
        String fname = scanner.nextLine();

        System.out.println("Enter your last name: ");
        String lname = scanner.nextLine();

        System.out.println("Enter your birth date: ");
        String birthdate = scanner.nextLine();

        System.out.println("Enter your address: ");
        String address = scanner.nextLine();

        clientController.updateClient(user_id, email, fname, lname, birthdate, address);
    }

}