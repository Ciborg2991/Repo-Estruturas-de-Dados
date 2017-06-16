package br.codes.ciborg2991.estruturasdedados.listadupencadeada;

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

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public int getConteudo() {
		return conteudo;
	}

	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}

	public Nodo getProximo() {
		return proximo;
	}

	public void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {
		return "conteudo=" + conteudo;
	}

}
