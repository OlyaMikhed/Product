package com.company;

import java.util.Comparator;

public class Product {
    private int id;
    private String name;
    private double price;
    private String category;
    private double discount;

    Product(int id, String name, double price, String category){
        this.id=id;
        this.name=name;
        this.price=price;
        this.category=category;
    }

    public Product() {
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public String getCategory (){return category;}
    public double getDiscount() { return discount;}

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category;}
    public void setDiscount(double discount) {this.discount=discount;}


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", discount=" + discount +
                '}';
    }
}
