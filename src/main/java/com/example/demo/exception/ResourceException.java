package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //indica que esta classe controla erros
public class ResourceException {

  //metodo que recebe o throw error (objnotfound) e a request da rota, para criar um erro personalizado
  @ExceptionHandler(ObjNotFound.class)
  public ResponseEntity<StandardError> objectNotFound(ObjNotFound e, HttpServletRequest req) {
    HttpStatus status = HttpStatus.NOT_FOUND; //retorna um numero codigo do erro
    StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", e.getMessage(),
        req.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

}
