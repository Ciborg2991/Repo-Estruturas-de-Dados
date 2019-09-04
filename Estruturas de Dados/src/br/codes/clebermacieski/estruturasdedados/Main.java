package br.codes.clebermacieski.estruturasdedados;

import br.codes.clebermacieski.estruturasdedados.principal.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.EstruturasdeDadosController;

public class Main {

	public static void main(String[] args) {
        new EstruturasdeDadosController(new ColecaoEstruturaDeDados());
		System.exit(0);
	}

}