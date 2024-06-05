package med.voll.api.model.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarPacienteDTO(

        @NotNull
        Long id,

        String nome,
        String telefone,
        EnderecoDTO endereco) {
}
