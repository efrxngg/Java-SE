package edu.java.se.functional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class App {
    public static void main(String[] args) {
        factorial(2);
        example();
    }

    private static int factorial(int x) {
        if (x <= 2) {
            return x;
        } else {
            return x * factorial(x - 1);
        }
    }

    private static void example() {
        List<Employee> employees = List.of(
                new Employee("efrxngg"),
                new Employee("efrxngg"),
                new Employee("efrxngg"));

        List<String> names = employees.stream().map(Employee::getName).collect(Collectors.toList());
        names.forEach(System.out::println);

        Function<String, Employee> generateEmploye = (name) -> new Employee(name);
        names.stream().map(generateEmploye).collect(Collectors.toList()).forEach(System.out::println);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    private static class Employee {

        private String name;

    }
}
