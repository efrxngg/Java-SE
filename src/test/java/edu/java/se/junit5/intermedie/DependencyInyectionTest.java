package edu.java.se.junit5.intermedie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DependencyInyectionTest {

    private DependencyOne dp1;

    @BeforeEach
    void setup() {
        this.dp1 = new DependencyOne();
    }

    @Test
    @DisplayName("ID")
    void testInfo(TestInfo testInfo) {
        assertEquals("ID", testInfo.getDisplayName());
    }

    @Test
    void testID() {
        assertEquals("DP1", dp1.run());
    }

}

class DependencyOne {
    public String run() {
        return "DP1";
    }
}