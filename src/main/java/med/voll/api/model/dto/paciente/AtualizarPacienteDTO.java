package med.voll.api.model.dto.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.dto.EnderecoDTO;

public record AtualizarPacienteDTO(

        @NotNull
        Long id,

        String nome,
        String telefone,
        EnderecoDTO endereco) {
}
