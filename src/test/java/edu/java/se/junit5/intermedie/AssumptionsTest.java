package edu.java.se.junit5.intermedie;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/*
Sub conjunto de metodos de suposicion que proporicona junit4
 */
public class AssumptionsTest {

    @Test
    void testUserName() {
        assumeTrue("efren".equals(System.getenv("USER")));
    }

    @Test
    void testAssumeTrueWithErrorMessage() {
        assumeTrue("efren".equals(System.getenv("USER")), () -> "Abortion test: not isn`t USER");
    }

    @Test
    void testInAllEnviorement() {
        assumingThat(
                "CI".equals(System.getenv("ENV")),
                () -> {
//                    Realizara las asserciones solo en el servidor ci
                    assertEquals(2, 2);
                }
        );
//        Realizara esta assercion en todos los entornos
        assertEquals(1, 1);
    }

    @Disabled("fix")
    class DissableClassDemo {
        @Test
        void test() {

        }
    }
}

