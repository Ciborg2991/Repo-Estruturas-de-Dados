package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.controller.EstruturasdeDadosController;
import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;

public class CLIEstrutura{
    private final EstruturaDeDados model;
    private final EstruturasdeDadosController controller;

    public CLIEstrutura(EstruturaDeDados estrutura, EstruturasdeDadosController estruturasdeDadosController) {
        this.model = estrutura;
        this.controller = estruturasdeDadosController;
    }
}
