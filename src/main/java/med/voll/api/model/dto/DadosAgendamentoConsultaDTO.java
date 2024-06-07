package med.voll.api.model.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.controller.validacao.ValidaEspecialidade;
import med.voll.api.model.enums.EspecialidadeEnum;

import java.time.LocalDateTime;

@ValidaEspecialidade
public record DadosAgendamentoConsultaDTO(

        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime data,

        EspecialidadeEnum especialidade
        ) {
}
