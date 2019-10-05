package br.codes.clebermacieski.estruturasdedados;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.controller.EstruturasdeDadosController;

/**
 * Projeto que implementa estruturas de dados simples e utiliza padr�es para permitir o acoplamento
 * de novas estruturas mais facilmente.
 * @author Cl�ber Macieski
 */
public class Main {

	public static void main(String[] args) {
        new EstruturasdeDadosController(new ColecaoEstruturaDeDados());
		System.exit(0);
	}
}