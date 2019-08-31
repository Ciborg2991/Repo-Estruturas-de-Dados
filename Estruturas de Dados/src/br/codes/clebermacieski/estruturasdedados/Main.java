package br.codes.clebermacieski.estruturasdedados;

import br.codes.clebermacieski.estruturasdedados.principal.EstruturasDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.EstruturasdeDadosController;

public class Main {

	public static void main(String[] args) {
        new EstruturasdeDadosController(new EstruturasDeDados());
		System.exit(0);
	}

}