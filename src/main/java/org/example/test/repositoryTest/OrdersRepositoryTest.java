package org.example.test.repositoryTest;

import org.example.main.*;
import org.junit.jupiter.api.Test;
import org.example.repository.OrdersRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class OrdersRepositoryTest {
    @Test
    void findByIdTest_expected() {
        Author author1 = new Author(10, "Veronica", "Roth", "19.08.1988", "New York");
        Category category = new Category(1, "Action");
        List<CartItem> books = new ArrayList<>();
        Books book1 = new Books(123, "Chosen One", 2020, author1, 50, category);
        Books book2 = new Books(234, "Divergent", 2011, author1, 45, category);
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(book1, 2, 2);
        CartItem cartItem2 = new CartItem(book1, 3, 3);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);

        Order expectedOrder = new Order(12345, "2023-10-29", 100, 1, "Pending", cartItems);
        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.save(expectedOrder);
        Order actualOrder = ordersRepository.findById(12345);

        assertEquals(expectedOrder, actualOrder, "Failed to find the order by Id");
    }

    @Test
    void findByIdTest_unexpected() {

        Author author1 = new Author(10, "Veronica", "Roth", "19.08.1988", "New York");
        Category category = new Category(1, "Action");
        List<CartItem> books = new ArrayList<>();
        Books book1 = new Books(123, "Chosen One", 2020, author1, 50, category);
        Books book2 = new Books(234, "Divergent", 2011, author1, 45, category);
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(book1, 2, 2);
        CartItem cartItem2 = new CartItem(book1, 3, 3);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);

        Order newOrder = new Order(12345, "2023-10-29", 100, 1, "Pending", cartItems);
        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.save(newOrder);
        Order actualOrder = ordersRepository.findById(12346);
        Order expected_output = null;
        assertEquals(expected_output, actualOrder, "Failed to find the order by Id");
    }


    @Test
    void findAllTest_expected() {
        Author author1 = new Author(10, "Veronica", "Roth", "19.08.1988", "New York");
        Category category = new Category(1, "Action");
        List<CartItem> books = new ArrayList<>();
        Books book1 = new Books(123, "Chosen One", 2020, author1, 50, category);
        Books book2 = new Books(234, "Divergent", 2011, author1, 45, category);
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(book1, 2, 2);
        CartItem cartItem2 = new CartItem(book1, 3, 3);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);

        Order order1 = new Order(1, "2023-11-01", 100, 1, "Processing", cartItems);
        Order order2 = new Order(2, "2023-11-02", 150, 2, "Shipped", cartItems);
        Order order3 = new Order(3, "2023-11-03", 200, 3, "Delivered", cartItems);

        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.save(order1);
        ordersRepository.save(order2);
        ordersRepository.save(order3);

        List<Order> foundOrders = ordersRepository.findAll();

        assertEquals(3, foundOrders.size());
        assertTrue(foundOrders.contains(order1));
        assertTrue(foundOrders.contains(order2));
        assertTrue(foundOrders.contains(order3));
    }

    @Test
    void findAllTest_unexpected() {

        OrdersRepository ordersRepository = new OrdersRepository();
        Order expected_output = null;
        List<Order> foundOrders = ordersRepository.findAll();

        assertEquals(expected_output, foundOrders, "Failed to find all");

    }


    @Test
    void saveTest_expected() {

        Author author1 = new Author(10, "Veronica", "Roth", "19.08.1988", "New York");
        Category category = new Category(1, "Action");
        List<CartItem> books = new ArrayList<>();
        Books book1 = new Books(123, "Chosen One", 2020, author1, 50, category);
        Books book2 = new Books(234, "Divergent", 2011, author1, 45, category);
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(book1, 2, 2);
        CartItem cartItem2 = new CartItem(book1, 3, 3);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);

        Order order = new Order(1, "2023-11-01", 100, 1, "Processing", cartItems);
        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.save(order);

        List<Order> foundOrders = ordersRepository.findAll();
        assertEquals(1, foundOrders.size());

        Order savedOrder = foundOrders.get(0);
        assertEquals(order.getOrder_id(), savedOrder.getOrder_id());
        assertEquals(order.getDate(), savedOrder.getDate());
        assertEquals(order.calculateTotalPrice(), savedOrder.calculateTotalPrice());
        assertEquals(order.getClient_id(), savedOrder.getClient_id());
        assertEquals(order.getStatus(), savedOrder.getStatus());
    }


    @Test
    void saveTest_unexpected() {

        Author author1 = new Author(10, "Veronica", "Roth", "19.08.1988", "New York");
        Category category = new Category(1, "Action");
        List<CartItem> books = new ArrayList<>();
        Books book1 = new Books(123, "Chosen One", 2020, author1, 50, category);
        Books book2 = new Books(234, "Divergent", 2011, author1, 45, category);
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(book1, 2, 2);
        CartItem cartItem2 = new CartItem(book1, 3, 3);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);

        Order order = new Order(1, "2023-11-01", 100, 1, "Processing", cartItems);
        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.save(order);

        boolean foundOrder = ordersRepository.save(order);
        boolean expected_output = false;
        assertEquals(expected_output, foundOrder, "Failed to save the Order");

    }


    @Test
    void updateTest_expected() {
        Author author1 = new Author(10, "Veronica", "Roth", "19.08.1988", "New York");
        Category category = new Category(1, "Action");
        List<CartItem> books = new ArrayList<>();
        Books book1 = new Books(123, "Chosen One", 2020, author1, 50, category);
        Books book2 = new Books(234, "Divergent", 2011, author1, 45, category);
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(book1, 2, 2);
        CartItem cartItem2 = new CartItem(book1, 3, 3);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);

        Order initialOrder = new Order(123, "2023-11-01", 100, 1, "Processing", cartItems);
        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.save(initialOrder);

        Order updatedOrder = new Order(123, "2023-11-05", 120, 1, "Shipped", cartItems);
        ordersRepository.update(updatedOrder);
        boolean expected_output = true;
        boolean result=ordersRepository.update(updatedOrder);


        assertEquals(result, expected_output, "Failed to update the order");
    }


    @Test
    void updateTest_unexpected() {
        Author author1 = new Author(10, "Veronica", "Roth", "19.08.1988", "New York");
        Category category = new Category(1, "Action");
        List<CartItem> books = new ArrayList<>();
        Books book1 = new Books(123, "Chosen One", 2020, author1, 50, category);
        Books book2 = new Books(234, "Divergent", 2011, author1, 45, category);
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(book1, 2, 2);
        CartItem cartItem2 = new CartItem(book1, 3, 3);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);

        Order initialOrder = new Order(123, "2023-11-01", 100, 1, "Processing", cartItems);
        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.save(initialOrder);

        Order updatedOrder = new Order(234, "2023-11-05", 120, 1, "Shipped", cartItems);
        ordersRepository.update(updatedOrder);

        boolean expected_output = false;
        boolean result = ordersRepository.update(updatedOrder);
        assertEquals(result, expected_output, "Failed to update the order");
    }


    @Test
    void deleteTest_expected() {

        Author author1 = new Author(10, "Veronica", "Roth", "19.08.1988", "New York");
        Category category = new Category(1, "Action");
        List<CartItem> books = new ArrayList<>();
        Books book1 = new Books(123, "Chosen One", 2020, author1, 50, category);
        Books book2 = new Books(234, "Divergent", 2011, author1, 45, category);
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(book1, 2, 2);
        CartItem cartItem2 = new CartItem(book1, 3, 3);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);

        Order orderToDelete = new Order(1, "2023-11-01", 100, 1, "Processing", cartItems);
        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.save(orderToDelete);
        ordersRepository.delete(1);
        Order foundOrder = ordersRepository.findById(1);
        Order expected_output = null;

        assertEquals(expected_output, foundOrder, " Failed to delete order");
    }

    @Test
    void deleteTest_unexpected() {
        Author author1 = new Author(10, "Veronica", "Roth", "19.08.1988", "New York");
        Category category = new Category(1, "Action");
        List<CartItem> books = new ArrayList<>();
        Books book1 = new Books(123, "Chosen One", 2020, author1, 50, category);
        Books book2 = new Books(234, "Divergent", 2011, author1, 45, category);
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem1 = new CartItem(book1, 2, 2);
        CartItem cartItem2 = new CartItem(book1, 3, 3);
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);

        Order orderToDelete = new Order(1, "2023-11-01", 100, 1, "Processing", cartItems);
        OrdersRepository ordersRepository = new OrdersRepository();
        ordersRepository.save(orderToDelete);
        //ordersRepository.delete(2);
        //Order foundOrder = ordersRepository.findById(1);
        boolean deletedOrder = ordersRepository.delete(2);
        boolean expected_output = false;
        assertEquals(expected_output, deletedOrder, "Failed to delete order");

    }
}
