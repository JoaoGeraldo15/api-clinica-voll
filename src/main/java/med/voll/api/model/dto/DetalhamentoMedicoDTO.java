package med.voll.api.model.dto;

import med.voll.api.model.enums.EspecialidadeEnum;

public record DetalhamentoMedicoDTO(

        Long id,
        String nome,
        String telefone,
        String email,
        String crm,
        EspecialidadeEnum especialidade,
        EnderecoDTO endereco) {
}
