package med.voll.api.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsultaDTO(

        @NotNull
        Long idConsulta,

        @NotBlank
        String motivo
) {
}
