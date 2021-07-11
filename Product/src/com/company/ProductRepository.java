package com.company;

import java.util.ArrayList;

public class ProductRepository {
    static ArrayList<Product> list=new ArrayList<>();

    public  static ArrayList<Product> dataBase(){
        return list;
    }
    static {
        list.add(new Product(Menu.count++, "огурцы", 2.4, "овощи"));
        list.add(new Product(Menu.count++, "яблоко", 2.3, "фрукты"));
        list.add(new Product(Menu.count++, "клубника", 4.5, "ягоды"));
    }
}
