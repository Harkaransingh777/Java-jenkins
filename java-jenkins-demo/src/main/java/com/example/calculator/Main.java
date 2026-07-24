package com.example.calculator;

/**
 * Entry point that demonstrates the Calculator in action.
 * Run with: java -jar target/java-jenkins-demo.jar
 */
public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("=== Java + Jenkins Demo App ===");
        System.out.println("5 + 3   = " + calculator.add(5, 3));
        System.out.println("5 - 3   = " + calculator.subtract(5, 3));
        System.out.println("5 * 3   = " + calculator.multiply(5, 3));
        System.out.println("6 / 3   = " + calculator.divide(6, 3));
        System.out.println("2 ^ 10  = " + calculator.power(2, 10));
        System.out.println("5!      = " + calculator.factorial(5));
        System.out.println("17 prime? " + calculator.isPrime(17));
        System.out.println("8 even?   " + calculator.isEven(8));
    }
}
