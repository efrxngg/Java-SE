package edu.java.se.functional;

public class Chaining {
    public static void main(String[] args) {
        Chainer chainer = new Chainer();
        chainer.sayHi().sayBye();
    }

    static class Chainer {

        public Chainer sayHi() {
            System.out.println("Hola");
            return this;
        }

        public Chainer sayBye() {
            System.out.println("Adios");
            return this;
        }

    }
}
