package br.codes.clebermacieski.estruturasdedados;

import br.codes.clebermacieski.estruturasdedados.principal.EstruturasDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.InterfacePrincipalController;

public class Main {

	public static void main(String[] args) {
        new InterfacePrincipalController(new EstruturasDeDados());
		System.exit(0);
	}

}