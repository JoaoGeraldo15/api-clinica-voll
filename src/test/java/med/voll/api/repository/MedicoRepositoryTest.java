package med.voll.api.repository;

import med.voll.api.commom.Constante;
import med.voll.api.model.entity.Consulta;
import med.voll.api.model.entity.Medico;
import med.voll.api.model.entity.Paciente;
import med.voll.api.model.enums.EspecialidadeEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private MedicoRepository medicoRepository;


    @Test
    @DisplayName("Deveria devolver null quando unico medico cadastrado nao esta disponivel na data")
    void escolherMedicoAleatorioLivreNaDataCenario1() {
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);

        var medico = cadastrarMedico();
        var paciente = cadastrarPaciente();
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);

        var medicoLivre = medicoRepository.obterMedicoLivreAleatorio(EspecialidadeEnum.CARDIOLOGIA, proximaSegundaAs10);

        assertThat(medicoLivre).isNull();
    }

    @Test
    @DisplayName("Deveria devolver medico quando ele estiver disponivel na data")
    void escolherMedicoAleatorioLivreNaDataCenario2() {
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);
        var medico = cadastrarMedico();
        var medicoLivre = medicoRepository.obterMedicoLivreAleatorio(EspecialidadeEnum.CARDIOLOGIA, proximaSegundaAs10);
        assertThat(medicoLivre).isEqualTo(medico);
    }

    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        em.merge(new Consulta(null, medico, paciente, data, null));
    }

    private Medico cadastrarMedico() {
        return em.merge(Constante.MEDICO_CARDIOLOGIA_ATIVO);
    }

    private Paciente cadastrarPaciente() {
        return em.merge(Constante.PACIENTE_ATIVO);
    }
}