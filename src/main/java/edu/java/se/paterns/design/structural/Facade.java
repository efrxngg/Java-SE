package edu.java.se.paterns.design.structural;

/*
El patrón de fachada oculta las complejidades del sistema y proporciona
una interfaz para el cliente mediante la cual el cliente puede acceder
al sistema. Este tipo de patrón de diseño se incluye en el patrón estructural,
ya que este patrón agrega una interfaz al sistema existente para ocultar sus complejidades.
 */
public interface Facade {
    void run();
}

class API implements Facade {
    @Override
    public void run() {
        System.out.println("...Fetch Api 1");
    }
}

class API2 implements Facade {
    @Override
    public void run() {
        System.out.println("...Fetch Api 2");
    }
}

class FacadeMaker {
    private final API api;
    private final API2 api2;
    public FacadeMaker() {
        api = new API();
        api2 = new API2();
    }
    public void FetchApi() {
        api.run();
    }
    public void FetchApi2() {
        api2.run();
    }
}

class FacadeDemo {
    public static void main(String[] args) {
        var facadeMaker = new FacadeMaker();
        facadeMaker.FetchApi();
        facadeMaker.FetchApi2();
    }
}