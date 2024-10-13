package br.senac.sp.archetype.hexagonal.entrypoint.api.mapper;

import br.senac.sp.archetype.hexagonal.core.domain.Cliente;
import br.senac.sp.archetype.hexagonal.entrypoint.api.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {
        Cliente.class,
        ClienteDTO.class
})
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente toCliente(ClienteDTO dto);

    ClienteDTO toClienteDTO(Cliente cliente);


}
