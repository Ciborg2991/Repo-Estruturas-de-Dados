package br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_pilha;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.CLIEstrutura;

import java.io.IOException;

public class CLIPilha extends CLIEstrutura {
    public CLIPilha(EstruturaDeDados estrutura) {
        super(estrutura);
    }

    public void inicializar() {
        System.out.println("Digite o tamanho desejado para a pilha:");
    }

    public void mostrarTopo(int top) {
        System.out.println("Elemento do topo da pilha: " + top);
    }

    public void mostarRetirado(int pop) {
        System.out.println("Elemento retirado da pilha: " + pop);

    }
}
