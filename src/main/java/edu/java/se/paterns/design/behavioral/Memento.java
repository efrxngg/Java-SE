package edu.java.se.paterns.design.behavioral;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*
permite capturar y restaurar el estado interno de un objeto. El patrón
se utiliza para permitir que un objeto pueda volver a un estado
anterior sin violar el principio de encapsulamiento.
*/
@Data
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        System.out.println("Originator: Memento Setting state to: " + state);
        this.state = state;
    }

    public Memento save() {
        System.out.println("Originator Saving to memento");
        return new Memento(state);
    }

    public void restore(Memento m) {
        state = m.getState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }

}

class Caretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getMemento(int indice) {
        return mementos.get(indice);
    }

}

class MementoDemo {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("State1");
        originator.setState("State2");
        caretaker.addMemento(originator.save());
        originator.setState("State3");
        caretaker.addMemento(originator.save());
        originator.setState("State4");
        originator.restore(caretaker.getMemento(0));
    }
}
