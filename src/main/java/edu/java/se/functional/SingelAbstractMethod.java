package edu.java.se.functional;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class SingelAbstractMethod {

    public static void main(String[] args) {
        calcAge();
        System.out.println(String.valueOf(1) instanceof String);
    }

    @FunctionalInterface
    interface TryFunction<T, U, V, R> {
        R accept(T t, U u, V v);
    }

    private static void calcAge() {
        TryFunction<Integer, Integer, Integer, Integer> calcAge = (day, month, year) -> {
            return Period.between(miFunctionalInterface(day, month, year), LocalDate.now()).getYears();
        };
        System.out.println(calcAge.accept(26, 9, 2002));
    }

    private static LocalDate miFunctionalInterface(int a, int b, int c) {
        Function<Integer, String> addCero = addCero();
        TryFunction<Integer, Integer, Integer, LocalDate> parseDate = (day, month, year) -> LocalDate
                .parse(addCero.apply(year) + "-" + addCero.apply(month) + "-" + addCero.apply(day));
        return parseDate.accept(a, b, c);
    }

    private static Function<Integer, String> addCero() {
        Function<Integer, String> addCero = x -> x < 10 && x >= 1 ? "0" + x : String.valueOf(x);
        return addCero;
    }

}
