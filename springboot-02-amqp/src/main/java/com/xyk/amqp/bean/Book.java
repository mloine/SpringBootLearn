package com.xyk.amqp.bean;

public class Book {

    private String username;
    private String author;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String username, String author) {
        this.username = username;
        this.author = author;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "username='" + username + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
