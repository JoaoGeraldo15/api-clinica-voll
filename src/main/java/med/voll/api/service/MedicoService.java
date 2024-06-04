package med.voll.api.service;

import med.voll.api.model.dto.CadastroMedicoDTO;
import med.voll.api.model.dto.ListagemMedicoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoService {
    CadastroMedicoDTO cadastrar(CadastroMedicoDTO dto);

    Page<ListagemMedicoDTO> listar(Pageable paginacao);
}
