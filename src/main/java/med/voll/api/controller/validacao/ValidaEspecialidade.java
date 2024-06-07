package med.voll.api.controller.validacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ValidaEspecialidadeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaEspecialidade {

    String message() default "Se idMedico for null, especialidade deve ser preenchida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
