package br.codes.clebermacieski.estruturasdedados.principal;

import java.util.Iterator;

public class EstruturasDeDados implements Observavel, Iteravel{
    private Observador observador;

    @Override
    public void registrarObservador(Observador observador) {
        this.observador = observador;
    }

    @Override
    public void notificar() {
            observador.atualizar();
        }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Iterador pegarIterador() {
        return null;
    }
}