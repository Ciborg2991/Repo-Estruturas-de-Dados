package br.codes.clebermacieski.estruturasdedados.view;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.controller.ControllerEstruturasdeDados;
import br.codes.clebermacieski.estruturasdedados.util.Iterador;

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
        System.out.println(
                "  ______     _              _                             _        _____            _                  _    __      __     \n" +
                " |  ____|   | |            | |                           | |      |  __ \\          | |                | |  /\\ \\    / /\\    \n" +
                " | |__   ___| |_ _ __ _   _| |_ _   _ _ __ __ _ ___    __| | ___  | |  | | __ _  __| | ___  ___       | | /  \\ \\  / /  \\   \n" +
                " |  __| / __| __| '__| | | | __| | | | '__/ _` / __|  / _` |/ _ \\ | |  | |/ _` |/ _` |/ _ \\/ __|  _   | |/ /\\ \\ \\/ / /\\ \\  \n" +
                " | |____\\__ \\ |_| |  | |_| | |_| |_| | | | (_| \\__ \\ | (_| |  __/ | |__| | (_| | (_| | (_) \\__ \\ | |__| / ____ \\  / ____ \\ \n" +
                " |______|___/\\__|_|   \\__,_|\\__|\\__,_|_|  \\__,_|___/  \\__,_|\\___| |_____/ \\__,_|\\__,_|\\___/|___/  \\____/_/    \\_\\/_/    \\_\\\n" +
                "                                                                                                                           \n" +
                "                                                                                                                           "
        );
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
        System.out.println("Selecione uma estrutura da lista digitando seu número:");
        int i = 0;
        boolean tinhaElementos = false;

        for (iterador = estruturas.pegarIterador(); iterador.temProximo(); ){
            tinhaElementos = true;
            i++;
            System.out.println(i +" - "+ iterador.pegarProximo().toString() );
        }

        System.out.println("0 - Encerrar");

        if (!tinhaElementos) throw new IOException("Não há estruturas disponíveis.");
    }

    @Override
    public int pegarOpcaoEstrutura() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

}
