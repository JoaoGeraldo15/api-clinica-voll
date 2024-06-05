package med.voll.api.service.impl;

import lombok.AllArgsConstructor;
import med.voll.api.model.dto.AtualizarMedicoDTO;
import med.voll.api.model.dto.CadastroMedicoDTO;
import med.voll.api.model.dto.DetalhamentoMedicoDTO;
import med.voll.api.model.dto.ListagemMedicoDTO;
import med.voll.api.model.entity.Medico;
import med.voll.api.model.mapper.MedicoMapper;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.service.exception.EntidadeNaoEncontrada;
import med.voll.api.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MedicoServiceImpl implements MedicoService {

    private MedicoRepository repository;
    private MedicoMapper mapper;

    @Override
    @Transactional
    public DetalhamentoMedicoDTO cadastrar(CadastroMedicoDTO dto) {
        Medico entity = repository.save(mapper.toEntity(dto));
        return mapper.toDetalhamentoDTO(entity);
    }

    @Override
    public Page<ListagemMedicoDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(medico -> mapper.toListagemDTO(medico));
    }

    @Override
    @Transactional
    public DetalhamentoMedicoDTO atualizar(Long id, AtualizarMedicoDTO dto) {
        Medico medico = obterMedicoOuLancarException(id);
        Medico medicoAtualizado = mapper.toEntity(medico, dto);
        return mapper.toDetalhamentoDTO(medicoAtualizado);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Medico medico = obterMedicoOuLancarException(id);
        medico.setAtivo(Boolean.FALSE);
    }

    @Override
    public DetalhamentoMedicoDTO consultar(Long id) {
        return mapper.toDetalhamentoDTO(obterMedicoOuLancarException(id));
    }

    public Medico obterMedicoOuLancarException(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontrada(String.format("Médico com id %d não foi encontrado", id)));
    }

}
