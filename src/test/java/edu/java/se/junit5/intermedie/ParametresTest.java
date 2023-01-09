package edu.java.se.junit5.intermedie;

import edu.java.se.tecnical.interview.HirelineTopDev;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ParametresTest {

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void palindromes(String word) {
        assertTrue(HirelineTopDev.palindrome(word));
    }

    /*
    Conversion Implicita
    Para que este tipo de pruebas funcione el obj debe tener
    un constructor mediante el cual inyectarle el dato
     */
    @ParameterizedTest
    @ValueSource(strings = "poo")
    void testObjectArgument(BookDemo book) {
        assertEquals("poo", book.getName());
    }

    /*
    Conversion Explicita
    Para que este tipo de prueba funcione tiene que hacer la implementacion de
    SimpleArgumentConverter o ArgumentConverter interface para manejar los datos
     */
    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testWithExplicitArgumentConversion(@ConvertWith(ToStringArgumentConverter.class) String argument) {
        assertNotNull(ChronoUnit.valueOf(argument));
    }

}

class ToStringArgumentConverter implements ArgumentConverter {

    @Override
    public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
        return ((ChronoUnit) o).name().toUpperCase();
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class BookDemo {
    private String name;
}