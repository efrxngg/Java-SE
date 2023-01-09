package edu.java.se.junit5.intermedie;

import edu.java.se.tecnical.interview.HirelineTopDev;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DinamicTestFactory {

    @TestFactory
    List<String> dynamicTestWithInvalidReturnType() {
        return List.of("Hello");
    }

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromColletion() {
        return Arrays.asList(dynamicTest("1 Dynamic Test", () -> assertTrue(HirelineTopDev.palindrome("oro"))));

    }

}
