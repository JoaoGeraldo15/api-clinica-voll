package med.voll.api.service;

import med.voll.api.model.dto.CadastroMedicoDTO;

public interface MedicoService {
    CadastroMedicoDTO cadastrar(CadastroMedicoDTO dto);
}
