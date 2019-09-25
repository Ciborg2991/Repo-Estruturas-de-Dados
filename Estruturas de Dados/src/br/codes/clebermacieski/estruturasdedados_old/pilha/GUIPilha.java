package br.codes.clebermacieski.estruturasdedados_old.pilha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GUIPilha {
	private BufferedReader leitorAmortecido;
	private boolean primeiraVez;

	GUIPilha() {
		this.leitorAmortecido = new BufferedReader(new InputStreamReader(System.in));
		primeiraVez = true;
	}

	int pedirTamanhoPilha() throws NumberFormatException, IOException {
		System.out.println("Digite o tamanho desejado da Pilha:");
		return Integer.parseInt(this.leitorAmortecido.readLine());
	}

	int iniciarInterfaceTextual() throws IOException {
		if (!this.primeiraVez) {
			dormir(1000);
		}
		primeiraVez = false;

		System.out.println("===== Menu Pilha =====\n"
				+ "1 - Inserir na pilha\n"
				+ "2 - Exibir topo da pilha\n"
				+ "3 - Retirar topo da pilha\n"
				+ "4 - Limpa a pilha\n"
				+ "0 - Voltar");

		return Integer.parseInt(this.leitorAmortecido.readLine());
	}

	private void dormir(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	int pedirElemento() throws NumberFormatException, IOException {
		System.out.println("Digite o elemento a ser inserido na pilha: ");
		return Integer.parseInt(this.leitorAmortecido.readLine());
	}

	void sucesso() {
		System.out.println("Operação efetuada com sucesso!");
	}

	void exibirTopo(int top) {
		System.out.println("Elemento do topo da pilha: "+ top);		
	}

	void exibirRetirado(int pop) {
		System.out.println("Elemento retirado da pilha: "+ pop);				
	}
}
