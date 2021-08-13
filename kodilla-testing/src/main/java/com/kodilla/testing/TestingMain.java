package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        Calculator paraLiczb = new Calculator(12, 9);
        int add = paraLiczb.add();
        int sub = paraLiczb.subtract();

        System.out.println("Test jednostkowy - dodawanie:");
        if(add == (paraLiczb.getA()+ paraLiczb.getB())){
            System.out.println("Test OK");
        }
        System.out.println("Test jednostkowy - odejmowanie:");
        if(sub == (paraLiczb.getA()- paraLiczb.getB())){
            System.out.println("Test OK");
        }


    }
}