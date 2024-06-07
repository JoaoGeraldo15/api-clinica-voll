package med.voll.api.model.dto.paciente;

import med.voll.api.model.dto.EnderecoDTO;

public record DetalhamentoPacienteDTO(

        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        EnderecoDTO endereco) {
}
