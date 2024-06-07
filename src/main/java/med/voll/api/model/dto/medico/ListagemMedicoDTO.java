package med.voll.api.model.dto.medico;

import med.voll.api.model.enums.EspecialidadeEnum;

public record ListagemMedicoDTO(Long id, String nome, String email, String crm, EspecialidadeEnum especialidade) {
}
