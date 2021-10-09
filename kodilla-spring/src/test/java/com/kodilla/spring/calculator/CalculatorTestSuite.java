package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {
    @Test
    void testCalculations(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double a = 10;
        double b = 2;

        //When
        double add = calculator.add(a, b);
        double sub = calculator.sub(a,b);
        double mul = calculator.mul(a,b);
        double div = calculator.div(a,b);

        //Then
        assertEquals(add, 12);
        assertEquals(sub, 8);
        assertEquals(mul, 20);
        assertEquals(div, 5);

    }

}
