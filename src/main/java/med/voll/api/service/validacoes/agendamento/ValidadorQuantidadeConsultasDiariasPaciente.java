package med.voll.api.service.validacoes.agendamento;

import lombok.AllArgsConstructor;
import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.service.exception.ValidacaoRegraNegocioException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorQuantidadeConsultasDiariasPaciente implements ValidadorAgendamentoConsulta {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsultaDTO dadosAgendamento) {
        var primeiroHorario = dadosAgendamento.data().withHour(7);
        var ultimoHorario = dadosAgendamento.data().withHour(18);

        var pacienteComConsulta = repository.existsByPacienteIdAndDataBetween(dadosAgendamento.idPaciente(), primeiroHorario, ultimoHorario);

        if (Boolean.TRUE.equals(pacienteComConsulta)) {
            throw new ValidacaoRegraNegocioException("O paciente, já possui uma consulta na data informada!");
        }
    }
}
