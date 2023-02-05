package edu.java.se.data.structure.linear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Queues {

    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        IntStream.range(1, 10).forEach(cola::add);
        cola.offer(1);
        cola.remove();
        cola.poll();
        cola.element();
        cola.peek();
        cola.forEach(System.out::println);
    }

}
