package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.model.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.controller.ControllerEstruturasdeDados;

public abstract class ViewEstruturas {
    ControllerEstruturasdeDados controller;
    ColecaoEstruturaDeDados estruturas;

    ViewEstruturas(ColecaoEstruturaDeDados estruturasDeDados, ControllerEstruturasdeDados estrategia) {
        this.controller = estrategia;
        this.estruturas = estruturasDeDados;
    }

    public abstract void pedirOpcaodeEstrutura();
}
