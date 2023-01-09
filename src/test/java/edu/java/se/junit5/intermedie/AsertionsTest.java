package edu.java.se.junit5.intermedie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;


//Sirve para ponerle nombre a los test, tanto a la clase y a los metodos
@DisplayName(value = "Aserciones Soportadas")
class AsertionsTest {
    private static int contador = 0;
    private final PersonDemo persona = new PersonDemo("Efren", "Galarza");

    //    Se ejecuta una sola vez al iniciar
    @BeforeAll
    static void initAll() {
        System.out.println("Init Method");
    }

    //    Se ejecuta una vez en cada @Test o similares
    @BeforeEach
    void init() {
        contador++;
    }

    @Test
    void standarAseertions() {
        String aux = new BigDecimal("500").add(new BigDecimal("500")).toString();
        assertEquals("1000", aux);
        assertEquals("1000", aux, "Optional failure message");
        assertTrue(true, () -> "Assertion message can be lazily evaluted");

    }

    @Test
    void groupAssetions() {
        assertAll("Multiples Assertions",
                () -> assertEquals("Efren", persona.getFirstName()),
                () -> assertEquals("Galarza", persona.getLastName())
        );
    }

    @Test
    void dependentAssert() {
//     Si  un bloque de codigo falla se omitira el siguiente bloque de codigo
        assertAll("properties",
                () -> {
                    assertNotNull(persona.getFirstName());
//                    Se ejecuta solo si la asercion previa es valida
                    assertAll("component 1",
                            () -> assertTrue(persona.getFirstName().startsWith("E")),
                            () -> assertTrue(persona.getLastName().startsWith("G"))
                    );
                },
                () -> {
                    assertNotNull(persona.getFirstName());
                    assertAll("component 2",
                            () -> assertTrue(persona.getFirstName().endsWith("n")),
                            () -> assertTrue(persona.getLastName().endsWith("a"))
                    );
                });
    }

    //    Para realizar test a erroes
    @Test
    void exceptionTest() {
        Exception exception = assertThrows(ArithmeticException.class, () -> Math.floorDiv(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    //    Para hacer test en relacion al tiempo
    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMillis(1), () -> {
            Thread.sleep(1);
        });
    }

    //    Para hacer test en relacion al tiempo con resultado
    @Test
    void timeOutNotExceededWithResult() {
        String result = assertTimeout(Duration.ofMillis(1), () -> {
            Thread.sleep(1);
            return "pass";
        });
        assertEquals("pass", result);
    }

    @Test
    void timeOutNotExceededWithMethod() {
        String saludo = assertTimeout(Duration.ofMillis(2), AssertionDemo::saluda);
        assertEquals("Hola", saludo);
    }

    @Test
    void timeOutExceededWithPreemptiveTermination() {
//        Lo mismo que assertTimeout con la peculiaridad de que cuando falla arroja un mensaje similar a
//        Tiempo de ejecucion agotado despues de 'n' s
        assertTimeoutPreemptively(Duration.ofMillis(1), () -> Thread.sleep(1));
    }

    @RepeatedTest(value = 10)
    @DisplayName("Multiples aserciones")
    void test() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void skippedTest() {
    }

    @AfterAll
    static void destroy() {
        System.out.println("Test :" + contador);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class PersonDemo {
    private String firstName;
    private String lastName;

}

class AssertionDemo {
    public static String saluda() {
        return "Hola";
    }
}