package org.example.main;

public class Clients extends  Person{
    private int client_id;

    private String email;

    public Clients(int client_id, String firstName, String lastName, String birth_date, String addresses, String email) {
        super(firstName ,lastName,birth_date,addresses);
        this.client_id = client_id;
        this.email = email;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
