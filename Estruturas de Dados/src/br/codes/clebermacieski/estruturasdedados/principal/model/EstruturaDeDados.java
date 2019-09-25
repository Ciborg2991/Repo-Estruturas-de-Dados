package br.codes.clebermacieski.estruturasdedados.principal.model;

import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class EstruturaDeDados {

    /**
     * Usa reflex�o para acessar suas anota��es a fim de retornar as opera��es dispon�veis
     * na estrutura de maneira desacoplada
     * @return uma lista de opera��es
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