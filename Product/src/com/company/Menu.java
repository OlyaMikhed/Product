package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Product> list=new ArrayList<>();

    public Menu(List<Product> list) {
        this.list = list;
    }
    Scanner sc = new Scanner(System.in);
    public Menu(){
    }

    private int count=114;
    public void additionProduct() {
        System.out.println("Введите имя, цену и категорию товара");
        Product product = new Product(count++, sc.next(), sc.nextDouble(), sc.next());
        list.add(product);
    }

    public void findProduct() {
        System.out.println("Введите id продукта");
        int x = sc.nextInt();
        boolean y=true;
        for (int i = 0; i < list.size(); i++) {
            if (x == list.get(i).getId()) {
                y=false;
                System.out.println(list.get(i));
            }
        }
        if (y){System.out.println("Продукта с таким id нет в наличии");}
    }

    public void deleteProduct() {
        System.out.println("Введите id продукта");
        int x = sc.nextInt();
        boolean y=true;
        for (int i = 0; i < list.size(); i++) {
            if (x == list.get(i).getId()) {
                y=false;
                list.remove(i);
                System.out.println("Продукт удален");
            }
        }
        if (y){System.out.println("Продукта с таким id нет в наличии");}
    }

    public void printList() {
       for (int i = 0; i < list.size(); i++)
           System.out.println(list.get(i));
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
