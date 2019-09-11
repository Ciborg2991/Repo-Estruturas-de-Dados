package br.codes.clebermacieski.estruturasdedados.principal.model;

public interface Observavel {
    void registrarObservador(Observador observador);
    void notificar();
}
