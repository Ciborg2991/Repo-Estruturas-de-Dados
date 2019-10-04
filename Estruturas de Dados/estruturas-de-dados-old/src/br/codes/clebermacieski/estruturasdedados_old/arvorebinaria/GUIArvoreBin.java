package br.codes.clebermacieski.estruturasdedados_old.arvorebinaria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GUIArvoreBin {
	private Scanner teclado;
	
	public GUIArvoreBin(){
		this.teclado = new Scanner(System.in);
	}
	
	public int pedirRaiz() throws InputMismatchException {
		System.out.println("Inicializando a �rvore bin�ria!\nDigite a raiz");
		return this.teclado.nextInt();
	}

	public int exibirOpcoes() {
		System.out.println("Digite a op��o desejada:\n"
				+ "1- Exibir �rvore\n"
				+ "2- Pesquisar na �rvore\n"
				+ "3- Inserir na �rvore\n"
				+ "4- Balancear �rvore\n"
				+ "5- Deletar elemento da �rvore\n"
				+ "0- Sair");
		return this.teclado.nextInt();
	}

	public int pedirElemento() {
		System.out.println("Digite o elemento: ");
		return this.teclado.nextInt();
	}

	public int pedirTipodeExibicao() {
		System.out.println("Digite a op��es de exibi��o desejada:\n"
				+ "1 - Pr�-Ordem\n"
				+ "2 - Em-Ordem\n"
				+ "3 - P�s-Ordem");
		return this.teclado.nextInt();
	}
}
