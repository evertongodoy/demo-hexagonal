package br.senac.sp.archetype.hexagonal.dataprovider.database.gateway;

import br.senac.sp.archetype.hexagonal.core.domain.Cliente;
import br.senac.sp.archetype.hexagonal.core.domain.Clientes;
import br.senac.sp.archetype.hexagonal.core.gateway.database.ClienteGateway;
import br.senac.sp.archetype.hexagonal.dataprovider.database.repository.ClienteJpaRepository;
import br.senac.sp.archetype.hexagonal.dataprovider.database.mapper.ClienteRepositoryMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteGatewayImpl implements ClienteGateway {

    private final ClienteJpaRepository jpaRepository;

    public ClienteGatewayImpl(ClienteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Cliente> findById(String id) {
        return jpaRepository.findById(id)
                .map(ClienteRepositoryMapper.INSTANCE::toCliente);
    }

    @Override
    public void criarCliente(Cliente cliente){
        var entity = ClienteRepositoryMapper.INSTANCE.toEntity(cliente);
        jpaRepository.save(entity);
    }

    @Override
    public Clientes findAllDatabase() {
        var entities = jpaRepository.findAll();
        var clientes = new Clientes();
        clientes.setClientes(entities.stream()
                .map(ClienteRepositoryMapper.INSTANCE::toCliente)
                .toList());
        return clientes;
    }

}