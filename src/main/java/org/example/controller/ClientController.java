package org.example.controller;

import org.example.main.Clients;
import org.example.repository.ClientsRepository;

import java.util.Scanner;

public class ClientController {
    private ClientsRepository clientsRepository;
    private Scanner scanner = new Scanner(System.in);
    private Clients currentClient;

    public ClientController(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public void register() {
        System.out.print("Enter a user ID: ");
        int user_id = scanner.nextInt();
        scanner.nextLine();

        if (clientsRepository.findById(user_id) != null) {
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

        Clients newClient = new Clients(user_id, fname, lname, birthdate, address, email);
        clientsRepository.save(newClient);

        System.out.println("Registration successful. You can now log in.");
        System.out.println("Number of clients in the repository: " + clientsRepository.findAll().size());
    }

    public void login() {
        System.out.print("Enter your client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        Clients client = clientsRepository.findById(clientId);

        if (client != null && client.getEmail().equals(email)) {
            currentClient = client;
            System.out.println("Login successful. Welcome, Client ID " + currentClient.getClient_id() + "!");
        } else {
            System.out.println("Invalid client ID or email. Please try again.");
        }
    }
}