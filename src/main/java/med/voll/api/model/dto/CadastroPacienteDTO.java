package med.voll.api.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroPacienteDTO(

        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,
        String telefone,

        @NotBlank
        String cpf,

        @Valid
        @NotNull
        EnderecoDTO endereco) {
}
