package med.voll.api.repository;

import med.voll.api.model.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
