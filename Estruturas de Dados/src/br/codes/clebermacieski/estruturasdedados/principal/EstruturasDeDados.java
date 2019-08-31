package br.codes.clebermacieski.estruturasdedados.principal;

public class EstruturasDeDados implements Observavel{
    private Observador observador;

    @Override
    public void registrarObservador(Observador observador) {
        this.observador = observador;
    }

    @Override
    public void notificar() {
            observador.atualizar();
        }
}