package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados;

import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class EstruturaDeDados {

    /**
     * Usa reflex�o para acessar suas anota��es a fim de retornar as opera��es dispon�veis
     * na estrutura de maneira desacoplada
     * @return Uma lista de opera��es
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