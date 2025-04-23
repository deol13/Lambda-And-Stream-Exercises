package se.lexicon.FunctionalInterfacePractice;

import java.util.ArrayList;
import java.util.List;

public class Practice {

    public static void filterProducts(List<Product> products, Conditional filter, Action action) {
        products.stream()
                .filter(filter::test)
                .forEach(action::execute);
    }

    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("War Hammer", 200, 11));
        productList.add(new Product("Mace", 130, 5));
        productList.add(new Product("Sword", 250, 6));
        productList.add(new Product("Bow", 145, 0));
        productList.add(new Product("Crossbow", 300, 9));
        productList.add(new Product("Shield", 90, 6));
        productList.add(new Product("Axe", 180, 0));

        // Task 1: Print out all Products that have stock value of 0
        Conditional con1 = p -> p.getStock() == 0;
        Action action1 = System.out::println;

        System.out.println("Task 1:");
        filterProducts(productList, con1, action1);

        // Task 2: Print out the productName of all the Products that start with B
        Conditional con2 = p -> p.getProductName().startsWith("B");
        Action action2 = p -> System.out.println(p.getProductName());

        System.out.println("Task 2:");
        filterProducts(productList, con2, action2);

        // Task 3: Print out all Products that have price above 100 and lower than 150
        Conditional con3 = p -> p.getPrice() > 100 && p.getPrice() < 150;
        //Action action3 = System.out::println;

        System.out.println("Task 3:");
        filterProducts(productList, con3, action1);

        // Task 4: Increase the price of all Products that have a stock value of less than 10 and above 0 by 50%
        Conditional con4 = p -> p.getStock() > 0 && p.getStock() < 10;
        Action action4 = p -> p.setPrice(p.getPrice()*1.5);

        System.out.println("Task 4:");
        filterProducts(productList, con4, action4);
        System.out.println(productList);
    }
}
