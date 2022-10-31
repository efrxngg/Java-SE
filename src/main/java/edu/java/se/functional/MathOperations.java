package edu.java.se.functional;

import java.util.function.Function;

public class MathOperations {
    public static void main(String[] args) {
        Function<Integer, Integer> m3 = x -> {
            System.out.println(x + "*3");
            return x * 3;
        };
        // Funcion Compuesta -Primero se ejecuta la funcion compuesta y despues la que
        // se mando a llamar
        Function<Integer, Integer> addOperation = m3.compose(y -> {
            System.out.println(y + "+1");
            return y + 1;
        });

        // Una vez halla terminado de ejecutar las funciones que ya tiene ejecute otra
        // vez
        Function<Integer, Integer> pow2 = addOperation.andThen(n -> {
            System.out.println(n + "^2 ");
            return n * n;
        });

        System.out.println(pow2.apply(10));

    }
}
