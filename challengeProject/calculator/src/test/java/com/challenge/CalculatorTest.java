package com.challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private CalculatorService calculatorService;

    @Before
    public void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void testAddition() {
        String result = calculatorService.calculate("addition,1.23,4.56,2");
        assertEquals("5,79", result);
        result = calculatorService.calculate("addition,1,-4,2");
        assertEquals("-3", result);
    }

    @Test
    public void testSubtraction() {
        String result = calculatorService.calculate("subtraction,1.23,4.56,2");
        assertEquals("-3,33", result);
        result = calculatorService.calculate("subtraction,1,-4,2");
        assertEquals("5", result);
    }

    @Test
    public void testMultiplication() {
        String result = calculatorService.calculate("multiplication,1.23,4.56,2");
        assertEquals("5,61", result);
        result = calculatorService.calculate("multiplication,1,-4,2");
        assertEquals("-4", result);
        result = calculatorService.calculate("multiplication,0,-4,2");
        assertEquals("0", result);
    }

    @Test
    public void testDivision() {
        String result = calculatorService.calculate("division,1.23,4.56,2");
        assertEquals("0,27", result);
        result = calculatorService.calculate("division,1,-4,2");
        assertEquals("-0,25", result);
        result = calculatorService.calculate("division,1,0,2");
        assertEquals("Cannot divide by zero", result);
        result = calculatorService.calculate("division,0,-4,2");
        assertEquals("0", result);
    }

    @Test
    public void testRounding() {
        String result = calculatorService.calculate("division,1,3,2");
        assertEquals("0,33", result);
        result = calculatorService.calculate("addition,1.55555555,1.11111111,2");
        assertEquals("2,67", result);
        result = calculatorService.calculate("addition,1.55555555,1.11111111,0");
        assertEquals("3", result);
        result = calculatorService.calculate("addition,1,1,-1");
        assertEquals("Precision can't be bellow 0", result);
    }

    @Test
    public void testValidation() {
        String result = calculatorService.calculate("sqrt,1,3,2");
        assertEquals("Invalid operation", result);
        result = calculatorService.calculate("addition,a,3,2");
        assertEquals("Invalid input", result);
        result = calculatorService.calculate("addition,1,b,2");
        assertEquals("Invalid input", result);
        result = calculatorService.calculate("addition,1,3,c");
        assertEquals("Invalid input", result);
    }
}
