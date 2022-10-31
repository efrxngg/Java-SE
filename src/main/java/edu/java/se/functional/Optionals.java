package edu.java.se.functional;

import java.util.List;
import java.util.Optional;

public class Optionals {
    /*
     * Sirve principalmente para evitar los NullPointerException
     * 
     * Tu codigo debería usar unicamente Optional como resultado de una función,
     * nunca como entrada.
     */
    public static void main(String[] args) {
        varOptional();
        listOptinal();

    }

    private static void varOptional() {
        String name = getName("No es nulo").orElseGet(() -> "Es nulo");
        System.out.println(name);
    }

    private static void listOptinal() {
        Optional<List<String>> optionalNames = getOptionalNames();
        if (optionalNames.isEmpty())
            System.out.println();

        optionalNames.ifPresent(names -> names.forEach(System.out::println));
    }

    static Optional<String> getName(String txt) {
        return Optional.ofNullable(txt);
    }

    static Optional<List<String>> getOptionalNames() {
        List<String> list = List.of("efrxngg", "exxxx", "e????");
        if (list == null) {
            return Optional.empty();
        }
        return Optional.of(list);
    }
}
