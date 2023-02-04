package edu.java.se.data.structure.linear;

import edu.java.se.functional.Streams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/*
Listas enlazadas : Al igual que las matrices, la Lista enlazada es una estructura de datos lineal.
A diferencia de las matrices, los elementos de la lista enlazada no se almacenan en una ubicación
contigua; los elementos se vinculan mediante punteros.
 */
public class LinkedLists {

    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        IntStream.range(1, 10).forEach(linkedList::add);
        linkedList.forEach(System.out::println);
    }

}
