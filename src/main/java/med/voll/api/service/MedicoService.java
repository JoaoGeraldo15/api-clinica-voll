package med.voll.api.service;

import med.voll.api.model.dto.medico.AtualizarMedicoDTO;
import med.voll.api.model.dto.medico.CadastroMedicoDTO;
import med.voll.api.model.dto.medico.DetalhamentoMedicoDTO;
import med.voll.api.model.dto.medico.ListagemMedicoDTO;
import med.voll.api.model.entity.Medico;
import med.voll.api.model.enums.EspecialidadeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface MedicoService {
    DetalhamentoMedicoDTO cadastrar(CadastroMedicoDTO dto);

    Page<ListagemMedicoDTO> listar(Pageable paginacao);

    DetalhamentoMedicoDTO atualizar(Long id, AtualizarMedicoDTO dto);

    void deletar(Long id);

    DetalhamentoMedicoDTO consultar(Long id);

    Medico obterMedicoOuLancarException(Long id);

    Medico buscarMedicoLivreAleatorioNaData(EspecialidadeEnum especialidade, LocalDateTime data);

    boolean verificarMedicoAtivo(Long idMedico);
}
