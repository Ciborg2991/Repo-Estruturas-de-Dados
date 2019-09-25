package br.codes.clebermacieski.estruturasdedados_old.listasimplesncadeada;

import java.util.Scanner;

public class GUIListaSE {
	private Scanner teclado;

	public GUIListaSE(){
		this.teclado = new Scanner(System.in); 
	}

	public String pedirElemento() {
		System.out.println("Digite o elemento: ");
		return this.teclado.nextLine();
	}

	public int exibirOpcoes() {
		System.out.println("Digite a opção desejada:\n"
				+ "1- Exibir lista\n"
				+ "2- Inserir na lista\n"
				+ "3- Pesquisar na lista\n"
				+ "4- Deletar elemento da lista\n"
				+ "0- Sair");
		return this.teclado.nextInt();
	}

	public int exibirOpcoesInsercao() {
		System.out.println("Digite a opção desejada:\n"
				+ "1- Inserir no início\n"
				+ "2 - Inserir no fim\n"
				+ "3- Inserir após elemento específico\n"
				+ "4- Inserir após posição"
				);
		return this.teclado.nextInt();
	}

	public String pedirElementoReferencia() {
		System.out.println("Digite o conteudo do elemento de referência: ");
		return this.teclado.nextLine();
	}

	public int pedirPosicao() {
		System.out.println("Insforme a posição numérica onde devera ser colocado o novo elemento: ");
		return this.teclado.nextInt();
	}

	public void avaliarPesquisa(int pesquisar) {
		if (pesquisar != 0){
			System.out.println("Pesquisa encontrou elemento na posição: "+pesquisar+".");
		}
		else{
			System.out.println("Pesquisa não encontrou o elemento.");
		}
	}
}
