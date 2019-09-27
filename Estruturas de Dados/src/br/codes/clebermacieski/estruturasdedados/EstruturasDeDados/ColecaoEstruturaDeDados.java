package br.codes.clebermacieski.estruturasdedados.EstruturasDeDados;

import br.codes.clebermacieski.estruturasdedados.EstruturasDeDados.pilha.Pilha;
import br.codes.clebermacieski.estruturasdedados.util.Iterador;
import br.codes.clebermacieski.estruturasdedados.util.Iteravel;

import java.util.ArrayList;

/**
 * Coleção das Estruturas de Dados implementadas.
 * Utilizada essa coleção a fim de desacoplar a interface gráfica dos modelos que podem ser adicionados ao longo do tempo.
 * Esta classe compõe o padrão Iterator
 *
 * @author Cléber Macieski
 */

public class ColecaoEstruturaDeDados implements Iteravel {
    ArrayList<EstruturaDeDados> estruturas;

    public ColecaoEstruturaDeDados(){
        estruturas = new ArrayList<>();
        estruturas.add(new Pilha());
    }
    @Override
    public Iterador pegarIterador() {
        return new IteradorEstruturas(this);
    }
}