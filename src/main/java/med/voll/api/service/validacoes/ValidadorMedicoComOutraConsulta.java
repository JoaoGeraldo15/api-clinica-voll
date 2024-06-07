package med.voll.api.service.validacoes;

import lombok.AllArgsConstructor;
import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.service.exception.ValidacaoRegraNegocioException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorMedicoComOutraConsulta implements ValidadorAgendamentoConsulta {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsultaDTO dadosAgendamento) {

        var medicoJaComConsultaNaData = repository.existsByMedicoIdAndData(dadosAgendamento.idMedico(), dadosAgendamento.data());

        if (Boolean.TRUE.equals(medicoJaComConsultaNaData)) {
            throw new ValidacaoRegraNegocioException("O médico já possui uma consulta na data informada!");
        }
    }
}
