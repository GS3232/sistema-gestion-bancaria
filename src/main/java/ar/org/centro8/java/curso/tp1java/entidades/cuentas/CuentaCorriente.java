package ar.org.centro8.java.curso.tp1java.entidades.cuentas;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa una cuenta corriente.
// Hereda los datos y operaciones de Cuenta.
@Getter
@Setter
@ToString(callSuper = true)
public class CuentaCorriente extends Cuenta {

    // Monto máximo que se puede utilizar cuando no alcanza el saldo.
    private double montoDescubierto;

    // Constructor para crear una cuenta corriente.
    public CuentaCorriente(
            int numCuenta,
            Cliente cliente,
            double montoDescubierto) {

        // La cuenta comienza con saldo 0.
        super(numCuenta, cliente);

        // Guarda el monto autorizado para el descubierto.
        this.montoDescubierto = montoDescubierto;
    }

    // Permite extraer dinero usando el saldo y el descubierto autorizado.
    @Override
    public void debitarEfectivo(double monto) {
        if (monto > 0 && monto <= getSaldo() + montoDescubierto) {
            setSaldo(getSaldo() - monto);
        }
    }

    // Recibe un cheque y acredita su monto si es válido.
    public void depositarCheque(Cheque cheque) {
        if (cheque != null && cheque.getMonto() > 0) {
            setSaldo(getSaldo() + cheque.getMonto());
        }
    }
}