package br.codes.clebermacieski.estruturasdedados_old.listacircular;

public class ListaCircular {

	Nodo inicio;

	public ListaCircular(){
		this.inicio = null;
	}

	public void inserirNoInicio(String conteudo) {
		Nodo novo= new Nodo(conteudo, null);

		if(this.ehVazia()){
			this.inicio = novo;
			this.inicio.setProximo(this.inicio);
		}else{
			novo.setProximo(this.inicio);
			this.inicio=novo;
			this.alteraUltimoProximo(this.inicio.getProximo());
		}		
	}

	public void alteraUltimoProximo(Nodo inicioAntigo) {
		Nodo percorrer = this.inicio;

		while(percorrer != this.inicio){
			if(percorrer.getProximo() == inicioAntigo){
				percorrer.setProximo(this.inicio);
			}
			percorrer = percorrer.getProximo();
		}

	}

	public void inserirNoFim(String conteudo){

		if (ehVazia()){ //Lista ainda vazia, inserir substituindo o primeiro nulo
			inserirNoInicio(conteudo);
		}
		else{ //Lista tem elementos, então busca o ultimo e insere depois
			Nodo percorrendo= this.inicio;

			while (percorrendo.getProximo() != this.inicio){
				percorrendo = percorrendo.getProximo();
			}
			percorrendo.setProximo(new Nodo(conteudo , this.inicio));
		}
	}

	public boolean insereApos (String elemento, String novoConteudo){
		Nodo percorrendo = this.inicio;

		do{
			if (percorrendo.getConteudo().equals(elemento)){
				percorrendo.setProximo(new Nodo(novoConteudo, percorrendo.getProximo()));
				return true;
			}
			percorrendo= percorrendo.getProximo();
		}while (percorrendo != this.inicio);
		return false;
	}

	public boolean inserirNaPos(int posicao, String conteudo) {
		// Insere especificamente na posição, a parti de 0
		Nodo percorrendo = this.inicio;
		int cont = -1;

		if (percorrendo != null){
			cont++;
			if (cont == posicao){
				//insere aqui e será o inicio
				inserirNoInicio(conteudo);
				return true;
			}
			else{
				percorrendo= percorrendo.getProximo();
				cont++;
				do{
					if (cont == posicao){
						percorrendo = new Nodo(conteudo, percorrendo.getProximo());
						return true;
					}
					percorrendo = percorrendo.getProximo();
					cont++;
				} while (percorrendo != this.inicio);
			}
		}
		return false;
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
		Nodo percorrer = this.inicio;

		while(percorrer.getProximo().getProximo() != this.inicio){
			percorrer = percorrer.getProximo();
		}
		percorrer.setProximo(this.inicio);
		return true;
	}

	public void imprimir() {
		// Printa os conteudos
		Nodo percorrer = this.inicio;

		while(percorrer.getProximo() != this.inicio){
			System.out.println(percorrer.getConteudo());
			percorrer = percorrer.getProximo();
		}
	}

	public boolean ehVazia() {
		// Verifica se o inicio é nulo
		return this.inicio == null;
	}
}
