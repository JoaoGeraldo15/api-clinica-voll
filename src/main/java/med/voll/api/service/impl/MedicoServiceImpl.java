package med.voll.api.service.impl;

import lombok.AllArgsConstructor;
import med.voll.api.model.dto.CadastroMedicoDTO;
import med.voll.api.model.entity.Medico;
import med.voll.api.model.mapper.MedicoMapper;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.service.MedicoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MedicoServiceImpl implements MedicoService {

    private MedicoRepository repository;
    private MedicoMapper mapper;

    @Override
    @Transactional
    public CadastroMedicoDTO cadastrar(CadastroMedicoDTO dto) {
        Medico entity = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(entity);
    }
}