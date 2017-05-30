package br.codes.clebermacieski.estruturasdedados.arvorebinaria;

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
				}
				else{
					this.inserirRecursivamente(elemento, percorrendo.getDireito());
				}
			}
		}
	}
}
