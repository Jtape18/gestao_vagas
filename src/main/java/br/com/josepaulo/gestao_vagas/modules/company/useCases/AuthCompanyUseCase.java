package br.com.josepaulo.gestao_vagas.modules.company.useCases;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.josepaulo.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.josepaulo.gestao_vagas.modules.company.repositories.CompanyRespository;

@Service
public class AuthCompanyUseCase {

    @Autowired
    private CompanyRespository companyRespository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException{

        var company = this.companyRespository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
            ()->{
                throw new UsernameNotFoundException("Company not Found");
            }
        );
        
      var passwordMatches =   this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if(!passwordMatches){
            throw new AuthenticationException();
        }

    }


}
