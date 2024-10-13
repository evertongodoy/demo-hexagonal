package br.senac.sp.archetype.hexagonal.core.usecase.impl;

import br.senac.sp.archetype.hexagonal.core.domain.Cliente;
import br.senac.sp.archetype.hexagonal.core.domain.Clientes;
import br.senac.sp.archetype.hexagonal.core.exceptions.ClienteNaoEcontradoException;
import br.senac.sp.archetype.hexagonal.core.usecase.ClienteUseCase;
import br.senac.sp.archetype.hexagonal.dataprovider.client.ClienteWebData;
import br.senac.sp.archetype.hexagonal.dataprovider.database.repository.adapter.ClienteRepositoryAdapter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteRepositoryAdapter repository;
    private final ClienteWebData clienteWebData;

    public ClienteUseCaseImpl(final ClienteRepositoryAdapter repository,
                              final ClienteWebData clienteWebData) {
        this.repository = repository;
        this.clienteWebData = clienteWebData;
    }

    @Override
    public Cliente getClienteById(String id) {
        Optional<Cliente> clienteOptional = repository.findById(id);
        return clienteOptional.orElseThrow(() -> new ClienteNaoEcontradoException("Cliente nao encontrado"));
    }

    @Override
    public Clientes getClientesFromWeb() {
        return clienteWebData.getAllWeb();
    }

    @Override
    public void criarCliente(Cliente cliente) {
        repository.criarCliente(cliente);
    }

    @Override
    public Clientes getTodosClientesDB() {
        return repository.findAllDatabase();
    }

}