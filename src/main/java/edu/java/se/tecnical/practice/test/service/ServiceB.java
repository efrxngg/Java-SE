package edu.java.se.tecnical.practice.test.service;

public interface ServiceB {
    ServiceA getServiceA();

    void setServiceA(ServiceA a);

    int multiplicar(int a, int b);

    int multiplicarSumar(int a, int b, int mult);

}
