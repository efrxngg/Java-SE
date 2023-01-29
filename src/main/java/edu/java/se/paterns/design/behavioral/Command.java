package edu.java.se.paterns.design.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
El patrón de diseño Command es un patrón de diseño estructural
que permite encapsular una petición o acción en un objeto separado,
de manera que se puedan parametrizar distintos objetos clientes con
diferentes peticiones, colas o registros de peticiones y se puedan
implementar operaciones de deshacer o rehacer.
*/
public class Command {
    private List<Action> actions = new ArrayList<>();

    public void addAction(Action a) {
        actions.add(a);
    }

    public void executeActions() {
        actions.forEach(Action::execute);
    }
}

@FunctionalInterface
interface Action {
    void execute();
}

class CommandDemo {
    public static void main(String[] args) {
        var command = new Command();
        command.addAction(() -> System.out.println("Hola como estas"));
        command.addAction(() -> System.out.println("Hasta la proxima que te valla bien"));

        command.executeActions();

    }
}