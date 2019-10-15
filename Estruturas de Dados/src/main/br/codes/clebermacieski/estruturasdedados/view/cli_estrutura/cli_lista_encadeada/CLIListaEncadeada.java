package br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_lista_encadeada;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.CLIEstrutura;

import java.io.IOException;

public class CLIListaEncadeada extends CLIEstrutura {
    public CLIListaEncadeada(EstruturaDeDados estrutura) {
        super(estrutura);
    }

    public void pedirElemento() {
        System.out.println("Digite o elemento:");
    }

    public void pedirElementoReferencia() {
        System.out.println("Digite o elemento referência:");
    }

    public void pedirPosicao() {
        System.out.println("Digite a posição:");
    }
}
