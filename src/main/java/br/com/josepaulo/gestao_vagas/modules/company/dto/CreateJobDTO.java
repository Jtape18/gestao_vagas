package br.com.josepaulo.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "Vaga para pessoa desenvolvedora jr", requiredMode = RequiredMode.REQUIRED)
    private String description;
    @Schema(example = "Gympass, plano de saude", requiredMode = RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "JR", requiredMode = RequiredMode.REQUIRED)
    private String level;

}
