package med.voll.api.model.dto.medico;

import med.voll.api.model.dto.EnderecoDTO;
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
