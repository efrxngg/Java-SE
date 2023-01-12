package edu.java.se.junit5.intermedie;

import org.junit.jupiter.api.*;

//Para configurar el orden de ejecución de la clase de prueba
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class OrderTest {
    @Nested
    @Order(1)
    class PrimaryTests {

        @Test
        void test1() {
            System.out.println("1");
        }
    }

    @Nested
    @Order(2)
    class SecondaryTests {

        @Test
        void test2() {
            System.out.println("2");
        }
    }

}
