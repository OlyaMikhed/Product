package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    static int count=111;
    public void additionProduct() {
        System.out.println("Введите имя");
        String name=sc.next();
        System.out.println("Введите цену");
        double price=sc.nextDouble();
        System.out.println("Введите категорию товара");
        String category=sc.next();
        Product product = new Product(count++, name, price, category);
        productRepository.dataBase().add(product);
    }

    public void findProduct() {
        System.out.println("Введите id продукта");
        int x = sc.nextInt();
        boolean y=true;
        for (Product i: productRepository.dataBase()) {
            if (x == i.getId()) {
                System.out.println(i);
                y = false;
            }
        }
        if (y)
            System.out.println("Продукта с таким id нет в наличии");
    }

    public void deleteProduct() {
        System.out.println("Введите id продукта");
        int x = sc.nextInt();
        boolean y=true;
        for (Product i: productRepository.dataBase()) {
            if (x == i.getId()) {
                y=false;
                productRepository.dataBase().remove(i);
                System.out.println("Продукт удален");
                break;
            }
        }
        if (y){System.out.println("Продукта с таким id нет в наличии");}
    }

    public void printList(ArrayList<Product> list) {
       for (Product i: list)
           System.out.println(i);
    }

    ArrayList<Product> productsOneCategory=new ArrayList<>();
    String changeCategory;
    boolean categoryAvailability;

    public void check(){
        System.out.println("Введите категорию товара");
        changeCategory=sc.next();
        categoryAvailability=false;
        for (Product i: productRepository.dataBase()){
            if(changeCategory.equals(i.getCategory())) {
                categoryAvailability=true;
            }
        }
        if(categoryAvailability==false)
            System.out.println("Нет товаров такой категории");
    }

    public void listByCategory(){
        productsOneCategory.clear();
        check();
        if(categoryAvailability) {
            for (Product i : productRepository.dataBase()) {
                if (changeCategory.equals(i.getCategory())) {
                    productsOneCategory.add(i);
                }
            }
        }
    }
    public void addDiscount(){
        check();
        if(categoryAvailability) {
            System.out.println("Введите скидку");
            double discount = sc.nextDouble();
            for (Product i : productRepository.dataBase()) {
                if (changeCategory.equals(i.getCategory())) {
                    i.setDiscount(discount);
                }
            }
        }
    }

    public void menu() {
        System.out.println("Выберите позицию:" +
                "\n1. Добавить продукт в список" +
                "\n2. Найти продукт по id" +
                "\n3. Удалить продукт по id" +
                "\n4. Показать список продуктов" +
                "\n5. Показать товары одной категории"+
                "\n6. Присвоить скидку группе товаров"+
                "\n7. Выход");
        int change = sc.nextInt();
        switch (change) {
            case 1:
                additionProduct();
                menu();
                break;
            case 2:
                findProduct();
                menu();
                break;
            case 3:
                deleteProduct();
                menu();
                break;
            case 4:
                printList(productRepository.dataBase());
                menu();
                break;
            case 5:
                listByCategory();
                printList(productsOneCategory);
                menu();
                break;
            case 6:
                addDiscount();
                menu();
                break;
            case 7:
                break;
            default:
                System.out.println("вы ввели неверное значение");
                menu();
        }
    }
}
