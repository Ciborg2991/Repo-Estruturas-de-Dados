package br.codes.ciborg2991.estruturasdedados.listasimplesncadeada;

public class ListaSimplesmenteEncadeada {
	private Nodo nodoInicial;

	public ListaSimplesmenteEncadeada(){
		this.nodoInicial = null;
	}

	public void inserirNoInicio(String conteudo) {
		if (this.ehVazia()){
			this.nodoInicial = new Nodo(conteudo, null);
		}
		else{
			this.nodoInicial = new Nodo(conteudo, this.nodoInicial);
		}
	}

	protected void inserirNoFim(String conteudo){

		if (ehVazia()){ //Lista ainda vazia, inserir substituindo o primeiro nulo
			inserirNoInicio(conteudo);
		}
		else{ //Lista tem elementos, então busca o ultimo e insere depois
			Nodo percorrendo= this.nodoInicial;
			while (this.temProximo(percorrendo)){
				percorrendo = percorrendo.getProximo();
			}
			percorrendo.setProximo(new Nodo(conteudo , null));
		}
	}

	protected void insereApos (String elemento, String novoConteudo){
		Nodo percorrendo = this.nodoInicial;

		while (this.temProximo(percorrendo)){
			if (percorrendo.getConteudo().equals(elemento)){
				if (percorrendo.getProximo() == null){
					inserirNoFim(novoConteudo);	
				}
				else{
					percorrendo.setProximo(new Nodo(novoConteudo, percorrendo.getProximo()));
				}
				break;
			}
			percorrendo= percorrendo.getProximo();
		}
	}

	public void inserirNaPos(int posicao, String conteudo) {
		// Insere especificamente na posição, a parti de 0
		Nodo percorrendo = this.nodoInicial;
		int cont = -1;

		if (percorrendo != null){
			cont++;
			if (cont == posicao){
				//insere aqui e será o inicio
				this.nodoInicial = new Nodo(conteudo, this.nodoInicial.getProximo());
			}
			else{
				while (temProximo(percorrendo)){
					percorrendo = percorrendo.getProximo();
					cont++;
					if (cont == posicao){
						percorrendo = new Nodo(conteudo, percorrendo.getProximo());
					}
				}
			}
		}
	}

	public boolean removerOInicio() {
		// Remove o inicio e atualiza com o segundo, se existir
		if (this.nodoInicial != null){
			if (this.nodoInicial.getProximo() != null){
				this.nodoInicial = this.nodoInicial.getProximo();
			}
			else{
				this.nodoInicial = null;
			}
			return true;
		}
		else{
			return false;
		}
	}

	public boolean removerOFim() {
		// Nula o fim da lista
		Nodo percorrer = this.nodoInicial;
		if (percorrer != null){
			while (this.temProximo(percorrer)){
				percorrer = percorrer.getProximo();
			}
			percorrer = null;
			return true;
		}
		return false;
	}

	public void exibir() {
		Nodo percorrer = this.nodoInicial;

		if(!this.ehVazia()){
			do {
				System.out.println(percorrer.getConteudo());
				percorrer = percorrer.getProximo();
			}
			while (percorrer != null);
		}
	}

	private boolean ehVazia() {
		return this.nodoInicial == null;
	}

	private boolean temProximo(Nodo nodo){
		return nodo.getProximo() != null;
	}

	public int pesquisar(String elemento) {
		Nodo percorrendo = this.nodoInicial;
		int cont = 0;
		while (this.temProximo(percorrendo)){
			cont++;
			if (percorrendo.getConteudo().equals(elemento)){
				return cont;
			}
		}
		return 0;
	}

	public int remover(String elemento) {
		Nodo percorrendo = this.nodoInicial;
		
		if (percorrendo.getConteudo().equals(elemento)){
			return 1;
		}
		
		while (temProximo(percorrendo)){
			if (percorrendo.getProximo().getConteudo().equals(elemento)){
				percorrendo.setProximo(percorrendo.getProximo().getProximo());
			}
		}
		return 0;
	}
}