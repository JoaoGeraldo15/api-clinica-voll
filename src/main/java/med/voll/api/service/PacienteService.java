package med.voll.api.service;

import med.voll.api.model.dto.paciente.AtualizarPacienteDTO;
import med.voll.api.model.dto.paciente.CadastroPacienteDTO;
import med.voll.api.model.dto.paciente.DetalhamentoPacienteDTO;
import med.voll.api.model.dto.paciente.ListagemPacienteDTO;
import med.voll.api.model.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PacienteService {

    DetalhamentoPacienteDTO cadastrar(CadastroPacienteDTO pacienteDTO);

    Page<ListagemPacienteDTO> listar(Pageable paginacao);

    DetalhamentoPacienteDTO atualizar(Long id, AtualizarPacienteDTO dto);

    void deletar(Long id);

    DetalhamentoPacienteDTO consultar(Long id);

    Paciente obterPacienteOuLancarException(Long id);

    Boolean verificarPacienteAtivo(Long idPaciente);
}
