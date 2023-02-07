package edu.java.se.data.structure.linear;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
Listas enlazadas : Al igual que las matrices, la Lista enlazada es una estructura de datos lineal.
A diferencia de las matrices, los elementos de la lista enlazada no se almacenan en una ubicación
contigua; los elementos se vinculan mediante punteros.
 */
public class LinkedList {
    private Nodo cabeza;
    private int longitud;

    public class Nodo {
        public Libro libro;
        public Nodo siguiente;

        public Nodo(Libro libro) {
            this.libro = libro;
        }
    }

    public void insertarPrincipio(Libro libro) {
        Nodo nodo = new Nodo(libro);
        nodo.siguiente = cabeza;
        cabeza = nodo;
        longitud++;
    }

    public void insertarFinal(Libro libro) {
        Nodo nodo = new Nodo(libro);
        if (cabeza == null) {
            cabeza = nodo;
            longitud++;
            return;
        }

        Nodo puntero = cabeza;
        while (puntero.siguiente != null) {
            puntero = puntero.siguiente;
        }
        puntero.siguiente = nodo;
        longitud++;
    }

    public void insertarDespues(int n, Libro libro) {
        Nodo nodo = new Nodo(libro);
        if (cabeza == null) {
            cabeza = nodo;
            longitud++;
            return;
        }
        Nodo puntero = cabeza;
        int contador = 0;
        while (contador < n && puntero.siguiente != null) {
            puntero = puntero.siguiente;
            contador++;
        }
        nodo.siguiente = puntero.siguiente;
        puntero.siguiente = nodo;
        longitud++;

    }

    public Libro obtener(int n) {
        if (cabeza == null)
            return null;
        Nodo puntero = cabeza;
        int contador = 0;
        while (contador < n && puntero.siguiente != null) {
            puntero = puntero.siguiente;
            contador++;
        }
        longitud++;
        return puntero.libro;
    }

    public void eliminarPrincipio() {
        if (cabeza == null)
            return;
        Nodo primer = cabeza;
        cabeza = cabeza.siguiente;
        primer.siguiente = null;
        longitud--;
    }

    public void eliminarFinal() {
        if (cabeza != null) {
//            Este if es para el escenario donde solo tiene un elemento
            if (cabeza.siguiente == null) {
                cabeza = null;
            } else {
                Nodo puntero = cabeza;
                while (puntero.siguiente.siguiente != null) {
                    puntero = puntero.siguiente;
                }
                longitud--;
            }
        }
    }

    public void eliminar(int i) {
        if (i == 0) {
            Nodo primer = cabeza;
            cabeza = cabeza.siguiente;
            primer.siguiente = null;
            longitud--;
        } else if (i < longitud) {
            Nodo puntero = cabeza;
            int contador = 0;
            while (contador < (i - 1)) {
                puntero = puntero.siguiente;
                contador++;
            }
            Nodo temp = puntero.siguiente;
            puntero.siguiente = temp.siguiente;
            temp.siguiente = null;
            longitud--;
        }
    }

    public void recorrer() {
        if (cabeza == null)
            return;
        Nodo puntero = cabeza;

        for (int i = 0; i < longitud; i++) {
            System.out.println(puntero.libro);
            puntero = puntero.siguiente;
        }
    }

    public int longitud() {
        return this.longitud;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}

@Data
@AllArgsConstructor
class Libro {
    private String titulo;
    private String autor;

}

class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertarPrincipio(new Libro("X", "efrxngg"));
        linkedList.insertarFinal(new Libro("XX", "Anonymous"));
        linkedList.insertarFinal(new Libro("XXX", "Anonymous"));
        linkedList.insertarFinal(new Libro("XXXX", "Anonymous"));
        
        linkedList.insertarDespues(0, new Libro("XD", "X"));
        linkedList.recorrer();
    }
}