package org.example.main;
import java.util.List;

public class Author extends Person {

    public Author(int author_id, String firstName, String lastName, String birth_date, String address) {
        super(author_id,firstName,lastName,birth_date,address);

    }
    public int getAuthor_id() {
        return super.getId();
    }

}
