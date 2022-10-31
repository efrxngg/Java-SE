package edu.java.se.functional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Las operaciones terminales son aquellas que como resultado no generan un nuevo stream 
 * Su resultado puede variar segun la operacion
 * Las operaciones terminales más comunes que se encuentran en Stream son:
 *     anyMatch()
 *     allMatch()
 *     noneMatch()
 *     findAny()
 *     findFirst()
 *     min()
 *     max()
 *     reduce()
 *     count()
 *     toArray()
 *     collect()
 *     forEach()
 * 
 * Las operaciones terminales se encargan de dar un fin y de liberar el espacio usado por el stream una vez que has agregado una operación a un Stream, el Stream original ya no puede ser utilizado
 */
public class StreamsTerminalOperations {
    public static void main(String[] args) {
        coincidenceTerminalOperations();
        findTerminalOperations();
        minAndMaxTerminalOperations();
        reduceTerminanlOperations();
        iterationOperationTerminal();

    }

    /*
     * Esta operación existe en tres formas:
     * reduce(BinaryAccumulator)
     * Retorna un Optional del mismo tipo que el Stream, con un solo valor
     * resultante de aplicar el BinaryAccumulator sobre cada elemento o
     * Optional.empty() si el stream estaba vacío. Puede generar un
     * NullPointerException en casos donde el resultado de BinaryAccumulator sea
     * null.
     * 
     * reduce(valorInicial, BinaryOperator)
     * Retorna un valor del mismo tipo que el Stream después de aplicar
     * BinaryOperator sobre cada elemento del Stream. En caso de un Stream vacío, el
     * valorInicial es retornado
     * 
     * reduce(valorInicial, BinaryFunction<V, T, V>, BinaryOperator<V>)
     * Genera un valor de tipo V después de aplicar BinaryFunction sobre cada
     * elemento de tipo T en el Stream y obtener un resultado V.
     * 
     * * count
     * Una operación sencilla: sirve para obtener cuantos elementos hay en el
     * Stream.
     * 
     * -Coolertors
     */
    private static void reduceTerminanlOperations() {
        wordsOfHistory.stream()
                .reduce((previousHistory, nextPart) -> {
                    String result = new StringBuilder(previousHistory).append(" ").append(nextPart).toString();
                    System.out.println(result);
                    return result;
                })
                .ifPresent(System.out::println);

        Stream<Integer> numberStream = Stream.iterate(0, i -> {
            System.out.println(++i);
            return i;
        }).limit(10);
        int result = numberStream.reduce(0, Integer::sum);
        System.out.println(result);

        int result2 = wordsOfHistory.stream().reduce(0, (accumulator, word) -> {
            int r = accumulator + word.length();
            System.out.println(new StringBuilder().append("=").append(accumulator).append("+").append(word.length()));
            return r;
        }, Integer::sum);
        System.out.println(result2);

        System.out.println(numbeStreams.stream().count());
    }

    private static void iterationOperationTerminal() {
        // Operacion terminal de iteracion
        numbeStreams.stream().collect(Collectors.toSet()).forEach(System.out::print);
    }

    /*
     * Son dos operaciones cuya finalidad es obtener el elemento más pequeño (min) o
     * el elemento más grande (max) de un Stream usando un Comparator
     */
    private static void minAndMaxTerminalOperations() {
        numbeStreams.stream()
                .min((x, y) -> Math.min(x, y))
                .ifPresent(System.out::println);

        numbeStreams.stream()
                .max((x, y) -> Math.max(x, y))
                .ifPresent(System.out::println);
    }

    /*
     * Estas operaciones retornan un Optional<T> como resultado de buscar un
     * elemento dentro del Stream.
     * 
     */
    private static void findTerminalOperations() {
        numbeStreams.stream()
                .findFirst()
                .ifPresent(System.out::println);

        numbeStreams.stream()
                .findAny()
                .ifPresent(System.out::println);
    }

    private static void coincidenceTerminalOperations() {
        // Nos indica si un stream contiene UN elemento según el Predicate que le
        // pasemos:
        boolean anyMatch = numbeStreams.stream().anyMatch((item) -> item > 10);
        System.out.println(anyMatch);

        // Nos indica si TODOS los elementos de un Stream cumplen con un cierto
        // Predicate:
        boolean allMatch = numbeStreams.stream().allMatch((item) -> item > 18);
        System.out.println(allMatch);

        // Nos indica si todos los elementos de un Stream NO CUMPLEN un cierto
        // Predicate:
        boolean noneMatch = numbeStreams.stream().noneMatch((item) -> item % 2 != 0);
        System.out.println(noneMatch);
    }

    private static List<Integer> numbeStreams = List.of(2, 4, 6, 14, 8, 20);
    private static List<String> wordsOfHistory = List.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba",
            "allí.");
}
