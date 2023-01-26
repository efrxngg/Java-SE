package edu.java.se.paterns.design.creational;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    public void run() {
        System.out.println("Singleton funcionando...");
    }

}

class SingletonDemo {
    public static void main(String[] args) {
        var singleton = Singleton.getInstance();
        singleton.run();
    }
}
