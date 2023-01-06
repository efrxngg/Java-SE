package edu.java.se.tecnical.interview;

import java.util.Arrays;

public class Devsu {
    public static void main(String[] args) {
//        int[] data = {-7, -10, -13, -8, -4, -7, -12, -3, -3, -6, -1, -6, 1};
//        System.out.println(exists(data, 9));

//        System.out.println(computeClosestToZero(data));

//        String[] remaining = filterWords(new String[]{"Hola", "Como", "Estas"}, "a");
//        for (String s : remaining) {
//            System.out.println(s);
//        }
    }

    public static String[] filterWords(String[] words, String letters) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        var r = new String[words.length];
        for (int i = 0, c = 0; i < words.length; i++) {
            if (words[i].contains(letters)) {
                r[c] = words[i];
                c++;
            }
        }
        return r;
    }

    //El objetivo de este ejercicio es verificar la presencia de un número en una matriz.
    public static boolean exists(int[] ints, int n) {
        return Arrays.binarySearch(ints, n) > -1;
    }

    //Crea un metodo que retorne el numero mas cerca no a cero y en caso de que sean iguales retorna el positivo
    public static int computeClosestToZero(int[] ts) {
        if (ts.length == 0)
            return 0;
        int closest = ts[0];
        for (int number : ts) {
            int a = Math.abs(number);
            int b = Math.abs(closest);
            if (a < b || (a == b && number > 0)) {
                closest = number;
            }
        }
        return closest;

    }

    /**
     * @return the sum of integers whose index is between n1 and n2
     */
    public static int calc(int[] array, int n1, int n2) {
        if (!(0 <= n1 && n1 <= n2 && n2 < array.length))
            throw new IllegalArgumentException();

        int result = 0;
        for (int n : array) {
            result += n;
        }
        return result;
    }

}
