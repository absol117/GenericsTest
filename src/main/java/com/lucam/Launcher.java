package com.lucam;

import com.lucam.generics.models.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Launcher {
    public static void main(String[] args) {
        Basket<Fruit> basket = new Basket<>(new ArrayList<>());

        Fruit orange = Orange.builder()
                .weight(0.75f)
                .build();

        Fruit apple = Apple.builder()
                .weight(0.5f)
                .build();

        Fruit banana = Banana.builder()
                .weight(0.55f)
                .build();

        basket.addAll(orange, apple, banana);

        System.out.println("Basket weight (Before): " + basket.getCurrentWeight());

        try {
            for (int i = 0; i < 100; i++) {
                basket.add(Apple.builder().weight(0.6f).build());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("-".repeat(40));
            System.out.println("Basket weight (after): " + basket.getCurrentWeight());
            System.out.printf("Content [%d]:\n\n", basket.getContent().size());
            basket.getContent()
                    .stream()
                    .sorted(Comparator.comparing(Fruit::getWeight).reversed())
                    .map(f -> "Fruit: " + f.getClass().getSimpleName() + " - Weight: " + f.getWeight())
                    .forEach(System.out::println);
        }

    }
}
