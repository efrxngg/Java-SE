package edu.java.se.paterns.design.creational.factory;

public interface AbstractFactory {
    FactoryObject getInstance(String name);
}

class AbstractFactoryProvider {
    public static AbstractFactory getFactory(String factory) {
        return switch (factory) {
            case "fact1" ->
                    new FactoryMethod();
            case "fact2" ->
                    new FactoryMethod2();
            case "fact3" ->
                    new FactoryMethod3();
            default ->
                    throw new IllegalArgumentException();
        };
    }
}

class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory fabrica1 = AbstractFactoryProvider.getFactory("fact1");
        fabrica1.getInstance("a").create();
        fabrica1.getInstance("b").create();

        AbstractFactory fabrica2 = AbstractFactoryProvider.getFactory("fact2");
        fabrica2.getInstance("a").create();
        fabrica2.getInstance("b").create();
    }
}


class FactoryMethod2 extends FactoryMethod {

}

class FactoryMethod3 extends FactoryMethod {

}