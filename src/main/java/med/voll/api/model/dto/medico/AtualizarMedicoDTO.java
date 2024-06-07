package med.voll.api.model.dto.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.dto.EnderecoDTO;

public record AtualizarMedicoDTO(

        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco) {
}
