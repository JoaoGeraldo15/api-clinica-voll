package med.voll.api.service;

import med.voll.api.model.dto.AtualizarPacienteDTO;
import med.voll.api.model.dto.CadastroPacienteDTO;
import med.voll.api.model.dto.DetalhamentoPacienteDTO;
import med.voll.api.model.dto.ListagemPacienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PacienteService {

    DetalhamentoPacienteDTO cadastrar(CadastroPacienteDTO pacienteDTO);

    Page<ListagemPacienteDTO> listar(Pageable paginacao);

    DetalhamentoPacienteDTO atualizar(Long id, AtualizarPacienteDTO dto);

    void deletar(Long id);

    DetalhamentoPacienteDTO consultar(Long id);
}
