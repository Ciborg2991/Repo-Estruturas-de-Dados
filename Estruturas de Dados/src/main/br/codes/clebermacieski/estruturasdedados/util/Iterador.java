package br.codes.clebermacieski.estruturasdedados.util;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;

public interface Iterador {
    boolean temProximo();
    EstruturaDeDados pegarProximo();
}
