package edu.java.se.mockito.introduccion;

import edu.java.se.tecnical.practice.test.service.ServiceA;
import edu.java.se.tecnical.practice.test.service.ServiceB;
import edu.java.se.tecnical.practice.test.service.impl.ServiceAImpl;
import edu.java.se.tecnical.practice.test.service.impl.ServiceBImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceBTest {

    @Test
    void testMultiplicarSumarMock(){
        ServiceA sa = mock(ServiceA.class);
        when(sa.sumar(2, 5)).thenReturn(10);
        ServiceB sb  = new ServiceBImpl();
        sb.setServiceA(sa);

        assertEquals(10, sb.multiplicarSumar(2, 5, 1));
    }

}
