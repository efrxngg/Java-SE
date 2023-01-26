package edu.java.se.paterns.design.creational;

import java.util.UUID;

/*
El objetivo de este patron ees crear una nueva instancia con los
valores clonados o copiados de esta instancia
 */
public interface Prototype extends Cloneable {
    Prototype clonar();
}

class PrototypeImpl implements Prototype {

    public UUID id;
    public String tipo;
    public String descripcion;

    @Override
    public Prototype clonar() {
        PrototypeImpl prototype = null;
        try {
            prototype = (PrototypeImpl) clone();
        } catch (
                CloneNotSupportedException e) { // si la clonacion no es aceptada
            e.printStackTrace();
        }
        return prototype;
    }

    @Override
    public String toString() {
        return "PrototypeImpl{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

class PrototypeDemo {
    public static void main(String[] args) {
        var prototype = new PrototypeImpl();
        prototype.id = UUID.randomUUID();
        prototype.tipo = "x";
        prototype.descripcion = "algo";


        var prototypeClon = (PrototypeImpl) prototype.clonar();
        prototypeClon.tipo = "y";

        System.out.println("Original: " + prototype);
        System.out.println("Clon: " + prototypeClon);
    }
}