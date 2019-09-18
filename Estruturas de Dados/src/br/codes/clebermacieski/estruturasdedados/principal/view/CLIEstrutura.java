package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.controller.EstruturasdeDadosController;
import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.Operacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

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

        var i = 1;
        Class classe = model.getClass();
        for(Method metodo: classe.getDeclaredMethods()){
            if (metodo.isAnnotationPresent(Operacao.class)){
                System.out.println(i + " - " +metodo.getAnnotation(Operacao.class).nome());
                i++;
            }
        }
    }

    public int pegarOpcao() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
}
