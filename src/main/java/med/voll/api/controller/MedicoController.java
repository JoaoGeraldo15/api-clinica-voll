package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.model.dto.CadastroMedicoDTO;
import med.voll.api.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
@AllArgsConstructor
public class MedicoController {

    private MedicoService service;

    @PostMapping
    public ResponseEntity<CadastroMedicoDTO> cadastrar(@RequestBody @Valid CadastroMedicoDTO medico) {
        return ResponseEntity.ok(service.cadastrar(medico));
    }
}
