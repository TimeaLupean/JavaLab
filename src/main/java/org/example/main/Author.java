package org.example.main;
import java.util.List;

public class Author extends Person {
    private int author_id;


    public Author(int author_id, String firstName, String lastName, String birth_date, String address) {
        super(firstName,lastName,birth_date,address);
        this.author_id = author_id;

    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }


}
