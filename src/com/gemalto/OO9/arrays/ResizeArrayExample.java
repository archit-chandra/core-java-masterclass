package com.gemalto.OO9.arrays;

import java.util.Scanner;

public class ResizeArrayExample {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int[] baseData = new int[10];
    
    public static void main(String[] args) {
        System.out.println("Enter 10 integers: ");
        getInput();
        printArray(baseData);
        resizeArray();
        printArray(baseData); // last two added elements printed as 0
        
        // System.out.println("Enter 12 integers: ");
        // getInput();
        
        baseData[10] = 67;
        baseData[11] = 34;
        printArray(baseData);
    }
    
    private static void resizeArray() {
        int[] original = baseData;
        baseData = new int[12];
        for (int i = 0; i < original.length; i++) {
            baseData[i] = original[i];
        }
    }
    
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    private static void getInput() {
        for (int i = 0; i < baseData.length; i++) {
            baseData[i] = scanner.nextInt();
        }
    }
    
}
