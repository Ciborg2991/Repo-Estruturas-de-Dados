package br.codes.clebermacieski.estruturasdedados.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Model concreto que mostra estruturas e açoes disponíveis no model.
 * Ele compõe o padrão Observer sendo um observer da classe observable EstruturasDeDados.
 *
 * @author Cléber Macieski
 */
public class GUIInterfaceTextual extends ViewEstruturas{
    private BufferedReader leitorAmortecido;

	GUIInterfaceTextual(ColecaoEstruturaDeDados estruturas, ControllerEstruturasdeDados estrategia){
		super(estruturas, estrategia);
		this.leitorAmortecido= new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void pedirOpcaodeEstrutura() {
		this.controller.exibirInterfaceEspecifica(pegarOpcaoEstrutura());
	}

	private int pegarOpcaoEstrutura() {
		int opcao;
		do{
			try{
				this.mostraOpcoes();
				opcao = Integer.parseInt(leitorAmortecido.readLine());
				return opcao;
			}
			catch (IOException e) {
				System.out.println("Erro no tipo dado como opção digitado, tente novamente! Exceção: "+ e);
			}
		} while (true);
	}

	private void mostraOpcoes() {
		System.out.println("=====Estruturas de Dados=====\n");
		int i = 1;
		Iterador iterador = super.estruturas.pegarIterador();
		while (iterador.temProximo()){
			System.out.println(i +" - "+ iterador.pegarProximo() );
		}
		/*
				+"=====Escolha um tipo de estrutura para realizar operações:======\n"
				+ "1 - Pilha\n"
				+ "2 - Fila\n"
				+ "3 - Lista Simplemente Encadeada\n"
				+ "4 - Lista Duplamente Encadeada\n"
				+ "5 - Lista Circular\n"
				+ "6 - Árvore Binária\n"
				+ "0 - Sair"
				);*/
	}

}
