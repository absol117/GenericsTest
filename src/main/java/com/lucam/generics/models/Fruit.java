package com.lucam.generics.models;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class Fruit {
    protected float weight;

}
