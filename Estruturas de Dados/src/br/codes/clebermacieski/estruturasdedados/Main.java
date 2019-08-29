package br.codes.clebermacieski.estruturasdedados;

import br.codes.clebermacieski.estruturasdedados.principal.EstruturasDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.GUIInterfaceTextual;
import br.codes.clebermacieski.estruturasdedados.principal.InterfacePrincipalController;

public class Main {

	public static void main(String[] args) {
        var estruturas = new EstruturasDeDados();
        var controllerEstruturas = new InterfacePrincipalController(estruturas);
		System.exit(0);
	}

}