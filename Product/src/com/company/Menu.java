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

    public void printList() {
       for (Product i: productRepository.dataBase())
           System.out.println(i);
    }

    public void menu() {
        System.out.println("Выберите позицию:\n1. Добавить продукт в список\n2. Найти продукт по id\n3. Удалить продукт по id\n4. Показать список продуктов\n5. Выход");
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
                printList();
                menu();
                break;
            case 5:
                break;
            default:
                System.out.println("вы ввели неверное значение");
                menu();
        }
    }
}
