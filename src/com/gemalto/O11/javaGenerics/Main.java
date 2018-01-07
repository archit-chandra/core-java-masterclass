package com.gemalto.O11.javaGenerics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        // items.add("Archit"); // throws error now because of the use of generics
        items.add(2);
        items.add(3); // autoboxing of int -> Integer
        items.add(4);
        items.add(5);

        printDoubled(items);
    }

    private static void printDoubled(ArrayList<Integer> items) {
        for (Integer object : items) {
            System.out.println(object * 2);
        }
    }

}
