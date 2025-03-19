package br.com.morgado.barbershop.exceptions;

import br.com.morgado.barbershop.exceptions.dto.ErroPadrao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

public class ApplicationExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResourceFoundException(NoResourceFoundException ex) {
        ErroPadrao erroPadrao = new ErroPadrao(HttpStatus.NOT_FOUND.value(), "Endpoint não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadrao);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        ErroPadrao erroPadrao = new ErroPadrao(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao processar sua requisição");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroPadrao);
    }

}
