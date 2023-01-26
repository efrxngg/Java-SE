package edu.java.se.paterns.design.creational.factory;

/*
Factory Method es un patrón de diseño que se utiliza para crear objetos de una determinada clase.
Este patrón se basa en una interfaz o una clase base abstracta que define los métodos necesarios
para crear los objetos, y luego se implementa en una o varias clases concretas. La idea es que la
clase que utiliza el patrón no tenga que preocuparse por la creación de los objetos, sino que
simplemente los solicita a través de la interfaz o la clase base abstracta. Esto permite una mayor
flexibilidad en la creación de objetos y una mayor facilidad para cambiar la implementación de estos
objetos en el futuro.
 */
public class FactoryMethod implements AbstractFactory {
    public FactoryObject getInstance(String instance) {
        switch (instance.toLowerCase()) {
            case "a" -> {
                return new FactoryA();
            }
            case "b" -> {
                return new FactoryB();
            }
            default -> {
                return new Default();
            }
        }
    }
}

class FactoryA implements FactoryObject {
    @Override
    public void create() {
        System.out.println("Fabrica A");
    }
}

class FactoryB implements FactoryObject {
    @Override
    public void create() {
        System.out.println("Fabrica B");
    }
}

class Default implements FactoryObject {

    @Override
    public void create() {
        System.out.println("This class not exists");
    }

}

class FactoryMethodDemo {
    public static void main(String[] args) {
        var factoryMethod = new FactoryMethod();

        var objA = factoryMethod.getInstance("A");
        objA.create();

        var objB = factoryMethod.getInstance("B");
        objB.create();
    }

}