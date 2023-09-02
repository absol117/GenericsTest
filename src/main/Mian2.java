package main;

import java.util.ArrayList;
import java.util.List;

public class Mian2 {
    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();
        list.add("aa");
        list.add(22);
        list.add('a');

        list.forEach(System.out::println);
    }
}
