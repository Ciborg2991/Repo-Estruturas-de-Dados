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

	GUIInterfaceTextual(ColecaoEstruturaDeDados estruturas, ControllerEstruturasdeDados estrategia){
		super(estruturas, estrategia);
		leitorAmortecido= new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void pedirOpcaodeEstrutura() {
		controller.exibirInterfaceEspecifica(pegarOpcaoEstrutura());
	}

	private int pegarOpcaoEstrutura() {
		int opcao;
		do{
			try{
				this.mostraOpcoes();
				opcao = Integer.parseInt(leitorAmortecido.readLine());
				//TODO: vincular op��o com ordem do iterator para usar a instancia do objeto correta no controller?
				return opcao;
			}
			catch (IOException e) {
				System.out.println("Erro no tipo dado como op��o digitado, tente novamente! Exce��o: "+ e);
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		} while (true);
	}

	private void mostraOpcoes() throws Exception {
		System.out.println("=====Estruturas de Dados=====\n");
		System.out.println("Selecione uma estrutura:\n");
		int i = 1;
		boolean tinhaElementos = false;

		for (Iterador iterador = estruturas.pegarIterador(); iterador.temProximo(); ){
			tinhaElementos = true;
			System.out.println(i +" - "+ iterador.pegarProximo().toString() );
		}

		if (!tinhaElementos) throw new Exception("N�o h� estruturas dispon�veis.");

		/*
				+"=====Escolha um tipo de estrutura para realizar opera��es:======\n"
				+ "1 - Pilha\n"
				+ "2 - Fila\n"
				+ "3 - Lista Simplemente Encadeada\n"
				+ "4 - Lista Duplamente Encadeada\n"
				+ "5 - Lista Circular\n"
				+ "6 - �rvore Bin�ria\n"
				+ "0 - Sair"
				);*/
	}

}
