package com.gemalto.O13;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("java", "===========java description=================");
        languages.put("python", "===========python description=================");
        languages.put("algol", "===========algol description=================");
        languages.put("basic", "===========basic description=================");
        languages.put("lisp", "===========lisp description=================");

        System.out.println(languages.get("java"));

        // to ensure that the value is not overwritten in the map
        if (languages.containsKey("java")) {
            System.out.println("java is already in the map");
        } else {
            languages.put("java", "====================java new description=================");
            System.out.println("java added successfully in the map");
        }

        // to return all the values in the map
        // unordered
        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

        // method 1: to remove value from map - matches just keys
        languages.remove("lisp");
        System.out.println("lisp removed");

        // method 2: to remove value from map - mathes both keys & values
        if (languages.remove("algol", "===========algol description==========")) {
            System.out.println("algol removed");
        } else {
            System.out.println("algol not removed, key/value pair not found");
        }

        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

        System.out.println("----------------------------------------------------------------------------------");
        // added again because it was removed earlier
        languages.put("lisp", "lisp description");
        // this will replace the value in the map but will show the earlier value
        System.out.println(languages.replace("lisp", "lisp new description"));

        // this will show the replaced value
        System.out.println("lisp value : " + languages.get("lisp"));

        // below is the safer method
        // ensures that new value is updated only if old value exists
        if (languages.replace("lisp", "this will not work", "list most updated description")) {
            System.out.println("lisp replace");
        } else {
            System.out.println("lisp was not replaced");
        }

        // this will show 'null' because no value for 'scala' in the map
        System.out.println(languages.replace("scala", "this will not be addded"));

        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }


    }
}
