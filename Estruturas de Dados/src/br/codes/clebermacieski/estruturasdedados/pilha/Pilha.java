package br.codes.clebermacieski.estruturasdedados.pilha;

public class Pilha {
	private final int TAMANHO;
	private int [] vetor;
	private int indice;

	public Pilha(int tamanho){
		this.TAMANHO = tamanho;
		this.vetor= new int[this.TAMANHO];
		this.indice = 0;
	}

	public void push(int valor) throws ArrayIndexOutOfBoundsException{
		this.vetor[this.indice]= valor;
		this.indice++;
	}
	
	public int top(){
		return this.vetor[this.indice-1];
	}

	public int pop() throws ArrayIndexOutOfBoundsException {
			int aux = this.vetor[this.indice-1];
			this.vetor[this.indice-1]= 0;
			this.indice--;
			return aux;
	}
	
	public void clear(){
		if(!this.isEmpty()){
			for (int i = 0; i < this.indice; i++) {
				this.vetor[i] = 0;
			}
			this.indice= 0;
		}
	}

	public int getTamanhoAtual(){
		return this.indice;
	}

	public boolean isEmpty(){
		if (this.indice == 0){
			return true;
		}
		return false;
	}

	public int getTAMANHO() {
		return TAMANHO;
	}

}
