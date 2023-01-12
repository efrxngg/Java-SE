package edu.java.se.junit5.intermedie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.OS.*;

public class ConditionalTest {
    /*
        Para indicar que una prueba debe ser ejecutada
        solo si ciertas condiciones se cumplen
    */
    @Test
    @EnabledIf("condition")
    void willBeExecuted() {
    }

    //    Para realizar test relacionados con el SO y Arquitectura
    @Test
    @EnabledOnOs({LINUX, MAC, WINDOWS})
    void testEnableSO() {

    }

    @Test
    @DisabledOnOs({LINUX, MAC, WINDOWS})
    void testDisableSO() {

    }

    @Test
    @EnabledOnOs(architectures = {"x86_64"})
    void enableOnArchitectures() {

    }

    @Test
    @DisabledOnOs(architectures = {"x86_64"})
    void disableOnArchitectures() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_17})
    void onlyOnjava() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_9})
    void disableJRE() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
    void onlyrangeJRE() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_12, max = JRE.JAVA_16)

    public boolean condition() {
        return true;
    }

}
