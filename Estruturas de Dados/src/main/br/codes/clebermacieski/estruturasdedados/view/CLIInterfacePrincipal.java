package br.codes.clebermacieski.estruturasdedados.view;

import br.codes.clebermacieski.estruturasdedados.EstruturasDeDados.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.controller.ControllerEstruturasdeDados;
import br.codes.clebermacieski.estruturasdedados.util.Iterador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Command Line Interface principal.
 * @author Cl�ber Macieski
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
        var rodando  = true;
        do {
            try {
                mostraOpcoes();
                controller.exibirInterfaceEspecifica(pegarOpcaoEstrutura());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
                rodando = false;
            }
        }while (rodando);
    }

    private void mostraOpcoes() throws IOException {
        System.out.println("Selecione uma estrutura da lista digitando seu n�mero:\n");
        int i = 0;
        boolean tinhaElementos = false;

        for (iterador = estruturas.pegarIterador(); iterador.temProximo(); ){
            tinhaElementos = true;
            i++;
            System.out.println(i +" - "+ iterador.pegarProximo().toString() );
        }

        System.out.println("0 - Encerrar");

        if (!tinhaElementos) throw new IOException("N�o h� estruturas dispon�veis.");
    }

    private int pegarOpcaoEstrutura() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

}
