package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.controller.EstruturasdeDadosController;
import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CLIEstrutura{
    private final EstruturaDeDados model;
    private final EstruturasdeDadosController controller;
    private BufferedReader bufferedReader;

    public CLIEstrutura(EstruturaDeDados estrutura, EstruturasdeDadosController estruturasdeDadosController) {
        this.model = estrutura;
        this.controller = estruturasdeDadosController;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    CLIEstrutura(EstruturaDeDados estrutura, EstruturasdeDadosController estruturasdeDadosController, InputStream entradaParaTeste) {
        this.model = estrutura;
        this.controller = estruturasdeDadosController;
        bufferedReader = new BufferedReader(new InputStreamReader(entradaParaTeste));
    }

    public void mostrarOperacoes() {
        System.out.println("Selecione operação de "+model.toString());

        ArrayList<String> operacoes = model.pegarOperacoes();
        int i = 1;
        for(String operacao:operacoes){
            System.out.println(i + " - " + operacao);
            i++;
        }

        System.out.println("0 - Sair");
    }

    public int pegarOpcao() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
}
