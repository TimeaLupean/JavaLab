package org.example.controller;

import org.example.main.Books;
import org.example.main.Category;
import org.example.main.Author;

import org.example.repository.BooksRepository;


import java.util.List;

public class BookController {
    private BooksRepository bookRepository;



    public BookController(BooksRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(int book_id, String title, int publishing_year, Author author, int price, Category category) {
        Books book = new Books(book_id, title, publishing_year, author, price, category);
        bookRepository.save(book);
    }

    public Books findBookById(int bookID) {
        return bookRepository.findById(bookID);
    }

    public List<Books> viewAllBooks() {
        return bookRepository.findAll();
    }

    public void updateBook(int book_id, String title, int publishing_year, Author author, int price, Category category) {
        Books updatedbook = new Books(book_id, title, publishing_year, author, price, category);
        bookRepository.update(updatedbook);
    }

    public void deleteBook(int bookId) {
        bookRepository.delete(bookId);
    }

}