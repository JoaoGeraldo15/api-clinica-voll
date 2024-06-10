package med.voll.api.service.validacoes.agendamento;

import lombok.AllArgsConstructor;
import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;
import med.voll.api.service.MedicoService;
import med.voll.api.service.exception.ValidacaoRegraNegocioException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta {

    private MedicoService medicoService;

    public void validar(DadosAgendamentoConsultaDTO dadosAgendamento) {

        // Escolha do medico opcional
        if (dadosAgendamento.idMedico() == null) {
            return;
        }

        boolean medicoAtivo = medicoService.verificarMedicoAtivo(dadosAgendamento.idMedico());
        if (Boolean.FALSE.equals(medicoAtivo)) {
            throw new ValidacaoRegraNegocioException("O médico deve estar ativo no sistema para agendar uma consulta");
        }

    }
}
