package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Calculator tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Adds two numbers")
    void testAdd() {
        assertEquals(8.0, calculator.add(5, 3));
    }

    @Test
    @DisplayName("Subtracts two numbers")
    void testSubtract() {
        assertEquals(2.0, calculator.subtract(5, 3));
    }

    @Test
    @DisplayName("Multiplies two numbers")
    void testMultiply() {
        assertEquals(15.0, calculator.multiply(5, 3));
    }

    @Test
    @DisplayName("Divides two numbers")
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));
    }

    @Test
    @DisplayName("Throws when dividing by zero")
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(5, 0)
        );
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    @DisplayName("Raises a number to a power")
    void testPower() {
        assertEquals(1024.0, calculator.power(2, 10));
    }

    @Test
    @DisplayName("Computes factorial correctly")
    void testFactorial() {
        assertEquals(120L, calculator.factorial(5));
        assertEquals(1L, calculator.factorial(0));
    }

    @Test
    @DisplayName("Throws for factorial of a negative number")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }

    @Test
    @DisplayName("Detects prime numbers correctly")
    void testIsPrime() {
        assertTrue(calculator.isPrime(17));
        assertFalse(calculator.isPrime(15));
        assertFalse(calculator.isPrime(1));
    }

    @Test
    @DisplayName("Detects even numbers correctly")
    void testIsEven() {
        assertTrue(calculator.isEven(8));
        assertFalse(calculator.isEven(7));
    }
}
