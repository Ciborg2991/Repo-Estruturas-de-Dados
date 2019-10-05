package br.codes.clebermacieski.estruturasdedados.controller;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.util.Iterador;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.pilha.Pilha;
import br.codes.clebermacieski.estruturasdedados.view.CLIInterfacePrincipal;
import br.codes.clebermacieski.estruturasdedados.view.ViewEstruturas;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_pilha.CLIPilha;

import java.io.IOException;

public class EstruturasdeDadosController implements ControllerEstruturasdeDados{
    private ViewEstruturas cliPrincipal;
    private ColecaoEstruturaDeDados colecaoEstruturas;
    private EstruturaDeDados estrutura;

    public EstruturasdeDadosController(ColecaoEstruturaDeDados colecaoEstruturas) {
        this.colecaoEstruturas = colecaoEstruturas;
        cliPrincipal = new CLIInterfacePrincipal(colecaoEstruturas, this);
        cliPrincipal.pedirOpcaodeEstrutura();
    }

    @Override
    public void exibirInterfaceEspecifica(int indiceEstruturaSelecionada) throws IOException {
        int i = 1;
        boolean encontrou = false;
        if (indiceEstruturaSelecionada != 0) {
            for (Iterador iterador = colecaoEstruturas.pegarIterador(); iterador.temProximo(); ) {
                estrutura = iterador.pegarProximo();
                if (i == indiceEstruturaSelecionada) {
                    encontrou = true;
                    break;
                }
                i++;
            }

            if (encontrou) {
                var rodandoEstruturas = true;
                do {
                    if (estrutura.getClass() == Pilha.class) {
                        Pilha pilha = (Pilha) estrutura;
                        var cliPilha = new CLIPilha(estrutura);
                        cliPilha.inicializar();

                        cliPilha.mostrarOperacoes();
                        String opcao = cliPilha.pedirOpcao();

                        if (opcao == null){
                            cliPilha.operacaoNaoEncontrada();
                        }
                        else {
                            switch (opcao) {
                                case ("Inserir elemento"):
                                    pilha.push(cliPilha.pedirElemento());
                                    break;
                                case ("Remover elemento"):
                                    cliPilha.mostarRetirado(pilha.pop());
                                    break;
                                case ("Mostrar tamanho maximo"):
                                    cliPilha.mostrar(pilha.getTamanhoMaximo());
                                    break;
                                case ("Mostrar tamanho atual"):
                                    cliPilha.mostrar(pilha.getTamanhoAtual());
                                    break;
                                case ("Mostrar elemento do topo"):
                                    cliPilha.mostrarTopo(pilha.top());
                                    break;
                                case ("Limpar pilha"):
                                    pilha.clear();
                                    break;
                                case ("Sair"):
                                    rodandoEstruturas = false;
                            }
                        }
                    }
                } while (rodandoEstruturas);

            } else throw new IOException("Não foi possível encontrar a estrutura solicitada.");
        }
        else{
            throw new RuntimeException("Encerando.");
        }
    }
}
