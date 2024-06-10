package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.model.dto.paciente.AtualizarPacienteDTO;
import med.voll.api.model.dto.paciente.CadastroPacienteDTO;
import med.voll.api.model.dto.paciente.DetalhamentoPacienteDTO;
import med.voll.api.model.dto.paciente.ListagemPacienteDTO;
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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
@AllArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    private PacienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoPacienteDTO> consultar(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultar(id));
    }

    @PostMapping
    public ResponseEntity<DetalhamentoPacienteDTO> cadastrar(@RequestBody @Valid CadastroPacienteDTO pacienteDTO, UriComponentsBuilder uriBuild) {
        DetalhamentoPacienteDTO pacienteCadastrado = service.cadastrar(pacienteDTO);
        var uri = uriBuild.path("/pacientes/{id}").buildAndExpand(pacienteCadastrado.id()).toUri();

        return ResponseEntity.created(uri).body(pacienteCadastrado);
    }

    @GetMapping
    public ResponseEntity<Page<ListagemPacienteDTO>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalhamentoPacienteDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarPacienteDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
