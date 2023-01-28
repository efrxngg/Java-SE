package edu.java.se.paterns.design.structural;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/*
El patrón Decorator permite al usuario agregar nuevas funciones a un objeto existente
sin alterar su estructura. Este tipo de patrón de diseño se incluye en el patrón estructural,
ya que este patrón actúa como un envoltorio para la clase existente.
Este patrón crea una clase de decorador que envuelve la clase original y proporciona
una funcionalidad adicional que mantiene intacta la firma de los métodos de clase.
 */
public class Decorator {

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Cuenta {
    private UUID id;
    private String cuenta;
}

interface ICuentaBancaria {
    void abrirCuenta(Cuenta c);
}

class CuentaAhorros implements ICuentaBancaria {
    @Override
    public void abrirCuenta(Cuenta c) {
        System.out.printf("ID:%s Cuenta de Ahorros%n", c.getId());
    }
}

class CuentaCorriente implements ICuentaBancaria {
    @Override
    public void abrirCuenta(Cuenta c) {
        System.out.printf("ID:%s Cuenta de Corriente%n", c.getId());
    }
}

//Decorator
class CuentaDecorador implements ICuentaBancaria {
    protected ICuentaBancaria cuentaDecorada;

    public CuentaDecorador(ICuentaBancaria cuentaDecorada) {
        this.cuentaDecorada = cuentaDecorada;
    }

    @Override
    public void abrirCuenta(Cuenta c) {
        cuentaDecorada.abrirCuenta(c);
    }

}


class BlindajeDecorador extends CuentaDecorador {
    public BlindajeDecorador(ICuentaBancaria cuentaDecorada) {
        super(cuentaDecorada);
    }

    @Override
    public void abrirCuenta(Cuenta c) {
        super.abrirCuenta(c);
        agregarBlindaje(c);
    }

    public void agregarBlindaje(Cuenta c) {
        System.out.println("Se agrego blindaje a la cuenta " + c.getId());
    }
}

class DecoratorDemo {
    public static void main(String[] args) {
        var cuenta = new Cuenta(UUID.randomUUID(), "efrxngg");

        var cuentaAhorros = new CuentaAhorros();
        var cuentaBlindada = new BlindajeDecorador(cuentaAhorros);
        cuentaBlindada.abrirCuenta(cuenta);

        var cuentaCorriente = new CuentaCorriente();
        var cuentaBlindadaCorriente = new BlindajeDecorador(cuentaCorriente);
        cuentaBlindadaCorriente.abrirCuenta(cuenta);
    }
}