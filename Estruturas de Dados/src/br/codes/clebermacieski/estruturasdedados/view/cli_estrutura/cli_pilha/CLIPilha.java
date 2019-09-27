package br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_pilha;

import br.codes.clebermacieski.estruturasdedados.EstruturasDeDados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.CLIEstrutura;

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

    public void operacaoNaoEncontrada() {
        System.out.println("Operação não encontrada.");
    }
}
