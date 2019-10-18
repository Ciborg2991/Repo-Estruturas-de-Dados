package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.fila;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.Operacao;

public class Fila extends EstruturaDeDados {
	private int[] fila;
	private int posIni;
	private int posfim;
	private int tamanho;

	public Fila() {
	}

	public Fila(int tamanho) {
		// Cria um arranjo para a fila
		this.fila =new int[tamanho];
		this.posIni = 0;
		this.posfim = -1;
		this.tamanho= tamanho;
	}

	@Operacao(posicao = 0, nome = "Enfileirar elemento")
	public void enfileirar(int read) {
		// Adiciona um elemento na fila se não estiver cheia
		if(this.tamanho > (this.posfim - 1)){
			this.posfim++;
			this.fila[this.posfim]= read;
		}
		else{
			System.out.println("Fila cheia!");
		}

	}

	private int tamanhoFila() {
		/*
		 * se inicio menor que fim: conto do inicio ao fim
		 * se fim menor que inicio: conto do inicio a length e de 0 ao fim
		 */
		int cont = 0;

		if (this.posIni == this.posfim){
			return 1;
		}else{
			if (this.posIni < this.posfim){
				for (int i = this.posIni; i <= this.posfim; i++) { // conta do inicio ao fim
					cont++;
				}
			}else{
				if (this.posfim < this.posIni){
					for (int i = this.posIni; i < this.tamanho; i++) {//conta do inicio ao tamanho
						cont++;
					}
					for (int i = 0; i <= this.posfim; i++) { //conta do 0 ao fim
						cont++;
					}
				}
			}
		}
		return cont;
	}

	@Operacao(posicao = 2, nome ="Desenfileirar elemento")
	public int desenfileirar() {
		// Desenfileira um elemento
		int temp = this.fila[this.posIni];
		this.fila[this.posIni] = 0;

		if (this.posIni < this.tamanho){
			this.posIni++;
		}else{
			if (this.posIni == this.tamanho){
				this.posIni= 0;
			}
		}
		return temp;
	}

	@Operacao(posicao = 1, nome="Exibir fila")
	public void exibirFila() {
		// Printa a fila

		if (this.posIni == this.posfim){
			System.out.println(this.fila[this.posIni]);
		}else{
			if (this.posIni < this.posfim){
				for (int i = this.posIni; i <= this.posfim; i++) { // mostra do inicio ao fim
					System.out.print(this.fila[i]+" ");
				}
			}else{
				if (this.posfim < this.posIni){
					for (int i = this.posIni; i < this.tamanho; i++) {//conta do inicio ao tamanho
						System.out.print(this.fila[i]+" ");
					}
					for (int i = 0; i <= this.posfim; i++) { //conta do 0 ao fim
						System.out.print(this.fila[i]+" ");
					}
				}
			}
		}
		System.out.print("\n");
	}

	@Operacao(posicao = 3, nome = "Limpar fila")
	public void limpar() {
		this.posIni = 0;
		this.posfim = -1;
		this.fila =new int[tamanho];
	}

}
