package edu.java.se.paterns.design.behavioral;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/*
Permite definir un mecanismo de suscripción
para notificar a varios objetos sobre cualquier evento
 */
public interface Observer {
    void update();
}

class Observable {
    private Set<Observer> observers = new HashSet<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}


class Subject extends Observable {
    private Integer state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }
}

@AllArgsConstructor
class ObservableA implements Observer {
    private Subject subject;

    @Override
    public void update() {
        System.out.println("Notification A:" + subject.getState());
    }
}

@AllArgsConstructor
class ObservableB implements Observer {
    private Subject subject;

    @Override
    public void update() {
        System.out.println("Notification B:" + subject.getState());
    }
}

class ObservableDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        var observableA = new ObservableA(subject);
        var observableB = new ObservableB(subject);
        
        subject.addObserver(observableA);
        subject.addObserver(observableB);
        IntStream.range(1, 3).forEach(subject::setState);

    }
}