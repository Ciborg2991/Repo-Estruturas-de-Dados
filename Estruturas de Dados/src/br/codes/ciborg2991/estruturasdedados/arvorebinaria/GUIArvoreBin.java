package br.codes.ciborg2991.estruturasdedados.arvorebinaria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GUIArvoreBin {
	private Scanner teclado;
	
	public GUIArvoreBin(){
		this.teclado = new Scanner(System.in);
	}
	
	public int pedirRaiz() throws InputMismatchException {
		System.out.println("Inicializando a árvore binária!\nDigite a raiz");
		return this.teclado.nextInt();
	}

	public int exibirOpcoes() {
		System.out.println("Digite a opção desejada:\n"
				+ "1- Exibir árvore\n"
				+ "2- Inserir na árvore\n"
				+ "3- Pesquisar na árvore\n"
				+ "4- Deletar elemento da árvore\n"
				+ "0- Sair");
		return this.teclado.nextInt();
	}

	public int pedirElemento() {
		System.out.println("Digite o elemento a inserir na árvore: ");
		return this.teclado.nextInt();
	}

	public int pedirTipodeExibicao() {
		System.out.println("Digite a opções de exibição desejada:\n"
				+ "1 - Pré-Ordem\n"
				+ "2 - Em-Ordem\n"
				+ "3 - Pós-Ordem");
		return this.teclado.nextInt();
	}
}
