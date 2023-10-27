package org.example.model;

import java.util.List;

public class Author {
    private int author_id;
    private String firstName;
    private String lastName;
    private String birth_date;
    private List<String> addresses;

    public Author(int author_id, String firstName, String lastName, String birth_date, List<String> addresses) {
        this.author_id = author_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth_date = birth_date;
        this.addresses = addresses;
    }

}
