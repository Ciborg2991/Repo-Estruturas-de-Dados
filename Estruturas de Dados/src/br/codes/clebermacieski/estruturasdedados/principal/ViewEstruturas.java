package br.codes.clebermacieski.estruturasdedados.principal;

abstract class ViewEstruturas {
    ControllerEstruturasdeDados controller;
    private EstruturasDeDados model;

    ViewEstruturas(EstruturasDeDados estruturasDeDados, ControllerEstruturasdeDados estrategia) {
        this.controller = estrategia;
        this.model = estruturasDeDados;
    }

    abstract void pedirOpcaodeEstrutura();
}
