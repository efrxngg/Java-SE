package edu.java.se.tecnical.practice.test.service.impl;

import edu.java.se.tecnical.practice.test.service.ServiceA;
import edu.java.se.tecnical.practice.test.service.ServiceB;

public class ServiceBImpl implements ServiceB {
    private ServiceA serviceA;

    @Override
    public ServiceA getServiceA() {
        return serviceA;
    }

    @Override
    public void setServiceA(ServiceA a) {
        this.serviceA = a;
    }

    @Override
    public int multiplicar(int a, int b) {
        return a * b;
    }

    @Override
    public int multiplicarSumar(int a, int b, int mult) {
        return serviceA.sumar(a, b) * mult;
    }
}
