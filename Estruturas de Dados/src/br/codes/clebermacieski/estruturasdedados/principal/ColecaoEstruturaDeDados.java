package br.codes.clebermacieski.estruturasdedados.principal;

import java.util.ArrayList;

public class ColecaoEstruturaDeDados implements Iteravel{
    ArrayList<String> estruturas;

    public ColecaoEstruturaDeDados(){
        estruturas = new ArrayList<String>();
        estruturas.add("Pilha");
    }
    @Override
    public Iterador pegarIterador() {
        return new IteradorEstruturas(this);
    }
}