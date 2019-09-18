package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.controller.EstruturasdeDadosController;
import br.codes.clebermacieski.estruturasdedados.principal.model.pilha.Pilha;
import org.junit.jupiter.api.Test;

class CLIEstruturaTest {
    @Test
    void mostraOperacoesTest(){
        var cli = new CLIEstrutura(new Pilha(), new EstruturasdeDadosController());
        cli.mostrarOperacoes();
    }
}