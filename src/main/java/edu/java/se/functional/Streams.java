package edu.java.se.functional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Stream es una especie de lista que tiene elementos y se pueden iterar
 * pero la diferencia es que un stream es auto iterable()
 *  
 * Los streams luego de ser consumidos ya no pueden generar mas operaciones
 * Para evitar esto podemos generar una lista y pedir sus recursos mediante el metodo .stream
 * que tienes las implementaciones de Collection
 * 
 * Los streams tienen dos tipos de operaciones 
 *  Operaciones Intermedias -> genera un nuevo stream -> return Stream
 *  Operaciones terminales -> genera un dato final despues de haber operado -> void
 * example:
 * Intermediate Operations:

map: The map method is used to returns a stream consisting of the results of applying the given function to the elements of this stream.
List number = Arrays.asList(2,3,4,5); List square = number.stream().map(x->x*x).collect(Collectors.toList());

filter: The filter method is used to select elements as per the Predicate passed as argument.
List names = Arrays.asList("Reflection","Collection","Stream"); List result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());

sorted: The sorted method is used to sort the stream.
List names = Arrays.asList("Reflection","Collection","Stream"); List result = names.stream().sorted().collect(Collectors.toList());

Terminal Operations:

collect: The collect method is used to return the result of the intermediate operations performed on the stream.
List number = Arrays.asList(2,3,4,5,3); Set square = number.stream().map(x->x*x).collect(Collectors.toSet());

forEach: The forEach method is used to iterate through every element of the stream.
List number = Arrays.asList(2,3,4,5); number.stream().map(x->x*x).forEach(y->System.out.println(y));

reduce: The reduce method is used to reduce the elements of a stream to a single value.
The reduce method takes a BinaryOperator as a parameter.
List number = Arrays.asList(2,3,4,5); int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
 */
public class Streams {
    public static void main(String[] args) {
        streamExample();
        streamExample2();
        exercise();
    }

    private static <T> Stream<T> addOperator(Stream<T> stream) {
        return stream.peek(item -> System.out.println("Dato: " + item));
    }

    private static void streamExample2() {
        Stream<String> namesStream = Stream.of("React", "Next");
        List<String> result = addOperator(namesStream
                .map(name -> name + "!")
                .filter(l -> l.contains("R")))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    private static void streamExample() {
        List<String> coursesString = List.of("Java", "Python", "C#", "JavaScript");

        Optional<Integer> maxLenghtCourse = coursesString.stream()
                .map(String::length)
                .max((x, y) -> y - x);
        System.out.println(maxLenghtCourse.get());

        Stream<String> filterLanguage = coursesString.stream().filter(x -> x.contains("Java"));
        filterLanguage.forEach(System.out::println);
    }

    private static void exercise() {
        usernames.stream()
                .map(Streams::converToTitle)
                .map(item -> item.concat("!"))
                .forEach(System.out::println);
    }

    public static String converToTitle(String item) {
        var firstLetter = item.charAt(0);
        return item.replace(firstLetter, Character.toUpperCase(firstLetter));
    };

    private static List<String> usernames = new LinkedList<>(List.of("efrxngg", "dxxxx", "Sierisimo"));
}
