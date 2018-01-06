package com.gemalto.OO9.autoboxingUnboxing;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        
        // Works fine
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        
        // ERROR: type argument can't be primitive type in ArrayList
        // because primitive is not a class & ArrayList needs a class reference for type
        // argument
        // ArrayList<int> intList = new ArrayList<>();
    }
    
}
