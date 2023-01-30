package edu.java.se.paterns.design.behavioral;

public interface Strategy {
    void action();
}

class ImplOne implements Strategy {
    @Override
    public void action() {
        System.out.println("Executing action 1");
    }
}

class ImplTwo implements Strategy {
    @Override
    public void action() {
        System.out.println("Executing action 2");
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.action();
    }
}

class StrategiDemo {
    public static void main(String[] args) {
        var impl = new Context(new ImplOne());
        impl.execute();

        var impl2 = new Context(new ImplTwo());
        impl2.execute();
    }

}