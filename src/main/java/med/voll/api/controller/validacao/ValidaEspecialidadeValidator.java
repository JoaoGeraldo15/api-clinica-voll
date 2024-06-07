package med.voll.api.controller.validacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;

public class ValidaEspecialidadeValidator implements ConstraintValidator<ValidaEspecialidade, DadosAgendamentoConsultaDTO> {

    @Override
    public void initialize(ValidaEspecialidade constraintAnnotation) {
    }

    @Override
    public boolean isValid(DadosAgendamentoConsultaDTO dto, ConstraintValidatorContext context) {
        if (dto.idMedico() == null) {
            return dto.especialidade() != null;
        }
        return true;
    }
}
