package br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_fila;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.fila.Fila;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.CLIEstrutura;

public class CLIFila extends CLIEstrutura {
    public CLIFila(EstruturaDeDados fila) {
        super(fila);
    }

    public void inicializar() {
        System.out.println("Digite o tamanho desejado para a fila:");
    }
}
