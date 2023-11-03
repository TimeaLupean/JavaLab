package org.example.controller;

import org.example.main.Author;
import org.example.repository.AuthorRepository;

import java.util.List;

public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void createAuthor(int id, String fname, String lname,String bdate, String address ){
        Author author = new Author(id, fname, lname, bdate, address);
        authorRepository.save(author);
        System.out.println("Author created");
    }

    public Author readAuthor(int author_id){
        Author author = authorRepository.findById(author_id);
        if (author != null){
            System.out.println("Author detalis: " + author.getFirstName() + "," + author.getLastName() + "," + author.getBirth_date() + "," + author.getAddress());
        } else{
            System.out.println("Author not found.");
        }
        return author;
    }

    public void updateAuthor(int id, String fname, String lname,String bdate, String address ){
        Author existingauthor = authorRepository.findById(id);
        if(existingauthor != null){
            existingauthor.setFirstName(fname);
            existingauthor.setLastName(lname);
            existingauthor.setBirth_date(bdate);
            existingauthor.setAddress(address);
            authorRepository.update(existingauthor);
            System.out.println("Author updated.");
        } else{
            System.out.println("Author not found.");
        }
    }

    public void deleteAuthor(int authorid) {
        Author author = authorRepository.findById(authorid);
        if (author != null) {
            authorRepository.delete(authorid);
            System.out.println("Author deleted: " + author.getFirstName() + " " + author.getLastName());
        } else {
            System.out.println("Author not found.");
        }
    }

    public void listAuthors(){
        List<Author> authors = authorRepository.findAll();
        if(!authors.isEmpty()){
            System.out.println("List of authors: ");
            for (Author author :authors){
                System.out.println("Author details: " +author.getAuthor_id() + " " + author.getFirstName() + "," + author.getLastName() + "," + author.getBirth_date() + "," + author.getAddress());
            }
        } else{
            System.out.println("No authors found.");
        }
    }
}