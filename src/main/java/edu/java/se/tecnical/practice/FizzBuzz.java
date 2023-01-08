package edu.java.se.tecnical.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FizzBuzz {

    private boolean isMultipleOfNumber(int number, int multiplo) {
        return number % multiplo == 0;
    }

    public String calcMultiplesOfNumber(int number, Map<Integer, String> multiplos) {
        StringBuilder result = new StringBuilder();
        int contadorMultiplosValidos = 0;

        multiplos = multiplos.entrySet().stream()
                .sorted(Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Entry<Integer, String> multiplo : multiplos.entrySet()) {
            if (isMultipleOfNumber(number, multiplo.getKey())) {
                result.append(multiplo.getValue());
                contadorMultiplosValidos++;
            }
        }

        return contadorMultiplosValidos != multiplos.size() ? String.valueOf(number) : result.toString();
    }

}
