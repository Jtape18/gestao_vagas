package br.com.josepaulo.gestao_vagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.josepaulo.gestao_vagas.modules.company.entities.CompanyEntity;

public interface CompanyRespository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
    
    Optional<CompanyEntity> findByUsername(String username);

}
