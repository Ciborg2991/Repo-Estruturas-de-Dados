package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.arvore_binaria.ArvoreBinaria;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.pilha.Pilha;
import br.codes.clebermacieski.estruturasdedados.util.Iterador;
import br.codes.clebermacieski.estruturasdedados.util.Iteravel;

import java.util.ArrayList;

/**
 * Coleção das Estruturas de Dados implementadas.
 * Utilizada essa coleção a fim de desacoplar a interface gráfica dos modelos que podem ser adicionados ao longo do tempo.
 * Esta classe é parte do padrão Iterator.
 * @author Cléber Macieski
 */

public class ColecaoEstruturaDeDados implements Iteravel {
    ArrayList<EstruturaDeDados> estruturas;

    public ColecaoEstruturaDeDados(){
        estruturas = new ArrayList<>();
        estruturas.add(new Pilha());
        estruturas.add(new ArvoreBinaria());
    }
    @Override
    public Iterador pegarIterador() {
        return new IteradorEstruturas(this);
    }
}