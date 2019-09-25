package br.codes.clebermacieski.estruturasdedados_old.listasimplesncadeada;

public class Nodo {
	private String conteudo;
	private Nodo proximo;
	
	public Nodo(String conteudo, Object object) {
		this.conteudo = conteudo;
		this.proximo = (Nodo) object;
	}

	/**
	 * @return the conteudo
	 */
	public String getConteudo() {
		return conteudo;
	}

	/**
	 * @param conteudo the conteudo to set
	 */
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * @return the proximo
	 */
	public Nodo getProximo() {
		return proximo;
	}

	/**
	 * @param proximo the proximo to set
	 */
	public void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}

}
