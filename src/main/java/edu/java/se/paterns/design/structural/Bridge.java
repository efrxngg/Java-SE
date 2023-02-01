package edu.java.se.paterns.design.structural;

/*
Permite separar la abstracción de su implementación para que
ambos puedan ser modificados independientemente. Este patrón
se utiliza para desacoplar la interfaz de un objeto de su
implementación subyacente, permitiendo que la abstracción y la
implementación evolucionen de manera separada.
 */

interface DrawingAPI {
    public void drawCircle(double x, double y, double r);
}

class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double r) {
        System.out.printf("Circle 1= %s:%s R:%s%n", x, y, r);
    }
}

class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double r) {
        System.out.printf("Circle 2 = %s:%s R:%s%n", x, y, r);
    }
}

public abstract class Bridge {

    protected DrawingAPI drawingAPI;

    protected Bridge(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();

    public abstract void resizeByPercentaje(double pct);
}

class BridgeImpl extends Bridge {
    private double x, y, r;

    protected BridgeImpl(double x, double y, double r, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, r);
    }

    @Override
    public void resizeByPercentaje(double pct) {
        r *= (1.0 + pct / 100);
    }
}

class BrdigeDemo {
    public static void main(String[] args) {
        var impl = new BridgeImpl(1, 1, 2, new DrawingAPI1());
        impl.resizeByPercentaje(1);
        impl.draw();

    }
}