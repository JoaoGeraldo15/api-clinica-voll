package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;
import med.voll.api.model.dto.DadosCancelamentoConsultaDTO;
import med.voll.api.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
@AllArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<DadosAgendamentoConsultaDTO> agendarConsulta(@RequestBody @Valid DadosAgendamentoConsultaDTO dados) {
        return ResponseEntity.ok(consultaService.agendarConsulta(dados));
    }

    @DeleteMapping
    public ResponseEntity<Void> cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsultaDTO dadosCancelamentoConsulta) {
        consultaService.cancelarConsulta(dadosCancelamentoConsulta);
        return ResponseEntity.noContent().build();
    }
}
