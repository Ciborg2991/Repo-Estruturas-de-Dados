package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_circular;

public class Nodo {

	private String conteudo;
	private Nodo proximo;
	
	public Nodo(String conteudo, Nodo object) {
		this.conteudo = conteudo;
		this.proximo =  object;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Nodo getProximo() {
		return proximo;
	}

	public void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}
	
}
