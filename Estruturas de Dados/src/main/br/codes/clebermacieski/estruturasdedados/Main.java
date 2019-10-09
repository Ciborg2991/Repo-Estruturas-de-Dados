package br.codes.clebermacieski.estruturasdedados;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.controller.EstruturasdeDadosController;

/**
 * Projeto que utiliza padrões para permitir o acoplamento de implementações de estruturas de dados.
 * @author Cléber Macieski
 */
public class Main {
	public static void main(String[] args) {
        new EstruturasdeDadosController(new ColecaoEstruturaDeDados());
		System.exit(0);
	}
}