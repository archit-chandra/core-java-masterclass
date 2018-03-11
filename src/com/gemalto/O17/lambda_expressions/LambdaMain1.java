package com.gemalto.O17.lambda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaMain1 {
    public static void main(String[] args) {
        // original code
//        new Thread(new CodeToRun()).start();

        // same thing as above but using anonymous class
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable");
//            }
//        }).start();

        // same code using lambda expressions
        new Thread(() -> System.out.println("Printing from the Runnable Using Lambda: Single Line")).start();

        System.out.println("----------Multiple line codes with Lambda------------");
        new Thread(() -> {
            System.out.println("Printing from the Runnable: Multiple Line");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);
        }).start();

        System.out.println("----------Dealing with Employees------------");
        Employee archit = new Employee("Archit Chandra", 34);
        Employee ankush = new Employee("Ankush Chandra", 29);
        Employee simran = new Employee("Simran Narula", 29);
        Employee snow = new Employee("Snow White", 30);
        List<Employee> employees = new ArrayList<>();
        employees.add(archit);
        employees.add(ankush);
        employees.add(simran);
        employees.add(snow);

        // Arranging them by sort via name in ascending order

        // Sorting without Lambdas
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        // Sorting with Lambda expression
//        Collections.sort(employees, (Employee employee1, Employee employee2) ->
//                employee1.getName().compareTo(employee2.getName()));

        // Further improvement with Lambda expression : can ignore the type
        // so above code can still be reduced as:
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

//class CodeToRun implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println("Printing from the Runnable");
//    }
//}
