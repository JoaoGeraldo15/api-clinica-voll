package med.voll.api.service.impl;

import lombok.AllArgsConstructor;
import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;
import med.voll.api.model.dto.DadosCancelamentoConsultaDTO;
import med.voll.api.model.entity.Consulta;
import med.voll.api.model.entity.Medico;
import med.voll.api.model.entity.Paciente;
import med.voll.api.model.mapper.ConsultaMapper;
import med.voll.api.service.ConsultaService;
import med.voll.api.service.MedicoService;
import med.voll.api.service.PacienteService;
import med.voll.api.service.exception.ValidacaoRegraNegocioException;
import med.voll.api.service.validacoes.agendamento.ValidadorAgendamentoConsulta;
import med.voll.api.service.validacoes.cancelamento.ValidadorCancelamentoConsulta;
import org.springframework.stereotype.Service;
import med.voll.api.repository.ConsultaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private MedicoService medicoService;

    private PacienteService pacienteService;

    private ConsultaMapper mapper;

    private ConsultaRepository repository;

    private List<ValidadorAgendamentoConsulta> validadores;

    private List<ValidadorCancelamentoConsulta> validadoresCancelamento;

    @Override
    @Transactional
    public DadosAgendamentoConsultaDTO agendarConsulta(DadosAgendamentoConsultaDTO dados) {
        Medico medico = new Medico();

        Paciente paciente = pacienteService.obterPacienteOuLancarException(dados.idPaciente());

        if (Objects.nonNull(dados.idMedico())) {
            medico = medicoService.obterMedicoOuLancarException(dados.idMedico());
        }

        validadores.forEach(v -> v.validar(dados));

        if(Objects.isNull(medico.getId())) {
            medico = medicoService.buscarMedicoLivreAleatorioNaData(dados.especialidade(), dados.data());
        }

        if(Objects.isNull(medico)) {
            throw new ValidacaoRegraNegocioException("Não existe médico disponível para data informada.");
        }

        Consulta consulta = new Consulta(null, medico, paciente, dados.data(), null);
        return mapper.toDTO(repository.save(consulta));
    }

    @Transactional
    public void cancelarConsulta(DadosCancelamentoConsultaDTO dados) {
        if (!repository.existsById(dados.idConsulta())) {
            throw new ValidacaoRegraNegocioException("Id da consulta informado não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = repository.getReferenceById(dados.idConsulta());
        consulta.setMotivoCancelamento(dados.motivo());
    }
}
