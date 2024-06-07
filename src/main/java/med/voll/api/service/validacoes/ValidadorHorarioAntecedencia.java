package med.voll.api.service.validacoes;

import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;
import med.voll.api.service.exception.ValidacaoRegraNegocioException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta{

    public void validar(DadosAgendamentoConsultaDTO dadosAgendamento) {

        var dataConsulta = dadosAgendamento.data();
        var agora = LocalDateTime.now();
        var diferencaMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaMinutos < 30) {
            throw new ValidacaoRegraNegocioException("A consulta deve ser agendada com no mínimo 30 minutos de antecedência");
        }

    }
}
