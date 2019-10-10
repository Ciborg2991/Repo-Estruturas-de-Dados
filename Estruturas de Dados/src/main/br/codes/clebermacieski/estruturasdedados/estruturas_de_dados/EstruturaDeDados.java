package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados;

import java.lang.reflect.Method;

public abstract class EstruturaDeDados {

    /**
     * Usa reflexão para acessar suas anotações a fim de retornar as operações disponíveis
     * na estrutura de maneira desacoplada
     *
     * @return Uma lista de operações
     */
    public String[] pegarOperacoes() {
        Class classe = this.getClass();
        int numeroDeOperacoes = numeroDeOperacoes(classe);
        String[] listaOperacoes = new String[numeroDeOperacoes];
        for (Method metodo : classe.getDeclaredMethods()) {
            if (metodo.isAnnotationPresent(Operacao.class)) {
                listaOperacoes[metodo.getAnnotation(Operacao.class).posicao()] = metodo.getAnnotation(Operacao.class).nome();
             }
        }
        return listaOperacoes;
    }

    private int numeroDeOperacoes(Class classe) {
        var contador = 0;
        for (Method metodo : classe.getDeclaredMethods()) {
            if (metodo.isAnnotationPresent(Operacao.class)) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}