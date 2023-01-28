package edu.java.se.paterns.design.structural;

import java.util.Objects;

/*
El patrón de diseño Proxy es un patrón estructural que se utiliza para proporcionar un sustituto o interfaz de control de acceso a un objeto.
El objeto proxy actúa como intermediario entre el cliente y el objeto real, y puede realizar tareas adicionales, como el control de acceso,
el seguimiento de información o la optimización de rendimiento. Los proxies suelen utilizarse para controlar el acceso a un objeto,
ya sea para restringirlo o para proporcionar un nivel adicional de abstracción.
*/
public class Proxy implements IProxy {
    private IProxy proxy;

    public Proxy(IProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void run() {
        if (Objects.isNull(proxy))
            proxy = new ProxyImpl();
        proxy.run();
    }
}

interface IProxy {
    void run();
}

class ProxyImpl implements IProxy {

    @Override
    public void run() {
        System.out.println("Proxy Implementado 1");
    }
}

class ProxyImpl2 implements IProxy {

    @Override
    public void run() {
        System.out.println("Proxy Implementado 2");
    }
}

class ProxyDemo {
    public static void main(String[] args) {
        var proxy = new Proxy(new ProxyImpl());
        proxy.run();

        var proxy2 = new Proxy(new ProxyImpl2());
        proxy2.run();
    }
}