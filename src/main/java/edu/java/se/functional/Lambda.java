package edu.java.se.functional;

import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        courses.forEach((String course) -> System.out.println(course));
        useZero(() -> 2);
        // Si se puede poner contenido dentro del body
        useNoArgsNoBody(()->{System.out.println("Hola");});
        useNoArgsNoBody(()->{});
        
    }

    public static List<String> courses = ColonOperator.getList("4A", "4B", "4C", "4D");

    static void useZero(ZeroArgs zeroArgs) {}

    static void useNoArgsNoBody(NoArgsNoBody noArgsNoBody) {
        noArgsNoBody.run();
    }

    @FunctionalInterface
    interface ZeroArgs {
        int get();
    }

    @FunctionalInterface
    interface NoArgsNoBody {
        void run();
    }

}
