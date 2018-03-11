package com.gemalto.O17.lambda_expressions.functional_interfaces_lambda_usage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee archit = new Employee("Archit Chandra", 34);
        Employee ankush = new Employee("Ankush Chandra", 29);
        Employee simran = new Employee("Simran Narula", 29);
        Employee snow = new Employee("Snow White", 30);
        List<Employee> employees = new ArrayList<>();
        employees.add(archit);
        employees.add(ankush);
        employees.add(simran);
        employees.add(snow);

        System.out.println("--------------Using Iterator's forEach with Lambdas----------------------");
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        System.out.println("--------------Using enhanced for loop without Lambdas for Age condition----------------------");
        System.out.println("-----Employess in 30s--------------");
        for (Employee employee : employees) {
            if (employee.getAge() >= 30) {
                System.out.println(employee.getName());
            }
        }

        System.out.println("--------------Using Lambdas for Age condition----------------------");
        System.out.println("-----Employess in 30s--------------");
        employees.forEach(employee -> {
            if (employee.getAge() >= 30) {
                System.out.println(employee.getName());
            }
        });

        System.out.println("-----Employess in 20s--------------");
        employees.forEach(employee -> {
            if (employee.getAge() < 30) {
                System.out.println(employee.getName());
            }
        });

        System.out.println("--------------Using Lambdas with Predicate for Age condition----------------------");
        printEmployeesByAge(employees, "-----Employess in 30s----", employee -> employee.getAge() >= 30);
        printEmployeesByAge(employees, "\n-----Employess in 20s----", employee -> employee.getAge() < 30);
        // using Predicate by anonymous class instead of Lambdas
        printEmployeesByAge(employees, "\n-----Employess above 30----", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 30;
            }
        });

        // Non-generic Predicate (Types are pre-defined)
        IntPredicate greaterThan15Predicate = i -> i > 15;
        IntPredicate lessThan100Predicate = i -> i < 100;
        System.out.println("greaterThan15Predicate.test : " + greaterThan15Predicate.test(10));
        int a = 20;
        System.out.println("greaterThan15Predicate.test : " + greaterThan15Predicate.test(a + 5));
        // chaining of Predicate
        System.out.println("Predicate chaining : " + greaterThan15Predicate.and(lessThan100Predicate).test(50));

        // Supplier Interface
        System.out.println("--------------Supplier Interface Example----------------------");
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

        // Obtaining first & last name of the employees
        System.out.println("-------------Printing employess first & last name-------------------------------");
//        employees.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
//            System.out.println("Last Name is : " + lastName);
//        });

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' ') + 1);
        };

        String firstName = getFirstName.apply(employees.get(1));
        System.out.println(firstName);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        System.out.println("------------Printing Random employee now---------------------");
        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("===========================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
