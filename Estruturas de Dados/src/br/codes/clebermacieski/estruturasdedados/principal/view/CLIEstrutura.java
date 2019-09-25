package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;

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
        System.out.println("Selecione operação de "+ estrutura.toString());

        ArrayList<String> operacoes = estrutura.pegarOperacoes();
        int i = 1;
        for(String operacao:operacoes){
            System.out.println(i + " - " + operacao);
            i++;
        }

        System.out.println("0 - Sair");
    }

    public String pedirOpcao() throws IOException {
        int opcao = Integer.parseInt(bufferedReader.readLine());

        ArrayList<String> operacoes = estrutura.pegarOperacoes();
        int i = 1;
        for(String operacao:operacoes) {
            if (i == opcao){
                return operacao;
            }
        }

        return null;
    }

    void sucesso() {
        System.out.println("Operação efetuada com sucesso!");
    }

    public void mostrar(int dado) {
        System.out.println(dado);
    }
}
