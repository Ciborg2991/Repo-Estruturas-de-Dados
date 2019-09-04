package br.codes.clebermacieski.estruturasdedados.principal;

abstract class ViewEstruturas {
    ControllerEstruturasdeDados controller;
    ColecaoEstruturaDeDados estruturas;

    ViewEstruturas(ColecaoEstruturaDeDados estruturasDeDados, ControllerEstruturasdeDados estrategia) {
        this.controller = estrategia;
        this.estruturas = estruturasDeDados;
    }

    abstract void pedirOpcaodeEstrutura();
}
