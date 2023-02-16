package edu.java.se.data.structure.linear;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Stack es una estructura de datos lineal que sigue un orden particular en el que se realizan
las operaciones. El orden puede ser LIFO (Last In First Out) o FILO (First In Last Out).
En la pila, todas las inserciones y eliminaciones están permitidas solo en un extremo de la lista.
 */
public interface Stack {
    void push(URL url);

    void pop();

    URL peek();

    int size();

    boolean isEmpty();
}

class StackImpl implements Stack {

    private class Nodo {
        public URL url;
        public Nodo next = null;

        public Nodo(URL url) {
            this.url = url;
        }
    }

    private Nodo cima = null;
    private int size = 0;

    @Override
    public void push(URL url) {
        Nodo nodo = new Nodo(url);
        nodo.next = cima;
        cima = nodo;
        size++;
    }

    @Override
    public void pop() {
        if (cima != null) {
            Nodo eliminar = cima;
            cima = cima.next;
            eliminar.next = null;
            size--;
        }
    }

    @Override
    public URL peek() {
        if (cima == null) {
            return null;
        }
        return cima.url;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class URL {
    private String url;
}

class StackDemo {
    public static void main(String[] args) {
        var urlA = new URL("https://www.google.es");
        var urlB = new URL("https://efrxngg.github.io");

        Stack pila = new StackImpl();
        pila.push(urlA);
        pila.push(urlB);
        System.out.println(pila.peek());
        pila.pop();
        System.out.println(pila.peek());
    }
}