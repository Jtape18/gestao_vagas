package br.com.josepaulo.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.josepaulo.gestao_vagas.modules.company.entities.JobEntity;
import br.com.josepaulo.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
    
    @Autowired
    private JobRepository jobRepository;
    
    public JobEntity execute(JobEntity jobEntity){
        return this.jobRepository.save(jobEntity);
        
    }

}
