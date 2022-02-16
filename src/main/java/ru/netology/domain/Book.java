package ru.netology.domain;

public class Book extends Product {
    private int pages;
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String name, int price, int pages, String author) {
        super(id, name, price);
        this.pages = pages;
        this.author = author;
    }
}
