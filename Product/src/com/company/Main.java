package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Product> l=new ArrayList<>();
        l.add(new Product(111, "пирожное", 150.2, "еда"));
        l.add(new Product(112, "конфета", 180.5, "еда"));
        l.add(new Product(113, "торт", 63.2, "еда"));

        Menu list=new Menu();
        list.menu();
    }
}
