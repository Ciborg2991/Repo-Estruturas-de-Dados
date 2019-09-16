package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.pilha.Pilha;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class CLIEstruturaTest {
    @Test
    void mostraOperacoesTest() throws NoSuchMethodException {
        EstruturaDeDados model = new Pilha();
        var operacoes = model.retornarOperacoesDisponiveis();
        for (String operacao: operacoes
             ) {
            System.out.println(operacao);
            var metodo = model.getClass().getMethod(operacao);

            try {
                System.out.println(metodo.invoke(model));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //TODO: Usar reflection para invocar as operações dos models de maneira desacoplada
        }
    }
}