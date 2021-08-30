package com.kodilla.exception.test;

public class FirstChallenge {

    public void divide(int a, int b) {
        try {
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            System.out.println("Nie dziel przez 0. Błąd: " + e);
        }
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        firstChallenge.divide(3, 0);
    }
}