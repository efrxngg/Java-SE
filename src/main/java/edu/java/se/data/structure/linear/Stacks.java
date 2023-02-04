package edu.java.se.data.structure.linear;

import java.util.Stack;
import java.util.stream.IntStream;

/*
Stack es una estructura de datos lineal que sigue un orden particular en el que se realizan
las operaciones. El orden puede ser LIFO (Last In First Out) o FILO (First In Last Out).
En la pila, todas las inserciones y eliminaciones están permitidas solo en un extremo de la lista.
 */
public class Stacks {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        IntStream.range(1, 10).forEach(stack::push);
        stack.pop();
        stack.forEach(System.out::println);
    }

}
