package edu.java.se.paterns.design.behavioral;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public interface IObserver {
    void update();
}

class Observable {
    private Set<IObserver> observers = new HashSet<>();

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(IObserver::update);
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
class ObservableA implements IObserver {
    private Subject subject;

    @Override
    public void update() {
        System.out.println("Notification A:" + subject.getState());
    }
}

@AllArgsConstructor
class ObservableB implements IObserver {
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