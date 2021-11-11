package com.raquel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.raquel.response.MensagemDeErro;

@ControllerAdvice
public class ClienteNaoEncontradoException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MensagemDeErro> handleException(Exception e){
		
		MensagemDeErro mensagemDeErro = new MensagemDeErro("Id não encontrado");
		return new ResponseEntity<MensagemDeErro>(mensagemDeErro, HttpStatus.NOT_FOUND);
	}
}
