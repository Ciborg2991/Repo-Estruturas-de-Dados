package br.codes.clebermacieski.estruturasdedados.util;

import br.codes.clebermacieski.estruturasdedados.EstruturasDeDados.EstruturaDeDados;

public interface Iterador {
    boolean temProximo();
    EstruturaDeDados pegarProximo();
}
