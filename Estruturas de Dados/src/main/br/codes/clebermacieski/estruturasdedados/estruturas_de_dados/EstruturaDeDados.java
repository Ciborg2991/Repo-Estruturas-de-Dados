package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados;

import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class EstruturaDeDados {

    /**
     * Usa reflexão para acessar suas anotações a fim de retornar as operações disponíveis
     * na estrutura de maneira desacoplada
     * @return Uma lista de operações
     */
    public String[] pegarOperacoes(){
        Class classe = this.getClass();
        String[] operacaoIndexada = new String[classe.getDeclaredMethods().length];
        //TODO: Usar array multidimensional
        for(Method metodo: classe.getDeclaredMethods()){
            if (metodo.isAnnotationPresent(Operacao.class)){
                operacaoIndexada[metodo.getAnnotation(Operacao.class).posicao()] = metodo.getAnnotation(Operacao.class).nome();
            }
        }
        return operacaoIndexada;
    }
}