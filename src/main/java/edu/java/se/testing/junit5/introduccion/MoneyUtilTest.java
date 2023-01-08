package edu.java.se.testing.junit5.introduccion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Para correr todos los casos de prueba
public class MoneyUtilTest {

    //    Cara Correr un caso de prueba
    @Test
    public void moneyTest() {
        String money = MoneyUtil.format(1000);
        assertEquals("$1000.00", money);
    }

    @Test
    public void negativeMoneyTest() {
        String money = MoneyUtil.format(-1000);
        assertEquals("-$1000.00", money);
    }

    @Test
    public void euroMoneyTest() {
        assertEquals("€1000.00", MoneyUtil.format(1000, "€"));
    }

    @Test
    public void negativeEuroMoneyTest() {
        assertEquals("-€1000.00", MoneyUtil.format(-1000, "€"));
    }

    /*
     Para indicarle que espera un exception
     si la expcetion se lanza pasa el test
     */
    @Test
    public void notNullEuroMoneyTest() {
        boolean isValid = false;
        try {
            MoneyUtil.format(1000, null);
        } catch (IllegalArgumentException e) {
            isValid = true;
        }
        assertEquals(true, isValid);
    }

}
