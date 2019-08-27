package br.codes.clebermacieski.estruturasdedados.arvorebinaria;

public class Nodo {
	private Nodo esquerdo;
	private Nodo direito;
	private int conteudo;

	public Nodo(int conteudo) {
		this.conteudo = conteudo;
	}

	public Nodo getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(Nodo esquerdo) {
		this.esquerdo = esquerdo;
	}

	public Nodo getDireito() {
		return direito;
	}

	public void setDireito(Nodo direito) {
		this.direito = direito;
	}

	public int getConteudo() {
		return conteudo;
	}

	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}
}
