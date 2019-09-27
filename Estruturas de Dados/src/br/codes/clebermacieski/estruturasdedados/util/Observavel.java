package br.codes.clebermacieski.estruturasdedados.util;

public interface Observavel {
    void registrarObservador(Observador observador);
    void notificar();
}
