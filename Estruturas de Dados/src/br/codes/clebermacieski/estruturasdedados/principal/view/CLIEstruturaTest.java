package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.controller.EstruturasdeDadosController;
import br.codes.clebermacieski.estruturasdedados.principal.model.pilha.Pilha;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CLIEstruturaTest {

    @Test
    void mostrarOperacoes() {
        var cli = new CLIEstrutura(new Pilha(), new EstruturasdeDadosController());
        cli.mostrarOperacoes();
    }

    @Test
    void pegarOpcao() {
        var cli = new CLIEstrutura(new Pilha(), new EstruturasdeDadosController(), new ByteArrayInputStream("1".getBytes()));

        //System.setIn();
        try {
            assertEquals(1,cli.pegarOpcao());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}