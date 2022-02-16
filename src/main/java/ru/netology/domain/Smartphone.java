package ru.netology.domain;

public class Smartphone extends Product {
    private String color;
    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String color, String manufacturer) {
        super(id, name, price);
        this.color = color;
        this.manufacturer = manufacturer;
    }
}
