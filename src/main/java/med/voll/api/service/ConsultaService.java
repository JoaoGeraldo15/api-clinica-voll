package med.voll.api.service;

import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;
import med.voll.api.model.dto.DadosCancelamentoConsultaDTO;

public interface ConsultaService {


    DadosAgendamentoConsultaDTO agendarConsulta(DadosAgendamentoConsultaDTO dados);

    void cancelarConsulta(DadosCancelamentoConsultaDTO dadosCancelamentoConsulta);
}
