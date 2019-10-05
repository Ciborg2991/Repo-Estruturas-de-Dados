package br.codes.clebermacieski.estruturasdedados.view.cli_estrutura;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
        System.out.println("Selecione opera��o de "+ estrutura.toString());

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

            for (int i = 1; i < operacoes.length; i++) {
                if (i  == opcao) {
                    return operacoes[i];
                }
            }
        }
        if (opcao == 0) return "Sair";

        return null;
    }

    void sucesso() {
        System.out.println("Opera��o efetuada com sucesso!");
    }

    public void mostrar(int dado) {
        System.out.println(dado);
    }
}
