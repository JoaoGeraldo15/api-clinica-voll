package med.voll.api.service.validacoes.agendamento;

import lombok.AllArgsConstructor;
import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;
import med.voll.api.service.PacienteService;
import med.voll.api.service.exception.ValidacaoRegraNegocioException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsulta {

    private PacienteService pacienteService;

    public void validar(DadosAgendamentoConsultaDTO dadosAgendamento) {

        boolean pacienteAtivo = pacienteService.verificarPacienteAtivo(dadosAgendamento.idPaciente());

        if (Boolean.FALSE.equals(pacienteAtivo)) {
            throw new ValidacaoRegraNegocioException("O paciente deve estar ativo no sistema para agendar uma consulta");
        }

    }
}
