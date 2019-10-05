package br.codes.clebermacieski.estruturasdedados.view;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.controller.ControllerEstruturasdeDados;

/**
 * Classe abstrata e parte do design pattern composto MVC, implementando o desing pattern strategy.
 * @author Cléber Macieski
 */
public abstract class ViewEstruturas {
    ControllerEstruturasdeDados controller;
    ColecaoEstruturaDeDados estruturas;

    ViewEstruturas(ColecaoEstruturaDeDados estruturasDeDados, ControllerEstruturasdeDados estrategia) {
        this.controller = estrategia;
        this.estruturas = estruturasDeDados;
    }

    public abstract void pedirOpcaodeEstrutura();
}
