package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.model.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.controller.ControllerEstruturasdeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.Iterador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Command Line Interface principal.
 * @author Cléber Macieski
 */
public class CLIInterfacePrincipal extends ViewEstruturas{
    private BufferedReader bufferedReader;
    private Iterador iterador;

    public CLIInterfacePrincipal(ColecaoEstruturaDeDados estruturas, ControllerEstruturasdeDados estrategia){
        super(estruturas, estrategia);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void pedirOpcaodeEstrutura() {
        System.out.println("=====Estruturas de Dados=====\n");

        do {
            try {
                mostraOpcoes();
                controller.exibirInterfaceEspecifica(pegarOpcaoEstrutura());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
            }
        }while (true);
    }

    private void mostraOpcoes() throws IOException {
        System.out.println("Selecione uma estrutura da lista digitando seu número:\n");
        int i = 0;
        boolean tinhaElementos = false;

        for (iterador = estruturas.pegarIterador(); iterador.temProximo(); ){
            tinhaElementos = true;
            i++;
            System.out.println(i +" - "+ iterador.pegarProximo().toString() );
        }

        if (!tinhaElementos) throw new IOException("Não há estruturas disponíveis.");
    }

    private int pegarOpcaoEstrutura() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

}
