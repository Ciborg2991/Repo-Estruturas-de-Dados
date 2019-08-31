package br.codes.clebermacieski.estruturasdedados.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUIInterfaceTextual implements Apresentavel{
    private final InterfacePrincipalController controller;
    private BufferedReader leitorAmortecido;
    private static final int TENT_MAX = 3;
    private static final int ERRO = -1;

	GUIInterfaceTextual(EstruturasDeDados estruturas, InterfacePrincipalController interfacePrincipalController){
		this.controller = interfacePrincipalController;
		this.leitorAmortecido= new BufferedReader(new InputStreamReader(System.in));
		//TODO: mostrar estruturas de dados disponives de maneira dinamica
	}

	private int iniciar() {
	    int opcao = ERRO;
		for(int i=0; i < TENT_MAX; i++){
			try{
				opcao = this.iniciarInterfaceTextual();
				break;
			}
			catch (IOException e) {
				System.out.println("Erro no tipo dado como opção digitado, tente novamente! Exceção: "+ e);
			}
		}

		return opcao;
	}

	private int iniciarInterfaceTextual() throws IOException{
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
		
		return Integer.parseInt(leitorAmortecido.readLine());
	}

    @Override
    public void pedirOpcaodeEstrutura() {
        this.controller.selecionarEstrutura(iniciar());
    }

}
