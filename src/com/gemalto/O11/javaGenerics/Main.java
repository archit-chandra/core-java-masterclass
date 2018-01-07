package com.gemalto.O11.javaGenerics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList items = new ArrayList();
        items.add(1);
        items.add("Archit"); // absurd input, will cause error
        items.add(2);
        items.add(3); // autoboxing of int -> Integer
        items.add(4);
        items.add(5);

        printDoubled(items);
    }

    private static void printDoubled(ArrayList items) {
        for (Object object : items) {
            System.out.println((Integer) object * 2); // can't use * operatoe on Object
        }
    }

}
