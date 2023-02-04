package edu.java.se.data.structure.linear;

import java.util.Arrays;

/*
Una matriz es una colección de elementos almacenados en ubicaciones de memoria contiguas.
La idea es almacenar varios artículos del mismo tipo juntos. Esto facilita el cálculo de
la posición de cada elemento simplemente agregando un desplazamiento a un valor base,
es decir, la ubicación de memoria del primer elemento de la matriz (generalmente indicado
por el nombre de la matriz).
 */
public class Array {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(i * Math.random());
        }
        Arrays.stream(array).forEach(System.out::println);
    }

}
