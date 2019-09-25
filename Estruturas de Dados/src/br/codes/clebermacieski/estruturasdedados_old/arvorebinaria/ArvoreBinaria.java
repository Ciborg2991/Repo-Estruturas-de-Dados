package br.codes.clebermacieski.estruturasdedados_old.arvorebinaria;

public class ArvoreBinaria {
	private Nodo raiz;

	private enum TiposExclusao {
		FOLHA,DOIS_FILHOS, UNICO_FILHO_A_ESQUERDA, UNICO_FILHO_A_DIREITA, OK, FIM_SUB_ARV
	}

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
		if (this.excluirRecursivamente(elemento, this.raiz) == TiposExclusao.FOLHA) {
			this.raiz = null;
		};
	}

	public TiposExclusao excluirRecursivamente (int elemento, Nodo percorrendo) {
		if ( percorrendo.getConteudo() == elemento) {
			if (this.ehFolha(percorrendo)){
				return TiposExclusao.FOLHA;
			}
			if (this.sohUmFilho(percorrendo)) {
				if (percorrendo.getEsquerdo() != null){
					Nodo filho = percorrendo.getEsquerdo();
					percorrendo.setConteudo(filho.getConteudo());
					percorrendo.setEsquerdo(filho.getEsquerdo());
					percorrendo.setDireito(filho.getDireito());
				}
				else{
					Nodo filho = percorrendo.getDireito();
					percorrendo.setConteudo(filho.getConteudo());
					percorrendo.setEsquerdo(filho.getEsquerdo());
					percorrendo.setDireito(filho.getDireito());
				}
				return TiposExclusao.OK;
			}
			if (this.doisFilhos(percorrendo)){
				if (percorrendo.getEsquerdo().getDireito() == null){
					percorrendo.getEsquerdo().setDireito(percorrendo.getDireito());
					percorrendo.setConteudo(percorrendo.getEsquerdo().getConteudo());
					if (percorrendo.getEsquerdo().getEsquerdo() != null) {
						percorrendo.setEsquerdo(percorrendo.getEsquerdo().getEsquerdo());
					}
					else {
						percorrendo.setEsquerdo(null);
					}
				}
				else{
					Nodo antecessor = this.encontrarMaisADireitaRecursivamente(percorrendo.getEsquerdo());
					int aux = percorrendo.getConteudo();
					percorrendo.setConteudo(antecessor.getConteudo());
					antecessor.setConteudo(aux);
	
					if (antecessor.getEsquerdo() != null){
						antecessor.setConteudo(antecessor.getEsquerdo().getConteudo());
						if (antecessor.getEsquerdo() != null) {
							antecessor.setEsquerdo(antecessor.getEsquerdo().getEsquerdo());
						}
						if (antecessor.getDireito() !=null) {
							antecessor.setDireito(antecessor.getEsquerdo().getDireito());
						}
					}
				}
	
			}
			return TiposExclusao.OK;
		}
	
		if (percorrendo.getEsquerdo() != null){
			switch (this.excluirRecursivamente(elemento, percorrendo.getEsquerdo())) {
			case FOLHA:
				percorrendo.setEsquerdo(null);
				break;
			case OK:
				//return TiposExclusao.OK;
			default:
				break;
	
			}
		}
	
		if (percorrendo.getDireito() != null) {
			switch (this.excluirRecursivamente(elemento , percorrendo.getDireito())) {
			case FOLHA: 
				percorrendo.setDireito(null);
				break;
			case OK:
				//return TiposExclusao.OK;
			default:
				break;
	
			}
		}
		return TiposExclusao.OK;
	}

	private Nodo encontrarMaisADireitaRecursivamente(Nodo percorrendo) {
		if (percorrendo.getDireito() == null){
			return percorrendo;
		}
		Nodo maisADireita = this.encontrarMaisADireitaRecursivamente(percorrendo.getDireito());
		return maisADireita;
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

	private boolean doisFilhos(Nodo percorrendo) {
		return percorrendo.getEsquerdo() != null && percorrendo.getDireito() != null;
	}

	private boolean sohUmFilho(Nodo percorrendo) {
		return percorrendo.getEsquerdo() != null ^ percorrendo.getDireito() != null;
	}

	private boolean ehFolha(Nodo percorrendo) {
		return percorrendo.getEsquerdo() == null && percorrendo.getDireito() == null;
	}
}

