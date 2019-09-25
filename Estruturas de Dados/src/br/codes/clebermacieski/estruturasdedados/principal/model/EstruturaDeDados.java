package br.codes.clebermacieski.estruturasdedados.principal.model;

import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class EstruturaDeDados {

    /**
     * Usa reflexão para acessar suas anotações a fim de retornar as operações disponíveis
     * na estrutura de maneira desacoplada
     * @return uma lista de operações
     */
    public ArrayList<String> pegarOperacoes(){
        ArrayList<String> operacoes = new ArrayList<>();
        Class classe = this.getClass();
        for(Method metodo: classe.getDeclaredMethods()){
            if (metodo.isAnnotationPresent(Operacao.class)){
                operacoes.add(metodo.getAnnotation(Operacao.class).nome());
            }
        }
        return operacoes;
    }
}