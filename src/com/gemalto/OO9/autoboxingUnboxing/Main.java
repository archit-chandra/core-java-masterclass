package com.gemalto.OO9.autoboxingUnboxing;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        
        // Works fine
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        // This is Autoboxing:
        // we do not write : arrayList.add(new String("hello"));
        
        // ERROR: type argument can't be primitive type in ArrayList
        // because primitive is not a class & ArrayList needs a class reference for type
        // argument
        // ArrayList<int> intList = new ArrayList<>();
        
        // Customized class => wrapper
        ArrayList<IntClass> intList = new ArrayList<>();
        intList.add(new IntClass(55));
        
        // Autoboxing provides wrapper class for primitive types like above customized
        // class
        Integer integer = new Integer(55);
        
        Integer integerNew = 55; // => Integer.valueOf(55); autoboxing at compile time
        int myInt = integerNew; // => integerNew.intValue(); unboxing at compile time
        
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(50);
        for (int i = 0; i <= 10; i++) {
            // integerList.add(i); // same result =?
            integerList.add(Integer.valueOf(i)); // autoboxing
        }
        printArrayList(integerList);
    }
    
    private static void printArrayList(ArrayList<Integer> array) {
        
        for (int i = 0; i <= 11; i++) {
            // System.out.println("i = " + array.get(i)); // same result
            System.out.println("i = " + array.get(i).intValue()); // unboxing
        }
        
    }
    
    // same goes for other primitive types
    
}
