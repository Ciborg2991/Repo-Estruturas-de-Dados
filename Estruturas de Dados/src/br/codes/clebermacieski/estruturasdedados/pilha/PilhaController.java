package br.codes.clebermacieski.estruturasdedados.pilha;

import java.io.IOException;

public class PilhaController {
	private static final int TENT_MAX = 3;
	private GUIPilha guiPilha;
	private Pilha pilha;

	public PilhaController() {
		this.guiPilha = new GUIPilha();
	}

	public void instanciar() {
		try{
			this.instanciarPilha();
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private void instanciarPilha() throws IllegalArgumentException{
		int cont;
		for (cont = 0; cont < TENT_MAX ; cont++){
			try {
				int tamPilha = this.guiPilha.pedirTamanhoPilha();
				if (tamPilha > 0){
					this.pilha = new Pilha(tamPilha);
					break;
				}
				else {
					throw new IllegalArgumentException("Não é possível criar pilha com tamanho menor que 1.");
				}

			}
			catch (NumberFormatException e){
				System.out.println("Erro em conversão do tipo dado como opção! Tente novamente. Exceção: "+ e);
			}
			catch (IOException e){
				System.out.println("Erro no tipo dado como opção! Tente novamente. Exceção: "+ e);
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		if (cont == TENT_MAX){
			throw new IllegalArgumentException("Impossível criar pilha, voltando ao menu anterior.");
		}
	}

	public void verificarOpcaoPilha() {
		int flag = 0;

		do{

			switch (this.iniciarGUIPilha()) {
			case 1:
				this.inserirNaPilha();
				break;
			case 2:
				this.exibirTopoPilha();
				break;
			case 3:
				this.retirarDaPilha();
				break;
			case 4:
				this.limparPilha();
				break;
			case 0:
				flag=1;
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		}while (flag != 1);
	}

	private int iniciarGUIPilha() {
		for (int i = 0; i < TENT_MAX; i++) {
			try{
				return this.guiPilha.iniciarInterfaceTextual();
			}
			catch (IOException e){
				System.out.println("Erro no tipo dado como opção! Tente novamente. Exceção: "+ e);
			}
			catch (NumberFormatException e){
				System.out.println("Erro em conversão do tipo dado como opção! Tente novamente. Exceção: "+ e);
			}
		}
		return -1;
	}

	private void inserirNaPilha() {
		for (int i = 0; i < TENT_MAX; i++) {
			try {
				int elemento = this.guiPilha.pedirElemento();
				this.pilha.push(elemento);
				this.guiPilha.sucesso();
				break;
			}
			catch (IOException e) {
				System.out.println("Erro no tipo dado como opção! Tente novamente. Exceção: "+ e);
			}
			catch (NumberFormatException e){
				System.out.println("Erro em conversão do tipo dado como opção! Tente novamente. Exceção: "+ e);
			}
			catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Pilha cheia!");
				break;
			}
		}
	}
	
	private void exibirTopoPilha() {
		try{
		this.guiPilha.exibirTopo(this.pilha.top());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Pilha sem elementos! Exceção: "+ e);
		}
	}

	private void retirarDaPilha() {
		try {
			this.guiPilha.exibirRetirado(this.pilha.pop());
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Pilha vazia! Exceção: "+ e);
		}
	}

	private void limparPilha() {
		this.pilha.clear();
		this.guiPilha.sucesso();
	}

}

