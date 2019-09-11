package com.example.abhishekkumar.ims;

public class Product {

    private int id;
    private String heading,description,sign,date;

    public Product(int id, String heading, String description, String sign, String date) {
        this.id = id;
        this.heading = heading;
        this.description = description;
        this.sign = sign;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public String getSign() {
        return sign;
    }

    public String getDate() {
        return date;
    }
}
