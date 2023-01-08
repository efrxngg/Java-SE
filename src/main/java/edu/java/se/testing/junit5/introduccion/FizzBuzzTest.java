package edu.java.se.testing.junit5.introduccion;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    private FizzBuzz fizzBuzz;

    //    Funcion que se ejecuta antes de los test
    @Before
    public void before() {
        fizzBuzz = new FizzBuzz();
    }

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
