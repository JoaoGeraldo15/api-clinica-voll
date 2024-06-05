package med.voll.api.model.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarMedicoDTO(

        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco) {
}
