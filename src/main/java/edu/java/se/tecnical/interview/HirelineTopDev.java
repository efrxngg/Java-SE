package edu.java.se.tecnical.interview;

public class HirelineTopDev {
    public static void main(String[] args) {
//        sum(12);
//        mutationArray(4, 0, 1, -2, 3);
//        givenCentury(1905);
//        palindrome("ojo");
//        priceSencibility(new double[]{110, 95, 70}, new String[]{"10.0% higher than in-store",
//                "5.0% lower than in-store",
//                "Same as in-store"}, 5);
    }

    private static int sum(int n) {
        if (!(n > 0 && n <= 99)) throw new IllegalArgumentException();
        var nums = Integer.toString(n).split("");
        int r = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
        System.out.println(r);
        return r;
    }

    private static int[] mutationArray(int... a) {
        int len = a.length;
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            int ia = 0;
            int ib = 0;
            try {
                ia = a[i - 1];
            } catch (IndexOutOfBoundsException e) {
            }
            try {
                ib = a[i + 1];
            } catch (IndexOutOfBoundsException e) {
            }

            b[i] = ia + a[i] + ib;
        }

        for (int i : b) {
            System.out.println(i);
        }

        return b;
    }

    public static int givenCentury(int year) {
        if (!(year <= 2005))
            throw new IllegalArgumentException();
        int s = 0;
        for (int i = 1, y = 1; i <= year; i += 100, y++) {
            s = y;
        }
        System.out.println(s);
        return s;
    }

    public static boolean palindrome(String inputString) {
        String result = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            result += inputString.charAt(i);
        }

        return result.equals(inputString);
    }

    /*
    especification[] -> cadena de listas con especificaciones del articulo (descuentos)
    prices[] -> precios del aritulo en la tienda
    x -> es la cantidad total que esta dispuesto a pagar
    determinar si un cliente determinado estará dispuesto a pagar por los artículos dados en su carrito en función de su sensibilidad de precios x establecida .
     */

    public static boolean priceSencibility(double[] P, String[] N, double x) {
        double D = 0;
        int i = 0;
        for (String n : N) {
            double d = (n.contains("S")) ? 0 : Double.valueOf(n.split("%")[0]);
            if (n.contains("l"))
                d *= -1;
            D += P[i] * (d / (100 + d));
            i++;
        }

        return x >= D;
    }

}
