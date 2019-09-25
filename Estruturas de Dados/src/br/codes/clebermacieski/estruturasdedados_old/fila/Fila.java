package br.codes.clebermacieski.estruturasdedados_old.fila;

public class Fila {
	int[] fila;
	int posIni;
	int posfim;
	int tamanho;

	public Fila(int i) {
		// Cria um arranjo para a fila
		this.fila =new int[i];
		this.posIni = 0;
		this.posfim = -1;
		this.tamanho= i;
	}

	public void enfileirar(int read) {
		// Adiciona um elemento na fila se não estiver cheia
		if(this.tamanhoFila() != this.tamanho){
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
	}

	public void limpar() {
		// Só reseta os indices
		this.posIni = 0;
		this.fila[this.posIni] = 0;
		this.posfim = -1;
		this.fila[this.posfim] = 0;
	}

}
