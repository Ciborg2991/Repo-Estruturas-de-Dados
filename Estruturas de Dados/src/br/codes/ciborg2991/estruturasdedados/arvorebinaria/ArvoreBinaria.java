package br.codes.ciborg2991.estruturasdedados.arvorebinaria;

public class ArvoreBinaria {
	private Nodo raiz;

	private enum TiposExclusao {
		FOLHA,DOIS_FILHOS, UNICO_FILHO_A_ESQUERDA, UNICO_FILHO_A_DIREITA, OK
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
		this.excluirRecursivamente2(elemento, this.raiz);
		/*try {
			this.excluirRecursivamente(elemento, this.raiz);
			this.excluirRecursivamente(elemento, this.raiz);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}*/
	}

	private TiposExclusao excluirRecursivamente(int elemento, Nodo percorrendo) {
		//achou?
		if (elemento == percorrendo.getConteudo()){
			//é folha?
			if ( percorrendo.getEsquerdo() == null && percorrendo.getDireito() == null){
				return TiposExclusao.FOLHA;
			}
			else {
				//um filho
				if (percorrendo.getEsquerdo() != null ^ percorrendo.getDireito() != null){
					if (percorrendo.getEsquerdo() != null) {
						return TiposExclusao.UNICO_FILHO_A_ESQUERDA;
					}
					else {
						return TiposExclusao.UNICO_FILHO_A_DIREITA;
					}
				}
				else {
					//dois filhos
					if (percorrendo.getEsquerdo() != null && percorrendo.getDireito() != null){
						return TiposExclusao.DOIS_FILHOS;
					}
				}
			}
		}
		//percorre mais
		if (elemento < percorrendo.getConteudo()){
			if (percorrendo.getEsquerdo() == null){
				throw new IllegalArgumentException("Elemento não encontrado");
			}
			else{
				Nodo excluir = percorrendo.getEsquerdo();
				switch (this.excluirRecursivamente(elemento, excluir)){
				case FOLHA:
					//Só exclui filho (referência)
					percorrendo.setEsquerdo(null);
					break;
				case UNICO_FILHO_A_ESQUERDA:
					//Filho se torna o pai
					this.excluirComSohUmFilhoAEsquerda(percorrendo);
					break;
				case UNICO_FILHO_A_DIREITA:
					this.excluirComSohUmFilhoADireita(percorrendo);
					break;
				case DOIS_FILHOS:
					if (excluir.getEsquerdo().getDireito() == null) {
						//sobe sub-arvore da esquerda
						excluir.setConteudo(excluir.getEsquerdo().getConteudo());
						excluir.setEsquerdo(excluir.getEsquerdo().getEsquerdo());
					}
					else{
						//Substituindo por mais a direita da sub-arvore a esquerda
						Nodo maisADireita = this.encontrarMaisADireitaRecursivamente(excluir.getEsquerdo());

						int aux = excluir.getConteudo();
						excluir.setConteudo(maisADireita.getConteudo());
						maisADireita.setConteudo(aux);
					}
					break;
				default:
					break;
				}
			}
		}
		if (elemento > percorrendo.getConteudo()){
			if (percorrendo.getDireito() == null){
				throw new IllegalArgumentException("Elemento não encontrado");
			}
			else{
				Nodo excluir = percorrendo.getDireito();
				switch (this.excluirRecursivamente(elemento, excluir)){
				case FOLHA:
					//Só exclui filho (referência)
					percorrendo.setDireito(null);
					break;
				case UNICO_FILHO_A_ESQUERDA:
					//Filho se torna o pai
					this.excluirComSohUmFilhoAEsquerda(percorrendo);
					break;
				case UNICO_FILHO_A_DIREITA:
					this.excluirComSohUmFilhoADireita(percorrendo);
					break;
				case DOIS_FILHOS:
					if (excluir.getEsquerdo().getDireito() == null) {
						//sobe sub-arvore da esquerda
						excluir.setConteudo(excluir.getEsquerdo().getConteudo());
						excluir.setEsquerdo(excluir.getEsquerdo().getEsquerdo());
					}
					else{
						//Substituindo por mais a direita da sub-arvore a esquerda
						Nodo maisADireita = this.encontrarMaisADireitaRecursivamente(excluir.getEsquerdo());

						int aux = excluir.getConteudo();
						excluir.setConteudo(maisADireita.getConteudo());
						maisADireita.setConteudo(aux);
					}
					break;
				default:
					break;
				}
			}
		}
		return null;
	}

	private void excluirComSohUmFilhoADireita(Nodo percorrendo) {
		percorrendo.setConteudo(percorrendo.getDireito().getConteudo());
		if (percorrendo.getDireito() != null) {percorrendo.setEsquerdo(percorrendo.getDireito().getEsquerdo());}
		if (percorrendo.getDireito() != null) {percorrendo.setDireito(percorrendo.getDireito().getDireito());}
	}

	private void excluirComSohUmFilhoAEsquerda(Nodo percorrendo) {
		percorrendo.setConteudo(percorrendo.getEsquerdo().getConteudo());
		if (percorrendo.getEsquerdo() != null) {percorrendo.setEsquerdo(percorrendo.getEsquerdo().getEsquerdo());}
		if (percorrendo.getEsquerdo() != null) {percorrendo.setDireito(percorrendo.getEsquerdo().getDireito());}
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

	public TiposExclusao excluirRecursivamente2 (int elemento, Nodo percorrendo) {
		if ( percorrendo.getConteudo() == elemento) {
			if (this.ehFolha(percorrendo)){
				return TiposExclusao.FOLHA;
			}
			if (this.sohUmFilho(percorrendo)) {
				if (percorrendo.getEsquerdo() != null){
					percorrendo = percorrendo.getEsquerdo();
				}
				else{
					percorrendo = percorrendo.getDireito();
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
						antecessor = antecessor.getEsquerdo();
						//se não, exclui de novo
					}
				}

			}
			return TiposExclusao.OK;
		}
		if (percorrendo.getEsquerdo() != null){
			switch (this.excluirRecursivamente2(elemento, percorrendo.getEsquerdo())) {
			case FOLHA:
				percorrendo.setEsquerdo(null);
				break;
			case OK:
				return TiposExclusao.OK;
			default:
				break;

			}
			if (percorrendo.getDireito() != null) {
				switch (this.excluirRecursivamente2(elemento , percorrendo.getDireito())) {
				case FOLHA: 
					percorrendo.setDireito(null);
					break;
				case OK:
					return TiposExclusao.OK;
				default:
					break;

				}
			}
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

