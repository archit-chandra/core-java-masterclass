package com.gemalto.OO9.arrayList;

import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
            }
        }
    }
    
    private static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    
    private static void searchForItem() {
        System.out.print("Item to search for: ");
        
        // scanner.nextInt(); => returns int, scanner.nextLine() =>returns string
        String searchItem = scanner.nextLine();
        
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the shopping list");
        }
    }
    
    private static void removeItem() {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        groceryList.removeGroceryItem(itemName);
        System.out.println(itemName + " has been removed from the grocery list");
    }
    
    private static void modifyItem() {
        System.out.print("Current item name: ");
        String currentItemName = scanner.nextLine();
        System.out.print("Enter new item name: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(currentItemName, newItem);
    }
    
    private static void printInstructions() {
        System.out.println("\n Press");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print list of grocery items.");
        System.out.println("\t 2 - To add the item to the list.");
        System.out.println("\t 3 - To modify the item in the list.");
        System.out.println("\t 4 - To remove the item from the list.");
        System.out.println("\t 5 - To search for the item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }
    
}
