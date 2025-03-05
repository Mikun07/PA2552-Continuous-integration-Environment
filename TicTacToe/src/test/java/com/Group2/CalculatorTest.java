package com.Group2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 shall equals 5");
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 shall equals 1");
    }

    @Test
    void testMultiplication() {
        assertEquals(25, calculator.multiply(5, 5), "5 * 5 shall equals 25");
    }

    @Test
    void testDivision() {
        assertEquals(2.0, calculator.divide(5, 2), "5 / 2 shall equals 2.0");
    }
}
