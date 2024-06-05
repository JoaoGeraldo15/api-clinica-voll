package med.voll.api.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroPacienteDTO(

        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,

        @Valid
        @NotNull
        EnderecoDTO endereco) {
}
