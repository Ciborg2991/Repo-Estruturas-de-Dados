package br.codes.clebermacieski.estruturasdedados.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Model concreto que mostra estruturas e a�oes dispon�veis no model.
 * Ele comp�e o padr�o Observer sendo um observer da classe observable EstruturasDeDados.
 *
 * @author Cl�ber Macieski
 */
public class GUIInterfaceTextual extends ViewEstruturas{
    private BufferedReader leitorAmortecido;

	GUIInterfaceTextual(EstruturasDeDados estruturas, ControllerEstruturasdeDados estrategia){
		super(estruturas, estrategia);
		this.leitorAmortecido= new BufferedReader(new InputStreamReader(System.in));
		//TODO: mostrar estruturas de dados disponives de maneira dinamica
	}

	@Override
	public void pedirOpcaodeEstrutura() {
		this.controller.exibirInterfaceEspecifica(pegarOpcaoEstrutura());
	}

	private int pegarOpcaoEstrutura() {
		int opcao = 0;
		do{
			try{
				this.mostraOpcoes();
				opcao = Integer.parseInt(leitorAmortecido.readLine());
				return opcao;
			}
			catch (IOException e) {
				System.out.println("Erro no tipo dado como op��o digitado, tente novamente! Exce��o: "+ e);
			}
		} while (true);
	}

	private void mostraOpcoes() {
		System.out.println("=====Estruturas de Dados=====\n"
				+"=====Escolha um tipo de estrutura para realizar opera��es:======\n"
				+ "1 - Pilha\n"
				+ "2 - Fila\n"
				+ "3 - Lista Simplemente Encadeada\n"
				+ "4 - Lista Duplamente Encadeada\n"
				+ "5 - Lista Circular\n"
				+ "6 - �rvore Bin�ria\n"
				+ "0 - Sair"
				);
	}

}
