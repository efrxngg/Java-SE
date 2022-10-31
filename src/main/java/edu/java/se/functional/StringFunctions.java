package edu.java.se.functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        unaryOperatorExample();
        biOperatorExample();
        biFunctionExample();
        biFunctionExample2();

    }

    private static void biFunctionExample2() {
        BiFunction<String, Integer, String> leftPad = (txt, cant) -> String.format("%" + cant + "s", txt);
        System.out.println(leftPad.apply("Java", 10));
    }

    private static void biOperatorExample() {
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(10, 10));
    }

    private static void biFunctionExample() {
        BiFunction<Integer, Integer, Integer> mult = (x, y) -> x * y;
        System.out.println(mult.apply(10, 10));
    }

    private static void unaryOperatorExample() {
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = txt -> txt + "!";

        System.out.println(quote.apply("efrxngg"));
        System.out.println(addMark.apply("efrxngg"));
    }
}