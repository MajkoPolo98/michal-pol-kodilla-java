package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {

        /* 7.1 - Teoria
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
         */
        PoemBeautifier textToEdit = new PoemBeautifier();
        textToEdit.beautify("Tekst1", "", "",
                (text, prefix, suffix) -> prefix + text.toUpperCase() + suffix);
        textToEdit.beautify("Tekst2", "ABC", "ABC",
                (text, prefix, suffix) -> prefix + text + suffix);
        textToEdit.beautify("Tekst3", "oOoOo", "oOoOo",
                (text, prefix, suffix) -> prefix + text.toUpperCase() + suffix);

    }
}