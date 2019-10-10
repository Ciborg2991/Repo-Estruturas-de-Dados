package br.codes.clebermacieski.estruturasdedados.controller;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.arvore_binaria.ArvoreBinaria;
import br.codes.clebermacieski.estruturasdedados.util.Iterador;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.pilha.Pilha;
import br.codes.clebermacieski.estruturasdedados.view.CLIInterfacePrincipal;
import br.codes.clebermacieski.estruturasdedados.view.ViewEstruturas;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_arvore_binaria.CLIArvoreBinaria;
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
                if (estrutura.getClass() == Pilha.class) {
                    rodarPilha();
                }
                if (estrutura.getClass() == ArvoreBinaria.class){
                    rodarArvoreBinaria();
                }
            } else throw new IOException("Não foi possível encontrar a estrutura solicitada.");
        }
        else{
            throw new RuntimeException("Encerando.");
        }
    }

    private void rodarArvoreBinaria() {
        var cliArvoreBinaria = new CLIArvoreBinaria(estrutura);
        cliArvoreBinaria.pedirRaiz();

        var rodando = true;
        do {
            try {
                ArvoreBinaria arvoreBinaria = new ArvoreBinaria(cliArvoreBinaria.pegar());
//TODO: nome da classe
//TODO:pensar padrãp para encapsularmudança da interface
                atrasar(600);
                cliArvoreBinaria.mostrarOperacoes();
                rodando = false;

            } catch (IOException e) {
                cliArvoreBinaria.mostrar("Erro no tipo de dado informado, tente novamente.");
            }
        } while (rodando);

    }

    private void rodarPilha() throws IOException {
        var cliPilha = new CLIPilha(estrutura);
        cliPilha.inicializar();
        Pilha pilha = new Pilha(cliPrincipal.pegarOpcaoEstrutura());

        var rodando = true;
        do {
            atrasar(600);
            cliPilha.mostrarOperacoes();
            String opcao = cliPilha.pedirOpcao();

            if (opcao == null) {
                cliPilha.operacaoNaoEncontrada();
            } else {
                try{
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
                            rodando = false;
                            break;
                        default:
                            cliPilha.operacaoNaoEncontrada();
                    }
                } catch(RuntimeException e){
                    cliPilha.mostrar(e.getMessage());
                }
            }
        } while (rodando);
    }

    private void atrasar(int atraso){
        try {
            Thread.sleep(atraso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}