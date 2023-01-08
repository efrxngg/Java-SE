package edu.java.se.tecnical.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MoneyUtil {

    public static String format(double money) {
        String simbolo = "$";
        if (money < 0) {
            simbolo = "-$";
            money = money * -1;
        }
        var formarMoney = new BigDecimal(money).setScale(2, RoundingMode.HALF_UP);
        return simbolo + formarMoney;
    }

    public static String format(double money, String simbolo) {
        if(Objects.isNull(simbolo))
            throw new IllegalArgumentException("El simbolo no puede ser nulo");

        if (money < 0) {
            simbolo = "-" + simbolo;
            money = money * -1;
        }
        var formarMoney = new BigDecimal(money).setScale(2, RoundingMode.HALF_UP);
        return simbolo + formarMoney;
    }

}
