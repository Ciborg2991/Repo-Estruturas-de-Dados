package br.codes.ciborg2991.estruturasdedados.arvorebinaria;

public class ArvoreBinaria {
	private Nodo raiz;

	public ArvoreBinaria(int raiz) {
		this.raiz = new Nodo(raiz);
	}

	public void exibirPreOrdem() {
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
		/*Nodo percorrendo = this.raiz;
		}

		if (elemento == percorrendo.getConteudo()){
			new IllegalArgumentException("Elemento ja existente! Exceção: ");
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
}
