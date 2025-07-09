package br.com.josepaulo.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.josepaulo.gestao_vagas.exceptions.UserFoundException;
import br.com.josepaulo.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.josepaulo.gestao_vagas.modules.company.repositories.CompanyRespository;

@Service
public class CreateCompanyUseCase {
    
    @Autowired
    private CompanyRespository companyRespository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity){

        this.companyRespository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((user)  -> {
            throw new UserFoundException();
        });

        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);
    
        return this.companyRespository.save(companyEntity);
    }

}
