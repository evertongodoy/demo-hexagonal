package br.senac.sp.archetype.hexagonal.core.gateway.database;

import br.senac.sp.archetype.hexagonal.core.domain.Cliente;
import br.senac.sp.archetype.hexagonal.core.domain.Clientes;

import java.util.Optional;

public interface ClienteGateway {

    Optional<Cliente> findById(String id);
    void criarCliente(Cliente cliente);
    Clientes findAllDatabase();

}