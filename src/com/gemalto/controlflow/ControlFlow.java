package com.gemalto.controlflow;

public class ControlFlow {
    
    public static void main(String[] args) {
        
        // if, else, else if
        
        // switch case
        // break are necessary to run each case only or will continue to run below cases
        // too
        // works with byte, int, char, short & strings(from JDK7)
        
        int value = 4;
        switch (value) {
            case 1:
                System.out.println("Value = 1");
                break;
            case 2:
                System.out.println("Value = 2");
                break;
            
            // valid statement for multiple cases
            case 3:
            case 4:
            case 5:
                System.out.println("Value could be multiple cases");
                System.out.println("Value = " + value);
                break;
            default:
                System.out.println("Value = neither 1 nor 2");
        }
        
        // for
        // foreach variant also available
        
        for (int i = 0; i < 5; i++) {
            System.out.println("This is :" + i);
        }
        
        // while
        
        int i = 10;
        while (i < 15) {
            System.out.println("This is :" + i); // 10,11,12,13,14
            i++;
        }
        
        // doWhile
        
        int check = 15;
        do {
            System.out.println("This is :" + check); // 15, runs atleast once without checking the condition
            i++;
        } while (i < check);
        
    }
    
}