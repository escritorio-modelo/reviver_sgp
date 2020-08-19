package net.projetoreviver.sgp.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.exceptions.TransacaoNaoRealizadaException;

@ControllerAdvice
public class ControllerAdviceExceptionHandlers {
	
	@ExceptionHandler(TransacaoNaoRealizadaException.class)
	public String handlerTransacaoNaoRealizadaException(TransacaoNaoRealizadaException e) {
		return "erros/500";
	}
	
	@ExceptionHandler(RegistroNaoEncontradoException.class)
	public String handlerRegistroNaoEncontrado(RegistroNaoEncontradoException e) {
		return "erros/404";
	}
}
