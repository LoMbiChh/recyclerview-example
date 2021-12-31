package com.example.recyclerview_example;

public class Contact {
    private String name;
    private String mail;
    private String imageUrl;

    public Contact(String name, String mail, String imageUrl) {
        this.name = name;
        this.mail = mail;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
