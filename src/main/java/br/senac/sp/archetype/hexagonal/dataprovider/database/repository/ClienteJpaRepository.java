package br.senac.sp.archetype.hexagonal.dataprovider.database.repository;

import br.senac.sp.archetype.hexagonal.dataprovider.database.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, String> {

}