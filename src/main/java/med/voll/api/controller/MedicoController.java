package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.model.dto.AtualizarMedicoDTO;
import med.voll.api.model.dto.CadastroMedicoDTO;
import med.voll.api.model.dto.DetalhamentoMedicoDTO;
import med.voll.api.model.dto.ListagemMedicoDTO;
import med.voll.api.service.MedicoService;
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
@RequestMapping("medicos")
@AllArgsConstructor
public class MedicoController {

    private MedicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoMedicoDTO> consultar(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultar(id));
    }

    @PostMapping
    public ResponseEntity<DetalhamentoMedicoDTO> cadastrar(@RequestBody @Valid CadastroMedicoDTO medico, UriComponentsBuilder uriBuilder) {
        DetalhamentoMedicoDTO medicoCadastrado = service.cadastrar(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medicoCadastrado.id()).toUri();
        return ResponseEntity.created(uri).body(medicoCadastrado);
    }

    @GetMapping
    public ResponseEntity<Page<ListagemMedicoDTO>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalhamentoMedicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarMedicoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
