package edu.java.se.junit5.introduction;

import edu.java.se.tecnical.practice.FizzBuzz;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private static final FizzBuzz fizzBuzz = new FizzBuzz();

    //    Funcion que se ejecuta antes de los test

    //    Cuando el numero sea multiplo de 3 que diga Fizz
    @Test
    public void testFizz() {
        String value = fizzBuzz.calcMultiplesOfNumber(75, Map.of(3, "fizz"));
        assertEquals("fizz", value);
    }

    //    Cuando el numero sea multiplo de 5 que diga Buzz
    @Test
    public void testBuzz() {
        String value = fizzBuzz.calcMultiplesOfNumber(15, Map.of(5, "buzz"));
        assertEquals("buzz", value);
    }

    //    Cuando el numero sea multiplo de 3 que diga Fizz
    @Test
    public void testFizzBuzz() {
        String value = fizzBuzz.calcMultiplesOfNumber(15, Map.of(3, "fizz", 5, "buzz"));
        assertEquals("fizzbuzz", value);
    }

    @Test
    public void testChallengeFizzBuzz() {
        int contador = 0;
        for (int i = 1; i <= 100; i++) {
            Map<Integer, String> multps = Map.of(3, "fizz", 5, "buzz");
            if (fizzBuzz.calcMultiplesOfNumber(i, multps).equals("fizzbuzz"))
                contador++;
        }

        assertEquals(6, contador);
    }

}
