package br.codes.clebermacieski.estruturasdedados.principal;

public interface Observavel {
    void registrarObservador(Observador observador);
    void notificar();
}
