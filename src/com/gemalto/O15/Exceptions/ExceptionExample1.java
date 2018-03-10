package com.gemalto.O15.Exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Shows the following exception handling
 * InputMismatchException - When character is typed instead of digits
 * NoSuchElementException - When no element is present (Ctrl + D)
 * AirthmeticException    - When divide by 0
 */
public class ExceptionExample1 {

    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);
    }

    private static int divide() {
        int x;
        try {
            x = getInt();
        } catch (NoSuchElementException e) { // catching NoSuchElementException here
            x = getInt(); // this catch again throws an exception => WRONG WAY
        }
        int y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) { // still not catching NoSuchElementException
                // Go round again inside the loop. Read past the end of the line & input first
                scanner.nextLine();
                System.out.println("Please enter the number using only digits 0 - 9");
            }
        }
    }
}
