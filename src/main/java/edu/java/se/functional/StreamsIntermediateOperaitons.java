package edu.java.se.functional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Se le dice operación intermedia a toda operación dentro de un Stream que como
 * resultado devuelva un nuevo Stream.
 * Las operaciones que ya están definidas son:
 * 
 * filter(…)
 * map(…)
 * flatMap(…)
 * distinct(…)
 * limit(…)
 * peek(…)
 * skip(…)
 * sorted(…)
 */
public class StreamsIntermediateOperaitons {
    public static void main(String[] args) {
        mapExample();
        mapToIntExample();
        mapToDoubleExample();
        flatMapExample();
        distintExample();
        limitExample();
        peekExample();
        skipExample();
        sortedExample();
    }

    /*
     * se utiliza para ordenar
     */
    private static void sortedExample() {

        IntStream.iterate(0, i -> ++i).limit(5)
                .mapToLong(x -> Math.round(Math.random() * 10))
                .sorted()
                .forEach(System.out::println);
    }

    /*
     * Se usa para omitir los primeros 'n'elementos del Stream dado .
     */
    private static void skipExample() {
        Stream<Integer> numbers = IntStream.iterate(0, i -> i + 2)
                .skip(5)
                .limit(10)
                .boxed();

        numbers.forEach(System.out::println);
    }

    /*
     * Devuelve el mismo flujo, además despues
     * realizar la acción proporcionada. en cada elemento a medida que se consumen
     * elementos del flujo resultante
     */
    private static void peekExample() {
        students.stream()
                .peek(System.out::println)
                .map(Student::getProgrammingLanguages)
                .flatMap(Collection::stream)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private static void limitExample() {
        IntStream.iterate(0, (i) -> ++i)
                .limit(10)
                .forEach(System.out::print);
    }

    /*
     * Este método usa los métodos hashCode() y equals() para obtener distintos
     * elementos
     */
    private static void distintExample() {
        Stream.of(1, 1, 2, 2, 3, 4, 5)
                .distinct().forEach(System.out::print);
    }

    private static void flatMapExample() {
        students.stream().map(Student::getProgrammingLanguages)
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    /*
     * Tanto mapToInt como mapToDouble nos abrira la posibilidad de accedesr a
     * metodos adicionales orientados a estadistica
     */
    private static void mapToDoubleExample() {
        var data = programminLanguages
                .stream()
                .mapToDouble(String::length)
                .summaryStatistics();
        System.out.println(data);
    }

    private static void mapToIntExample() {
        var data = programminLanguages
                .stream()
                .mapToInt(String::length)
                .filter(x -> x % 2 == 0)
                .sum();
        System.out.println(data);
    }

    private static void mapExample() {
        programminLanguages.stream()
                .map(programminLanguages::indexOf)
                .map(StreamsIntermediateOperaitons::generatePL)
                .map(ProgrammingLanguageHistory::new)
                .forEach(System.out::println);
    }

    private static ProgrammingLanguage generatePL(int indice) {
        return new ProgrammingLanguage(
                programminLanguages.get(indice),
                ageOfProgrammingLanguages.get(indice),
                authorOfProgrammingLanguage.get(indice));
    }

    private static List<String> programminLanguages = List.of("Java", "Python", "C++");
    private static List<String> ageOfProgrammingLanguages = List.of("1995", "1991", "1980");
    private static List<String> authorOfProgrammingLanguage = List.of("James Gosling", "Guido Van Rossum",
            "Bjarne Stroustroup");
    private static List<Student> students = List.of(
            new Student("efrxngg", List.of(generatePL(0), generatePL(1))),
            new Student("dxxxx", List.of(generatePL(1), generatePL(2))));

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class ProgrammingLanguage {
    private String name;
    private String year;
    private String creator;

}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
class ProgrammingLanguageHistory {
    private ProgrammingLanguage pl;

    @Override
    public String toString() {
        return new StringBuilder("The languege ").append(pl.getName())
                .append(" was created ").append(pl.getYear())
                .append(" by ").append(pl.getCreator()).toString();
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Student {
    private String name;
    private List<ProgrammingLanguage> programmingLanguages;
}