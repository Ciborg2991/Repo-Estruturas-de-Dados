package br.codes.clebermacieski.estruturasdedados.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUIInterfaceTextual {
	private BufferedReader leitorAmortecido;
	private static final int TENT_MAX = 3;
	private int opcaodeEstrutura;

	public GUIInterfaceTextual(){
		this.leitorAmortecido= new BufferedReader(new InputStreamReader(System.in));
	}

	public void iniciar() {
		for(int i=0; i < TENT_MAX; i++){
			try{
				this.iniciarInterfaceTextual();
				break;
			}
			catch (IOException e) {
				System.out.println("Erro no tipo dado como opção digitado, tente novamente! Exceção: "+ e);
			}
		}
	}

	public void iniciarInterfaceTextual() throws IOException{
		System.out.println("=====Estruturas de Dados=====\n"
				+"=====Escolha um tipo de estrutura para realizar operações:======\n"
				+ "1 - Pilha\n"
				+ "2 - Fila\n"
				+ "3 - Lista Simplemente Encadeada\n"
				+ "4 - Lista Duplamente Encadeada\n"
				+ "5 - Lista Circular\n"
				+ "6 - Árvore Binária\n"
				+ "0 - Sair"
				);
		
		this.opcaodeEstrutura = Integer.parseInt(leitorAmortecido.readLine());
	}
	
	public int getOpcaodeEstrutura() {
		return opcaodeEstrutura;
	}
}
