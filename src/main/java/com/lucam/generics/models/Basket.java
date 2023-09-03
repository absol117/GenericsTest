package com.lucam.generics.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Basket<T extends Fruit> {
    public static final float MAX_WEIGHT = 5f;
    private final List<T> content;

    public void add(T fruit) {
        if (fruit == null)
            throw new IllegalArgumentException("Fruit cannot be null");

        if (fruit.getWeight() <= 0)
            throw new IllegalArgumentException("Fruit weight must be greater than 0");

        if (getCurrentWeight() + fruit.getWeight() < MAX_WEIGHT)
            content.add(fruit);
        else throw new IllegalStateException("Basket max weight exceeded");
    }

    public void addAll(Collection<T> fruits) {
        fruits.forEach(this::add);
    }

    @SafeVarargs
    public final void addAll(T... fruits) {
        Arrays.stream(fruits).forEach(this::add);
    }

    public void remove(T fruit) {
        content.remove(fruit);
    }

    public void clear() {
        content.clear();
    }

    public double getCurrentWeight() {
        return content.stream()
                .mapToDouble(Fruit::getWeight)
                .sum();
    }

}
