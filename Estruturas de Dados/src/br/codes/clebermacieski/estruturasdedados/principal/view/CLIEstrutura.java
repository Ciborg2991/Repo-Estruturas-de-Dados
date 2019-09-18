package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.controller.EstruturasdeDadosController;
import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.Operacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class CLIEstrutura{
    private final EstruturaDeDados model;
    private final EstruturasdeDadosController controller;
    private BufferedReader bufferedReader;

    public CLIEstrutura(EstruturaDeDados estrutura, EstruturasdeDadosController estruturasdeDadosController) {
        this.model = estrutura;
        this.controller = estruturasdeDadosController;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void mostrarOperacoes() {
        System.out.println("Selecione operação de "+model.toString());

        Class classe = model.getClass();
        for(Method metodo: classe.getDeclaredMethods()){
            if (metodo.isAnnotationPresent(Operacao.class)){
                System.out.println(metodo.getAnnotation(Operacao.class));
            }
        }
    }
}
