package edu.java.se.functional;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ColonOperator {

    public static void main(String[] args) {
        exampleI();
        exampleII();
        exampleIII();
    }

    public static List<String> teachers = getList("efrxngg", "Willian Schnaider", "Tapia");

    private static void exampleIII() {
        teachers.forEach(ColonOperator::printer);
    }

    private static void printer(String txt) {
        System.out.println(txt);
    }

    private static void exampleII() {
        teachers.forEach(System.out::println);
    }

    private static void exampleI() {
        Consumer<String> printer = item -> System.out.println(item);
        teachers.forEach(printer);
    }

    @SafeVarargs
    public static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }

}
