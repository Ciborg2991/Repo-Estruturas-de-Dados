package br.codes.clebermacieski.estruturasdedados;

import br.codes.clebermacieski.estruturasdedados.principal.model.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.controller.EstruturasdeDadosController;

public class Main {

	public static void main(String[] args) {
        new EstruturasdeDadosController(new ColecaoEstruturaDeDados());
		System.exit(0);
	}

}