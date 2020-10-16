package net.projetoreviver.sgp.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import net.projetoreviver.sgp.exceptions.NegocioException;
import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.exceptions.TransacaoNaoRealizadaException;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdviceExceptionHandlers extends ResponseEntityExceptionHandler{
	

	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
		var campos = new ArrayList<Problema.Campo>();
		for(ObjectError error: ex.getBindingResult().getAllErrors()){
			String nome = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();
			campos.add(new Problema.Campo(nome, mensagem));
		}
		
		var problema = new Problema();
        problema.setTitulo("Um ou mais campos inválidos.");
		problema.setDataHora(LocalDateTime.now());
		problema.setCampos(campos);
        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request){
		var status = HttpStatus.BAD_REQUEST;
		var problema = new Problema();
		problema.setTitulo(ex.getMessage());
		problema.setDataHora(LocalDateTime.now());
		
		return super.handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(TransacaoNaoRealizadaException.class)
	public String handlerTransacaoNaoRealizadaException(TransacaoNaoRealizadaException e) {
		return "erros/500";
	}
	
	@ExceptionHandler(RegistroNaoEncontradoException.class)
	public String handlerRegistroNaoEncontrado(RegistroNaoEncontradoException e) {
		return "erros/404";
	}


}
