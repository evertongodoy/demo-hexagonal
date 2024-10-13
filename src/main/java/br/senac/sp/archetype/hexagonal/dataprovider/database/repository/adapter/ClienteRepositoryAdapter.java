package br.senac.sp.archetype.hexagonal.dataprovider.database.repository.adapter;

import br.senac.sp.archetype.hexagonal.core.domain.Cliente;
import br.senac.sp.archetype.hexagonal.core.domain.Clientes;
import br.senac.sp.archetype.hexagonal.dataprovider.database.repository.ClienteJpaRepository;
import br.senac.sp.archetype.hexagonal.dataprovider.database.repository.adapter.mapper.ClienteEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteRepositoryAdapter {

    private final ClienteJpaRepository jpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Optional<Cliente> findById(String id) {
        return jpaRepository.findById(id)
                .map(ClienteEntityMapper.INSTANCE::toCliente);
    }

    public void criarCliente(Cliente cliente){
        var entity = ClienteEntityMapper.INSTANCE.toEntity(cliente);
        jpaRepository.save(entity);
    }

    public Clientes findAllDatabase() {
        var entities = jpaRepository.findAll();
        var clientes = new Clientes();
        clientes.setClientes(entities.stream()
                .map(ClienteEntityMapper.INSTANCE::toCliente)
                .toList());
        return clientes;
    }

}