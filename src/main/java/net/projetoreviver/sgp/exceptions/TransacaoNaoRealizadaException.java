package net.projetoreviver.sgp.exceptions;

public class TransacaoNaoRealizadaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TransacaoNaoRealizadaException(String mensagem) {
		super(mensagem);
	}
}
