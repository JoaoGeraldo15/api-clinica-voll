package med.voll.api.service.impl;

import lombok.AllArgsConstructor;
import med.voll.api.model.dto.AtualizarPacienteDTO;
import med.voll.api.model.dto.CadastroPacienteDTO;
import med.voll.api.model.dto.ListagemPacienteDTO;
import med.voll.api.model.entity.Paciente;
import med.voll.api.model.mapper.PacienteMapper;
import med.voll.api.repository.PacienteRepository;
import med.voll.api.service.PacienteService;
import med.voll.api.service.exception.EntidadeNaoEncontrada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private PacienteRepository repository;

    private PacienteMapper mapper;

    @Override
    @Transactional
    public CadastroPacienteDTO cadastrar(CadastroPacienteDTO pacienteDTO) {
        Paciente paciente = repository.save(mapper.toEntity(pacienteDTO));
        return mapper.toDTO(paciente);
    }

    @Override
    public Page<ListagemPacienteDTO> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(paciente -> mapper.toListagemDTO(paciente));
    }

    @Override
    @Transactional
    public CadastroPacienteDTO atualizar(Long id, AtualizarPacienteDTO dto) {
        Paciente paciente = obterPacienteOuLancarException(id);
        Paciente pacienteAtualizado = mapper.toEntity(paciente, dto);
        return mapper.toDTO(pacienteAtualizado);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Paciente paciente = obterPacienteOuLancarException(id);
        paciente.setAtivo(Boolean.FALSE);
    }

    private Paciente obterPacienteOuLancarException(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontrada(String.format("Paciente de id %d, não foi encontrado", id)));
    }
}
