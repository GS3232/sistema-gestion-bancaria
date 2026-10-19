package ar.org.centro8.java.curso.tp1java.entidades.clientes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// Es la clase padre de ClienteIndividual y ClienteEmpresa.
// Es abstracta porque no vamos a crear un objeto Cliente directamente.
@Getter
@AllArgsConstructor
@ToString
public abstract class Cliente {

    // Número que identifica al cliente.
    private int numero;
}
