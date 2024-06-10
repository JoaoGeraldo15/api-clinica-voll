package med.voll.api.service.validacoes.cancelamento;

import lombok.AllArgsConstructor;
import med.voll.api.model.dto.DadosCancelamentoConsultaDTO;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.service.exception.ValidacaoRegraNegocioException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
@AllArgsConstructor
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoConsulta {

    private ConsultaRepository repository;

    @Override
    public void validar(DadosCancelamentoConsultaDTO dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoRegraNegocioException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }

}
