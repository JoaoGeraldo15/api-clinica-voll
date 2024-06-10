package med.voll.api.service.validacoes.agendamento;

import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoConsulta {

    void validar(DadosAgendamentoConsultaDTO dadosAgendamento);
}
