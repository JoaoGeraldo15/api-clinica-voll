package med.voll.api.service.validacoes.cancelamento;

import med.voll.api.model.dto.DadosCancelamentoConsultaDTO;

public interface ValidadorCancelamentoConsulta {
    void validar(DadosCancelamentoConsultaDTO dados);
}
