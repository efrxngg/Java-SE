package edu.java.se.paterns.design.behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}

class Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public void add(Observer o) {
        observers.add(o);
    }

    public int getState() {
        return state;
    }

    public void setState(int value) {
        this.state = value;
        execute();

    }

    private void execute() {
        observers.forEach(Observer::update);
    }
}

class IntegerObserver extends Observer {
    public IntegerObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println(" " + subject.getState());
    }
}

class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println(" " + Integer.toBinaryString(subject.getState()));
    }
}

class ObserverDemo {
    public static void main(String[] args) {
        var subject = new Subject();
        new IntegerObserver(subject);
        new BinaryObserver(subject);
        var input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a number: ");
            subject.setState(input.nextInt());
        }
    }
}