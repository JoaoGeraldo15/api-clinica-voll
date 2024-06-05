package med.voll.api.model.dto;

public record DetalhamentoPacienteDTO(

        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        EnderecoDTO endereco) {
}
