package br.codes.ciborg2991.estruturasdedados.arvorebinaria;

public class ArvoreBinaria {
	private Nodo raiz;

	public ArvoreBinaria(int raiz) {
		this.raiz = new Nodo(raiz);
	}

	public void exibir() {
		this.exibirRecursivamente(this.raiz);
	}

	private void exibirRecursivamente(Nodo percorrendo) {

		System.out.println("Nodo: " + percorrendo.getConteudo());

		if ( percorrendo.getEsquerdo() != null){
			this.exibirRecursivamente(percorrendo.getEsquerdo());
		}
		if ( percorrendo.getDireito() != null){
			this.exibirRecursivamente(percorrendo.getDireito());
		}
	}

	public void inserir(int elemento) {

		try{
			this.inserirRecursivamente(elemento, this.raiz);
		}
		catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		/*Nodo percorrendo = this.raiz;
		}

		if (elemento == percorrendo.getConteudo()){
			new IllegalArgumentException("Elemento ja existente! Exce��o: ");
		}
		else{
			if (elemento < percorrendo.getConteudo()){
				if (percorrendo.getEsquerdo() == null){
					percorrendo.setEsquerdo(new Nodo(elemento));
				}
				else{
					percorrendo = percorrendo.getEsquerdo();
				}
			}
			else{
				if (elemento > percorrendo.getConteudo()){
					if (percorrendo.getDireito() == null){

					}
				}

			}
		}*/
	}

	private void inserirRecursivamente(int elemento, Nodo percorrendo) {
		if (elemento == percorrendo.getConteudo()){
			throw new IllegalArgumentException("Elemento ja existente!");
		}
		else{
			if (elemento < percorrendo.getConteudo()){
				if (percorrendo.getEsquerdo() == null){
					percorrendo.setEsquerdo(new Nodo(elemento));
				}
				else{
					this.inserirRecursivamente(elemento, percorrendo.getEsquerdo());
				}
			}
			else{
				if (elemento > percorrendo.getConteudo()){
					if (percorrendo.getDireito() == null){
						percorrendo.setDireito(new Nodo(elemento));
					}
				}
				else{
					this.inserirRecursivamente(elemento, percorrendo.getDireito());
				}
			}
		}
	}

	public void excluir(int elemento) {
		this.excluirRecursivamente(elemento, this.raiz);
	}

	private void excluirRecursivamente(int elemento, Nodo percorrendo) {
		if (elemento == percorrendo.getConteudo()){
			//� folha?
			if ( percorrendo.getEsquerdo() == null && percorrendo.getDireito() == null){
				percorrendo = null;
			}
			//um filho
			if (percorrendo.getEsquerdo() != null ^ percorrendo.getDireito() != null){
				if (percorrendo.getEsquerdo() != null) {
					percorrendo = percorrendo.getEsquerdo();
				}
				else{
					percorrendo = percorrendo.getDireito();
				}
			}
			//dois filhos - substituindo por mais a direita da subarvore a esquerda
			if (percorrendo.getEsquerdo() != null && percorrendo.getDireito() != null){
				if (percorrendo.getEsquerdo().getDireito() == null) {
					//sobe subarvore da esquerda
					percorrendo.getEsquerdo().setDireito(percorrendo.getDireito());
					percorrendo= percorrendo.getEsquerdo();
				}
				else{
				Nodo maisaDireita = this.encontrarMaisADireitaRecursivamente(percorrendo.getEsquerdo());
				try{
					maisaDireita.setEsquerdo(percorrendo.getEsquerdo());
					maisaDireita.setDireito(percorrendo.getDireito());

					percorrendo = maisaDireita;
					
					maisaDireita = this.encontrarMaisADireitaRecursivamente(percorrendo.getEsquerdo());
					maisaDireita = null;
				}
				catch (NullPointerException e){
					System.out.println(e.getMessage());
				}
				}
			}
		}
		else{
			if (elemento < percorrendo.getConteudo()){
				if (percorrendo.getEsquerdo() == null){
					percorrendo.setEsquerdo(new Nodo(elemento));
				}
				else{
					this.excluirRecursivamente(elemento, percorrendo.getEsquerdo());
				}
			}
			else{
				if (elemento > percorrendo.getConteudo()){
					if (percorrendo.getDireito() == null){
						percorrendo.setDireito(new Nodo(elemento));
					}
				}
				else{
					this.excluirRecursivamente(elemento, percorrendo.getDireito());
				}
			}
		}


	}

	private Nodo encontrarMaisADireitaRecursivamente(Nodo percorrendo) {
		if (percorrendo.getDireito() == null){
			return percorrendo;
		}
		else{
			this.encontrarMaisADireitaRecursivamente(percorrendo.getDireito());
		}
		return null;
	}

	public void pesquisar(int elemento) {
		try {
		this.pesquisarRecursivamente(elemento, this.raiz);
		}
		catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
	}

	private Nodo pesquisarRecursivamente(int elemento, Nodo percorrendo) {
		if (percorrendo.getConteudo() == elemento){
			return percorrendo;
		}
		if ( percorrendo.getEsquerdo() != null){
			this.pesquisarRecursivamente(elemento, percorrendo.getEsquerdo());
		}
		if ( percorrendo.getDireito() != null){
			this.pesquisarRecursivamente(elemento, percorrendo.getDireito());
		}
		return null;
	}
}
