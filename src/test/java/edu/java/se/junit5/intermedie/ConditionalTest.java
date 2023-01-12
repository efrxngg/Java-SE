package edu.java.se.junit5.intermedie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;

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

    

    public boolean condition() {
        return true;
    }


}
