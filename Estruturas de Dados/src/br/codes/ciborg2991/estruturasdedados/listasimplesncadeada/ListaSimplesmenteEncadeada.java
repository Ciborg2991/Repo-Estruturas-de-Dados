package br.codes.ciborg2991.estruturasdedados.listasimplesncadeada;

public class ListaSimplesmenteEncadeada {
	private Nodo inicio;

	public ListaSimplesmenteEncadeada(){
		this.inicio = null;
	}

	public void inserirNoInicio(String conteudo) {
		if (this.ehVazia()){
			this.inicio = new Nodo(conteudo, null);
		}
		else{
			this.inicio = new Nodo(conteudo, this.inicio);
		}
	}

	protected void inserirNoFim(String conteudo){

		if (ehVazia()){ //Lista ainda vazia, inserir substituindo o primeiro nulo
			inserirNoInicio(conteudo);
		}
		else{ //Lista tem elementos, então busca o ultimo e insere depois
			Nodo percorrendo= this.inicio;
			while (this.temProximo(percorrendo)){
				percorrendo = percorrendo.getProximo();
			}
			percorrendo.setProximo(new Nodo(conteudo , null));
		}
	}

	protected void insereApos (String elemento, String novoConteudo){
		Nodo percorrendo = this.inicio;

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
		Nodo percorrendo = this.inicio;
		int cont = -1;

		if (percorrendo != null){
			cont++;
			if (cont == posicao){
				//insere aqui e será o inicio
				this.inicio = new Nodo(conteudo, this.inicio.getProximo());
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
		if (this.inicio != null){
			if (this.inicio.getProximo() != null){
				this.inicio = this.inicio.getProximo();
			}
			else{
				this.inicio = null;
			}
			return true;
		}
		else{
			return false;
		}
	}

	public boolean removerOFim() {
		// Nula o fim da lista
		Nodo percorrer = this.inicio;
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
		Nodo percorrer = this.inicio;

		if(!this.ehVazia()){
			while (percorrer.getProximo() != null){
				System.out.println(percorrer.getConteudo());
				percorrer = percorrer.getProximo();
			}
		}
	}

	private boolean ehVazia() {
		// Verifica se o inicio é nulo
		return this.inicio == null;
	}

	private boolean temProximo(Nodo nodo){
		return nodo.getProximo() != null;
	}

	public int pesquisar(String elemento) {
		Nodo percorrendo = this.inicio;
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
		Nodo percorrendo = this.inicio;
		
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