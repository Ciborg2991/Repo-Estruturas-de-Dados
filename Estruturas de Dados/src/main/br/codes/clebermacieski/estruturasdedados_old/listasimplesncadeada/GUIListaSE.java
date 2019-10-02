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
		System.out.println("Digite a op��o desejada:\n"
				+ "1- Exibir lista\n"
				+ "2- Inserir na lista\n"
				+ "3- Pesquisar na lista\n"
				+ "4- Deletar elemento da lista\n"
				+ "0- Sair");
		return this.teclado.nextInt();
	}

	public int exibirOpcoesInsercao() {
		System.out.println("Digite a op��o desejada:\n"
				+ "1- Inserir no in�cio\n"
				+ "2 - Inserir no fim\n"
				+ "3- Inserir ap�s elemento espec�fico\n"
				+ "4- Inserir ap�s posi��o"
				);
		return this.teclado.nextInt();
	}

	public String pedirElementoReferencia() {
		System.out.println("Digite o conteudo do elemento de refer�ncia: ");
		return this.teclado.nextLine();
	}

	public int pedirPosicao() {
		System.out.println("Insforme a posi��o num�rica onde devera ser colocado o novo elemento: ");
		return this.teclado.nextInt();
	}

	public void avaliarPesquisa(int pesquisar) {
		if (pesquisar != 0){
			System.out.println("Pesquisa encontrou elemento na posi��o: "+pesquisar+".");
		}
		else{
			System.out.println("Pesquisa n�o encontrou o elemento.");
		}
	}
}
