package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados;

import br.codes.clebermacieski.estruturasdedados.util.Iterador;

public class IteradorEstruturas implements Iterador {
    private int posicaoAtual;
    private final ColecaoEstruturaDeDados colecao;

    IteradorEstruturas(ColecaoEstruturaDeDados colecaoEstruturaDeDados) {
        posicaoAtual = 0;
        colecao = colecaoEstruturaDeDados;
    }

    @Override
    public boolean temProximo() {
        try{
            colecao.estruturas.get(posicaoAtual);
        } catch (IndexOutOfBoundsException e){
            return false;
        }
        return true;
    }

    @Override
    public EstruturaDeDados pegarProximo() {
        EstruturaDeDados elemento = colecao.estruturas.get(posicaoAtual);
        posicaoAtual++;
        return elemento;
    }
}
