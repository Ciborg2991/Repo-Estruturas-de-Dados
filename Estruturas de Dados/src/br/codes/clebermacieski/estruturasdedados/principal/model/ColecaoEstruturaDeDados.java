package br.codes.clebermacieski.estruturasdedados.principal.model;

import br.codes.clebermacieski.estruturasdedados.principal.model.pilha.Pilha;

import java.util.ArrayList;

/**
 * Cole��o de Estruturas de Dados implementadas.
 * Utilizada essa cole��o a fim de desacoplar a interface gr�fica dos modelos que podem ser adicionados ao longo do tempo.
 * Esta classe comp�e o padr�o Iterator
 *
 * @author Cl�ber Macieski
 */

public class ColecaoEstruturaDeDados implements Iteravel{
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