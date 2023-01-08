package edu.java.se.junit5.intermedie;

import edu.java.se.tecnical.interview.HirelineTopDev;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//Sirve para ponerle nombre a los test, tanto a la clase y a los metodos
@DisplayName(value = "Aserciones Soportadas")
class AsertionsTest {
    private static int contador = 0;

    //    Se ejecuta una sola vez al iniciar
    @BeforeAll
    static void initAll() {
        System.out.println("Init");
    }

    //    Se ejecuta una vez en cada @Test o similares
    @BeforeEach
    void init() {
        System.out.print(contador);
        contador++;
    }

    //    Se ejecuta la cantidad de veces que le pongas en el value
    @RepeatedTest(value = 10)
    @DisplayName("Verdadero o falso")
    void test() {
        assertTrue(true);
    }

    @Test
    @Disabled("Este test no se ejecuta")
    void skippedTest() {
        assertEquals("1", "1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void palindromes(String word) {
        assertTrue(HirelineTopDev.palindrome(word));
    }

}
