package br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_arvore_binaria;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.CLIEstrutura;

public class CLIArvoreBinaria extends CLIEstrutura {
    public CLIArvoreBinaria(EstruturaDeDados estrutura) {
        super(estrutura);
    }

    public void pedirRaiz() {
        System.out.println("Inicializando árvore. Digite a raíz:");
    }
}
