package br.codes.clebermacieski.estruturasdedados.view.cli_estrutura;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CLIEstrutura{
    private final EstruturaDeDados estrutura;
    protected BufferedReader bufferedReader;

    public CLIEstrutura(EstruturaDeDados estrutura) {
        this.estrutura = estrutura;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    CLIEstrutura(EstruturaDeDados estrutura, InputStream entradaParaTeste) {
        this.estrutura = estrutura;
        bufferedReader = new BufferedReader(new InputStreamReader(entradaParaTeste));
    }

    public void mostrarOperacoes() {
        System.out.println("Selecione operação de "+ estrutura.toString());

        String[] operacoes = estrutura.pegarOperacoes();

        int i = 1;
        for(String operacao:operacoes){
            System.out.println(i + " - " + operacao);
            i++;
        }

        System.out.println("0 - Sair");
    }

    public String pedirOpcao() throws IOException {
        int opcao = Integer.parseInt(bufferedReader.readLine());

        if (opcao != 0){
            String[] operacoes = estrutura.pegarOperacoes();

            for (int i = 1; i < operacoes.length+1; i++) {
                if (i  == opcao) {
                    return operacoes[i-1];
                }
            }
        }
        if (opcao == 0) return "Sair";

        return null;
    }

    void sucesso() {
        System.out.println("Operação efetuada com sucesso!");
    }

    public void mostrar(int dado) {
        System.out.println(dado);
    }

    public void mostrar(String mensagem){
        System.out.println(mensagem);
    }

    public void operacaoNaoEncontrada() {
        System.out.println("Operação não encontrada.");
    }
}
