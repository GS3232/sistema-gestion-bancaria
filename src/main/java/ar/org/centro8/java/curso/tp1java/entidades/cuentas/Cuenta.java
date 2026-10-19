package ar.org.centro8.java.curso.tp1java.entidades.cuentas;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Es la clase padre de los distintos tipos de cuenta.
// Es abstracta porque no vamos a crear una Cuenta directamente.
@Getter
@ToString
public abstract class Cuenta {

    // Número que identifica la cuenta.
    private final int numCuenta;

    // Cliente que es dueño de la cuenta.
    private final Cliente cliente;

    // Dinero disponible en la cuenta.
    @Setter
    private double saldo;

    public Cuenta(int numCuenta, Cliente cliente) {
        this.numCuenta = numCuenta;
        this.cliente = cliente;
    }
    // Permite ingresar dinero a la cuenta.
    public void depositarEfectivo(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito realizado correctamente.");
            System.out.println("Saldo actual: " + saldo);
        } else {
            System.out.println("Error: el monto del depósito debe ser mayor que cero.");
        }
    }

    // Permite sacar dinero cuando hay saldo suficiente.
    public void debitarEfectivo(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto del retiro debe ser mayor que cero.");
        } else if (monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro realizado correctamente.");
            System.out.println("Saldo actual: " + saldo);
        } else {
            System.out.println("Error: saldo insuficiente.");
        }
    }
}