package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_duplamente_encadeada;

public class Nodo {

	private Nodo anterior;
	private int conteudo;
	private Nodo proximo;

	public Nodo(Nodo anterior, int conteudo, Nodo proximo) {
		super();
		this.anterior = anterior;
		this.conteudo = conteudo;
		this.proximo = proximo;
	}

	Nodo getAnterior() {
		return anterior;
	}

	void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public int getConteudo() {
		return conteudo;
	}

	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}

	Nodo getProximo() {
		return proximo;
	}

	void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {
		return "conteudo=" + conteudo;
	}

}
