package edu.java.se.data.structure.linear;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

public interface Queue {
    void add(Task task);

    void delete();

    Task get();

    Task dispatch();
}

class QueueImpl implements Queue {

    private class Nodo {
        public Task task;
        public Nodo next;

        public Nodo(Task task) {
            this.task = task;
            next = null;
        }
    }

    private Nodo head, last;

    @Override
    public void add(Task task) {
        Nodo now = new Nodo(task);
        if (head == null) {
            head = now;
            last = now;
        } else {
            last.next = now;
        }
        last = now;
    }

    @Override
    public void delete() {
        if (head != null) {
            Nodo nodoDelete = head;
            head = head.next;
            nodoDelete.next = null;
            if (head == null)
                last = null;
        }
    }

    @Override
    public Task get() {
        if (head == null)
            return null;

        return head.task;
    }

    @Override
    public Task dispatch() {
        var task = get();
        delete();
        return task;
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Task {
    private int id;
    private String description;
    private Date date;
}

class QueueDemo {
    public static void main(String[] args) {
        Queue cola = new QueueImpl();
        var task = new Task();
        cola.add(task);
        cola.add(task);
        cola.add(task);

        var aux = cola.dispatch();
        while (Objects.nonNull(aux)) {
            System.out.println(aux);
            aux = cola.dispatch();
        }

        System.out.println("Cola vacia: " + Objects.isNull(cola.get()));
    }
}