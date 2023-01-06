package edu.java.se.tecnical.practice;

import java.util.Scanner;

public class ISTG {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        validaCedula();
    }

    public static boolean validaCedula() {
        // char[] cedula = input.nextLine().toCharArray();
        char[] cedula = "0954943114".toCharArray();
        int len = cedula.length;

        if (!(len > 0 && len <= 10)) {
            System.out.println("Ingrese un numero de cedula valida");
            validaCedula();
        }

        int r = 0, acumulador = 0;
        for (int i = 0; i < len - 1; i++) {
            if (i % 2 != 0) {
                r = Integer.parseInt(Character.toString(cedula[i])) * 1;

            } else {
                r = Integer.parseInt(Character.toString(cedula[i])) * 2;
            }

            if (r > 9) {
                var aux = String.valueOf(r).split("");
                r = Integer.parseInt(aux[0]) + Integer.parseInt(aux[1]);
            }

            acumulador += r;

        }

        var aux2 = String.valueOf(acumulador).split("");
        int a = Integer.parseInt(aux2[0]);
        int b = Integer.parseInt(aux2[1]);
        int aux3 = a > b ? a : b;
        
        System.out.println(10 - aux3 == Integer.parseInt(Character.toString(cedula[len - 1])));
        return 10 - aux3 == Integer.parseInt(Character.toString(cedula[len - 1]));
    }

}