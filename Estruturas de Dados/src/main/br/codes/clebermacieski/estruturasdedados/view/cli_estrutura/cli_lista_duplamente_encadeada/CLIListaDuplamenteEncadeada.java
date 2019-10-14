package br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_lista_duplamente_encadeada;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.CLIEstrutura;

public class CLIListaDuplamenteEncadeada extends CLIEstrutura {
    public CLIListaDuplamenteEncadeada(EstruturaDeDados estrutura) {
        super(estrutura);
    }

    public void pedirElemento() {
        System.out.println("Digite o elemento:");
    }
}
