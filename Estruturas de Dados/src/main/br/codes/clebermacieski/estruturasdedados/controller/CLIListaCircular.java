package br.codes.clebermacieski.estruturasdedados.controller;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.CLIEstrutura;

public class CLIListaCircular extends CLIEstrutura {
    public CLIListaCircular(EstruturaDeDados estrutura) {
        super(estrutura);
    }

    public void pedirElementoReferencia() {
        System.out.println("Digite o elemento refer�ncia:");
    }

    public void pedirPosi��o() {
        System.out.println("Digite a posi��o a realizar inser��o:");
    }
}
