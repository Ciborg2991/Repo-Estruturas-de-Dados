package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.arvore_binaria.ArvoreBinaria;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.fila.Fila;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_circular.ListaCircular;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_duplamente_encadeada.ListaDuplamenteEncadeada;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_simples_encadeada.ListaEncadeada;
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
        estruturas.add(new Fila());
        estruturas.add(new ArvoreBinaria());
        estruturas.add(new ListaEncadeada());
        estruturas.add(new ListaDuplamenteEncadeada());
        estruturas.add(new ListaCircular());
    }
    @Override
    public Iterador pegarIterador() {
        return new IteradorEstruturas(this);
    }
}