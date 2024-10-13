package br.senac.sp.archetype.hexagonal.dataprovider.database.mapper;

import br.senac.sp.archetype.hexagonal.core.domain.Cliente;
import br.senac.sp.archetype.hexagonal.dataprovider.database.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {
        Cliente.class,
        ClienteEntity.class
})
public interface ClienteRepositoryMapper {

    ClienteRepositoryMapper INSTANCE = Mappers.getMapper(ClienteRepositoryMapper.class);

    ClienteEntity toEntity(Cliente cliente);

    Cliente toCliente(ClienteEntity clienteEntity);

}