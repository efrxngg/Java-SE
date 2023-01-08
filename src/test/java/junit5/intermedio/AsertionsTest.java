package junit5.intermedio;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(value = "Aserciones Soportadas")
public class AsertionsTest {

    @Test
    @DisplayName("Verdadero o falso")
    void test() {
        assertEquals("1", "1");
    }

}
