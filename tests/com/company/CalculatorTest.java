package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;
    private int result;



    @Test
    public void testOneNumber() throws Exception {
        result = new Calculator("2").getResult();
        assertEquals(2, result);
    }

    @Test
    public void testWithTwoNumbersAndPlusOperator() throws Exception {
        calculator = new Calculator("3 4 +");
        result = calculator.getResult();
        assertEquals(7, result);
    }

    @Test
    public void testWithTwoNumbersAndMultiplicationOperator() throws Exception {
        calculator = new Calculator("2 5 *");
        result = calculator.getResult();
        assertEquals(10, result);
    }

    @Test
    public void testWithTwoNumbersAndMinusOperator() throws Exception {
        calculator = new Calculator("3 4 -");
        result = calculator.getResult();
        assertEquals(-1, result);    }

    @Test
    public void testWithTwoNumbersAndDivideOperator() throws Exception {
        calculator = new Calculator("5 5 /");
        result = calculator.getResult();
        assertEquals(1, result);
    }

    @Test
    public void testWithAllOperatorsAtTheEnd() throws Exception {
        calculator = new Calculator("12 4 1 - /");
        result = calculator.getResult();
        assertEquals(4, result);
    }

    @Test
    public void testWithTwoOperators() throws Exception {
        calculator = new Calculator("12 4 / 1 -");
        result = calculator.getResult();
        assertEquals(2, result);
    }

    @Test
    public void testComplexCalculation() throws Exception {
        calculator = new Calculator("15 7 1 1 + - / 3 * 2 1 1 + + -");
        result = calculator.getResult();
        assertEquals(5, result);
    }
}