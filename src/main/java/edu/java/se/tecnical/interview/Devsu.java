package edu.java.se.tecnical.interview;

import java.util.Arrays;

public class Devsu {
    public static void main(String[] args) {
//        int[] data = {-7, -10, -13, -8, -4, -7, -12, -3, -3, -6, -1, -6, 1};
//        System.out.println(exists(data, 9));
//        System.out.println(computeClosestToZero(data));

        System.out.println(62>>1);

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

    public static void functionx(){

    }

    public static void function(){

    }

}
