package med.voll.api.infra.exception;

import jakarta.servlet.http.HttpServletRequest;
import med.voll.api.service.exception.EntidadeNaoEncontrada;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerConfig {
    
    @ExceptionHandler(EntidadeNaoEncontrada.class)
    public ResponseEntity<StandardError> entidadeNaoEncontradaHandler(EntidadeNaoEncontrada ex, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> MethodArgumentNotValidHandler(MethodArgumentNotValidException ex, HttpServletRequest request) {
        var erros = ex.getFieldErrors().stream().map(ValidationError::new).toList();

        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), erros.toString(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    private record ValidationError(String campo, String mensagem) {
        public ValidationError(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

}
