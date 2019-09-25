package br.codes.clebermacieski.estruturasdedados.principal.view.pilha;

import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.view.CLIEstrutura;

import java.io.IOException;

public class CLIPilha extends CLIEstrutura {
    public CLIPilha(EstruturaDeDados estrutura) {
        super(estrutura);
    }

    public void inicializar() {
        System.out.println("Digite o tamanho desejado para a pilha:");
    }

    public int pedirElemento() throws NumberFormatException, IOException {
        System.out.println("Digite o elemento a ser inserido na pilha: ");
        return Integer.parseInt(super.bufferedReader.readLine());
    }

    public void mostrarTopo(int top) {
        System.out.println("Elemento do topo da pilha: " + top);
    }

    public void mostarRetirado(int pop) {
        System.out.println("Elemento retirado da pilha: " + pop);

    }
}
