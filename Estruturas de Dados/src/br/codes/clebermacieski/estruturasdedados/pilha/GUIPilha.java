package br.codes.clebermacieski.estruturasdedados.pilha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUIPilha {
	private BufferedReader leitorAmortecido;

	public GUIPilha () {
		this.leitorAmortecido = new BufferedReader(new InputStreamReader(System.in));
	}

	public int pedirTamanhoPilha() throws NumberFormatException, IOException {
		System.out.println("Digite o tamanho desejado da Pilha:");
		int tamanhoPilha = Integer.parseInt(this.leitorAmortecido.readLine());
		return tamanhoPilha;
	}

	public int iniciarInterfaceTextual() throws IOException {
		System.out.println("===== Menu Pilha; =====\n"
				+ "1 - Inserir na pilha\n"
				+ "2 - Exibir topo da pilha\n"
				+ "3 - Retirar topo da pilha\n"
				+ "4 - Limpa a pilha\n"
				+ "0 - Voltar");

		return Integer.parseInt(this.leitorAmortecido.readLine());
	}

	public int pedirElemento() throws NumberFormatException, IOException {
		System.out.println("Digite o elemento a ser inserido na pilha: ");
		return Integer.parseInt(this.leitorAmortecido.readLine());
	}

	public void sucesso() {
		System.out.println("Operação efetuada com sucesso!");
	}

	public void exibirTopo(int top) {
		System.out.println("Elemento do topo da pilha: "+ top);		
	}

	public void exibirRetirado(int pop) {
		System.out.println("Elemento retirado da pilha: "+ pop);				
	}
}
