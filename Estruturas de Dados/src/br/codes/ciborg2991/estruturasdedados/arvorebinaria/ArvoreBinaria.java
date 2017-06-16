package br.codes.ciborg2991.estruturasdedados.arvorebinaria;

public class ArvoreBinaria {
	private Nodo raiz;

	public ArvoreBinaria(int raiz) {
		this.raiz = new Nodo(raiz);
	}

	public void exibirPreOrdem() {
		this.exibirPreOrdemRecursivamente(this.raiz);
	}

	private void exibirPreOrdemRecursivamente(Nodo percorrendo) {
		System.out.println("Nodo: " + percorrendo.getConteudo());

		if ( percorrendo.getEsquerdo() != null){
			this.exibirPreOrdemRecursivamente(percorrendo.getEsquerdo());
		}
		if ( percorrendo.getDireito() != null){
			this.exibirPreOrdemRecursivamente(percorrendo.getDireito());
		}
	}

	public void exibirEmOrdem() {
		this.exibirEmOrdemRecursivamente(this.raiz);
	}

	private void exibirEmOrdemRecursivamente(Nodo percorrendo) {
		if(percorrendo.getEsquerdo() != null){
			this.exibirEmOrdemRecursivamente(percorrendo.getEsquerdo());
		}
		System.out.println("Nodo: " + percorrendo.getConteudo());
		if (percorrendo.getDireito() != null) {
			this.exibirEmOrdemRecursivamente(percorrendo.getDireito());
		}
	}

	public void exibirPosOrdem() {
		this.exibirPosOrdemRecursivamente(this.raiz);
	}

	private void exibirPosOrdemRecursivamente(Nodo percorrendo) {
		if (percorrendo.getEsquerdo() != null) {
			this.exibirPosOrdemRecursivamente(percorrendo.getEsquerdo());
		}
		if (percorrendo.getDireito() != null) {
			this.exibirPosOrdemRecursivamente(percorrendo.getDireito());
		}
		System.out.println("Nodo: " + percorrendo.getConteudo());
	}

	public void inserir(int elemento) {

		try{
			this.inserirRecursivamente(elemento, this.raiz);
		}
		catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
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
					else{
						this.inserirRecursivamente(elemento, percorrendo.getDireito());
					}
				}
			}
		}
	}

	public void balancear() {
		if (!this.ehBalanceada()){
			System.out.println(this.ehBalanceada());
			this.balacearRecursivamente(this.raiz);
		}
		else{
			System.out.println(this.ehBalanceada());
		}
	}

	private void balacearRecursivamente(Nodo percorrendo) {
		//		percorre recursivamende esquerda
		//		direita
		//		verifica balanceamaento da subarvore
		//		se  mesmo sentido, simples de acordo com sinal
		//		senão, dupla, de acordo tb


	}

	private boolean ehBalanceada() {
		if (!ehVazia()){
			if ((this.alturaSubEsquerda(this.raiz) - this.alturaSubDireita(this.raiz)) >= -1 
					&& (this.alturaSubEsquerda(this.raiz) - this.alturaSubDireita(this.raiz)) <=1 ) {
				return true;
			}
		}
		return false;
	}

	private int alturaSubDireita(Nodo percorrendo) {
		int contAltura=1;
		if (percorrendo.getDireito() != null){
			contAltura += this.alturaSubDireita(percorrendo.getDireito());
		}
		else {
			return 0;
		}
		return contAltura;
	}

	private int alturaSubEsquerda(Nodo percorrendo) {
		int contAltura=1;
		if (percorrendo.getEsquerdo() != null) {
			contAltura += this.alturaSubEsquerda(percorrendo.getEsquerdo());
		}
		else {
			return 0;
		}
		return contAltura;
	}

	private boolean ehVazia() {
		return this.raiz == null;
	}

	public void excluir(int elemento) {
		this.excluirRecursivamente(elemento, this.raiz);
	}

	private void excluirRecursivamente(int elemento, Nodo percorrendo) {
		if (elemento == percorrendo.getConteudo()){
			//é folha?
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
