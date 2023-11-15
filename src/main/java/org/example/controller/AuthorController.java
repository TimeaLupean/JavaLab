package org.example.controller;

import org.example.main.Author;
import org.example.main.CartItem;

import org.example.repository.AuthorRepository;


import java.util.ArrayList;
import java.util.List;

public class AuthorController {
    private AuthorRepository authorRepository;
    
    List<CartItem> cartItems = new ArrayList<>();

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void createAauthor(int authorId, String firstName, String lastName, String birthDate,String address) {
        Author author = new Author(authorId, firstName, lastName, birthDate, address);
        authorRepository.save(author);
    }


    public Author findAuthorById(int authorId) {
        return authorRepository.findById(authorId);
    }

    public List<Author> viewAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorByName(String firstname, String lastname){return authorRepository.findbyName(firstname,lastname);}

    public void updateAuthor(int authorId, String firstName, String lastName, String birthDate,String address) {
        Author updatedAuthor = new Author(authorId, firstName, lastName, birthDate, address);
        authorRepository.update(updatedAuthor);
    }

    public void deleteAuthor(int authorId) {
        authorRepository.delete(authorId);
    }
}