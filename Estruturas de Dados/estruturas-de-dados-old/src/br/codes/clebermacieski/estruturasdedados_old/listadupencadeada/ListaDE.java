package br.codes.clebermacieski.estruturasdedados_old.listadupencadeada;

public class ListaDE {
	Nodo primeiro;
	Nodo ultimo;

	public ListaDE() {
		this.primeiro = null;
		this.ultimo = null;
	}

	public ListaDE(int primeiroDado){
		Nodo nodo= new Nodo(null, primeiroDado, null);
		this.ultimo= null;
		this.primeiro= nodo;
	}

	public void adicionarNoInicio(int i) {
		// Add nodo no começo
		if(this.primeiro == null){
			this.primeiro = new Nodo(null,i,null);
			this.ultimo = this.primeiro;
		}
		else{
			Nodo antigo = this.primeiro;
			this.primeiro= new Nodo(null,i,this.primeiro);
			antigo.setAnterior(this.primeiro);
		}
	}

	public void adicionarNoFim(int i) {
		// Adiciona no fim manipulando referencia do ultimo, do ultimo nodo

		if (this.primeiro == null) {
			this.adicionarNoInicio(i);
		}
		else{
			Nodo antigo = this.ultimo;
			this.ultimo = new Nodo (this.ultimo,i,null);
			antigo.setProximo(this.ultimo);
		}
	}

	public void imprimir() {
		// Imprime do inicio ao fim
		Nodo percorrendo = this.primeiro;
		if(percorrendo !=null){
			System.out.print("Primeiro: ");
			while (percorrendo != null){				
				System.out.print(percorrendo.getConteudo());
				percorrendo= percorrendo.getProximo();
				System.out.print(" = ");
			}
			System.out.println();
		}
		else{
			System.out.println("Lista Vazia");
		}

	}

	public boolean ehvazia() {
		// Verifica o primeiro
		if(this.primeiro != null) return false;
		return true;
	}

	public Nodo buscar(int i) {
		// Busca pelo conteudo
		Nodo percorrendo = this.primeiro;

		while (percorrendo != null && percorrendo.getConteudo() != i){
			percorrendo = percorrendo.getProximo();
		}		
		return percorrendo;
	}

	public boolean extrair(int i) {
		// Extrai pesquisando pelo conteudo
		Nodo percorrendo = this.primeiro;
		if(percorrendo != null){
			if(percorrendo.getConteudo() == i) {
				if (percorrendo.getProximo() != null) {percorrendo.getProximo().setAnterior(percorrendo.getAnterior());}
				if (percorrendo.getAnterior() != null) {percorrendo.getAnterior().setProximo(percorrendo.getProximo());}
				return true;
			}
		}
		else{
			return false;
		}
		while (percorrendo.getProximo() != null){
			percorrendo = percorrendo.getProximo();
			if (percorrendo.getConteudo() == i) {
				if (percorrendo.getProximo() != null) {percorrendo.getProximo().setAnterior(percorrendo.getAnterior());}
				if (percorrendo.getAnterior() != null) {percorrendo.getAnterior().setProximo(percorrendo.getProximo());}
				return true;
			}
		}
		return false;
	}

	public void retiraFim() {
		// Substitui fim pelo anterior, se houver
		if (this.ultimo != null) {
			this.ultimo= this.ultimo.getAnterior();
		}

	}

	public void eliminaInicio() {
		// Substitui inicio pelo próximo, se houver inicio
		if (this.primeiro != null) {
			this.primeiro = this.primeiro.getProximo();
		}
	}
}
