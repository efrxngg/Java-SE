package edu.java.se.functional;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Una vez que creamos un stream especifico todas las funciones, van a seguir trabajando sobre ese mismo tipo
 * Parallel no respeta el orden de los datos
 */
public class SteamsType {
    public static void main(String[] args) {
        example();
        example2();
    }

    private static void example2() {
        IntStream rangeStream = IntStream.range(1, 10);
        Stream<Integer> listInt = rangeStream.boxed();
        listInt.forEach(System.out::println);
    }

    private static void example() {
        IntStream infinityStream = IntStream.iterate(1, x -> x += 1);
        infinityStream
                .parallel()
                .limit(100)
                .filter(x -> x % 2 == 0)
                .boxed()
                .collect(Collectors.toList())
        .forEach(System.out::println);
    }
}
