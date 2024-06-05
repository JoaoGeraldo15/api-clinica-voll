package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.model.dto.AtualizarPacienteDTO;
import med.voll.api.model.dto.CadastroPacienteDTO;
import med.voll.api.model.dto.ListagemPacienteDTO;
import med.voll.api.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
@AllArgsConstructor
public class PacienteController {

    private PacienteService service;

    @PostMapping
    public ResponseEntity<CadastroPacienteDTO> cadastrar(@RequestBody @Valid CadastroPacienteDTO pacienteDTO) {
        return ResponseEntity.ok(service.cadastrar(pacienteDTO));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemPacienteDTO>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastroPacienteDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarPacienteDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
