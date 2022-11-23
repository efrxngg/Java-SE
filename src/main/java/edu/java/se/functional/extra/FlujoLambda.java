package edu.java.se.functional.extra;

import java.util.List;
import java.util.function.Predicate;

public class FlujoLambda {

    public static void main(String[] args) {
        System.out.println("Stream 1===========================================");
        var t1 = flujo1("Abigail");

        System.out.println("Bucle 2===========================================");
        var t2 = flujo2("Abigail");

        System.out.println("Diferencia: " + (t1 - t2));
    }

    private static long flujo2(String nombre) {
        String result = null;
        System.out.println("Filtro==========");
        long inicio = System.currentTimeMillis();

        for (String i : datos) {
            System.out.println(i);
            if (i.equals(nombre)) {
                result = nombre;
                break;
            }
        }

        long tiempo = System.currentTimeMillis() - inicio;
        System.out.println("Mls " + tiempo);

        System.out.println("Resultado==========");
        System.out.println(result);
        return tiempo;
    }

    private static long flujo1(String nombre) {
        Predicate<String> validacion = (x) -> {
            System.out.println(x);
            return x.equals(nombre);
        };

        System.out.println("Filtro==========");

        long inicio = System.currentTimeMillis();
        var result = datos.stream()
                .filter(validacion)
                .findFirst().get();

        long tiempo = System.currentTimeMillis() - inicio;
        System.out.println("Mls " + tiempo);

        System.out.println("Resultado==========");
        System.out.println(result);
        return tiempo;
    }

    // #region
    private static List<String> datos = List.of(
            "Abigail", "Bulma", "Carlos", "Dario", "Efren", "Fajardo", "Gian", "Hugo", "Ismael",
            "Jose", "Karla", "Luis", "Mario", "Noriel", "Ñoño", "Oscar", "Pedro", "Quirga", "Roberto", "Samuel",
            "Tadeo", "Usca", "Violeta", "Walter", "Xavier", "Yoel", "Zoe");
    // #endregion
}
