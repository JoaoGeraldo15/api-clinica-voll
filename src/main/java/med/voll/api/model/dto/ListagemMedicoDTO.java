package med.voll.api.model.dto;

import med.voll.api.model.enums.EspecialidadeEnum;

public record ListagemMedicoDTO(String nome, String email, String crm, EspecialidadeEnum especialidade) {
}
