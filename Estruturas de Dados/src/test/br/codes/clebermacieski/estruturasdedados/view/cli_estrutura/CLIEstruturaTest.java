package br.codes.clebermacieski.estruturasdedados.view.cli_estrutura;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.pilha.Pilha;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CLIEstruturaTest {

    @Test
    void mostrarOperacoes() {
        var cli = new CLIEstrutura(new Pilha());
        cli.mostrarOperacoes();
    }

    @Test
    void pegarOpcao() {
        var cli = new CLIEstrutura(new Pilha(), new ByteArrayInputStream("1".getBytes()));

        try {
            assertEquals("Limpar pilha",cli.pedirOpcao());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}