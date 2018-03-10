package com.gemalto.O17.lambda_expressions;

public class LambdaMain1 {
    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();
    }
}

class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}
