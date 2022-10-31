package edu.java.se.functional;

import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MathFunctions {
    public static void main(String... args) {
        functionExample1();
        functionExample2();
        predicateExample();
        predicateExample2();

    }

    private static void predicateExample2() {
        Predicate<Student> isApproved = std -> std.getQualification() >= 7 && std.getQualification() <= 10;
        Student std1 = new Student(10.5);
        System.out.println(isApproved.test(std1));
    }

    private static void predicateExample() {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(3));
    }

    private static void functionExample2() {
        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;
        System.out.println(isOdd.apply(3));
    }

    private static void functionExample1() {
        Function<Integer, Integer> squareFuntion = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t * t;
            }
        };
        System.out.println(squareFuntion.apply(2));
        System.out.println(squareFuntion.apply(10));

    }

    @Data
    @AllArgsConstructor
    static class Student {
        private double qualification;
    }
}
