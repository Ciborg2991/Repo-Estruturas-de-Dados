package br.codes.clebermacieski.estruturasdedados.principal.view;

import br.codes.clebermacieski.estruturasdedados.principal.model.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.controller.ControllerEstruturasdeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.Iterador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Model concreto que mostra estruturas e açoes disponíveis nos models.
 * @author Cléber Macieski
 */
public class GUIInterfaceTextual extends ViewEstruturas{
    private BufferedReader leitorAmortecido;
    private Iterador iterador;

    public GUIInterfaceTextual(ColecaoEstruturaDeDados estruturas, ControllerEstruturasdeDados estrategia){
        super(estruturas, estrategia);
        leitorAmortecido= new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void pedirOpcaodeEstrutura() {
        try {
            controller.exibirInterfaceEspecifica(pegarOpcaoEstrutura());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private int pegarOpcaoEstrutura() {
        int opcao;
        do{
            try {
                boolean opcaoEhValida = false;
                do{
                    this.mostraOpcoes();
                    opcao = Integer.parseInt(leitorAmortecido.readLine());

                    int i = 0;
                    for (Iterador iterador = estruturas.pegarIterador(); iterador.temProximo(); iterador.pegarProximo()) {
                        i++;
                        if (opcao == i) {
                            opcaoEhValida = true;
                            break;
                        }
                    }

                    if (!opcaoEhValida) {
                        System.out.println("Opção não é valida.");
                    }
                }
                while (!opcaoEhValida);

                return opcao;
            }
            catch (NumberFormatException e) {
                System.out.println("Erro no tipo dado como opção digitado, tente novamente.");
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private void mostraOpcoes() throws IOException {
        System.out.println("=====Estruturas de Dados=====\n");
        System.out.println("Selecione uma estrutura:\n");
        int i = 0;
        boolean tinhaElementos = false;

        for (iterador = estruturas.pegarIterador(); iterador.temProximo(); ){
            tinhaElementos = true;
            i++;
            System.out.println(i +" - "+ iterador.pegarProximo().toString() );
        }

        if (!tinhaElementos) throw new IOException("Não há estruturas disponíveis.");
    }

}
