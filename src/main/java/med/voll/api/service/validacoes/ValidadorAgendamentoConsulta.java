package med.voll.api.service.validacoes;

import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoConsulta {

    void validar(DadosAgendamentoConsultaDTO dadosAgendamento);
}
