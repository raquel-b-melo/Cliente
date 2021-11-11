package com.raquel.response;

public class MensagemDeErro {	

	public MensagemDeErro() {
	}

	public MensagemDeErro(String mensagem) {
		this.mensagem = mensagem;
	}

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
