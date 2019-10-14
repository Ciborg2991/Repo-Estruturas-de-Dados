package br.codes.clebermacieski.estruturasdedados.controller;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.arvore_binaria.ArvoreBinaria;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_duplamente_encadeada.ListaDuplamenteEncadeada;
import br.codes.clebermacieski.estruturasdedados.util.Iterador;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.pilha.Pilha;
import br.codes.clebermacieski.estruturasdedados.view.CLIInterfacePrincipal;
import br.codes.clebermacieski.estruturasdedados.view.ViewEstruturas;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_arvore_binaria.CLIArvoreBinaria;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_lista_duplamente_encadeada.CLIListaDuplamenteEncadeada;
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
                if(estrutura.getClass() == ListaDuplamenteEncadeada.class){
                    rodarListaDuplamenteEncadeada();
                }
            } else throw new IOException("Não foi possível encontrar a estrutura solicitada.");
        }
        else{
            throw new RuntimeException("Encerando.");
        }
    }

    private void rodarListaDuplamenteEncadeada() {
        ListaDuplamenteEncadeada listDE = new ListaDuplamenteEncadeada();
        CLIListaDuplamenteEncadeada cliListaDE = new CLIListaDuplamenteEncadeada(listDE);

        var rodando = true;
        do {
            atrasar(600);
            cliListaDE.mostrarOperacoes();
            try {
                switch (cliListaDE.pedirOperacao()) {
                    case "Adicionar elemento no ínicio":
                        cliListaDE.pedirElemento();
                        listDE.adicionarNoInicio(cliListaDE.pegar());
                        break;
                    case "Adicionar elemento no fim":
                        cliListaDE.pedirElemento();
                        listDE.adicionarNoFim(cliListaDE.pegar());
                        break;
                    case "Mostrar lista":
                        listDE.imprimir();
                        break;
                    case "Buscar elemento":
                        cliListaDE.pedirElemento();
                        listDE.buscar(cliListaDE.pegar());
                        break;
                    case "Extrair elemento":
                        cliListaDE.pedirElemento();
                        listDE.extrair(cliListaDE.pegar());
                        break;
                    case "Remover primeiro elemento":
                        listDE.retiraInicio();
                        break;
                    case "Retirar último elemento":
                        listDE.retiraFim();
                        break;
                    case "Sair":
                        rodando = false;
                        break;
                    default:
                        cliListaDE.mostrar("Operação não encontrada.");
                }
            }catch (IOException | NumberFormatException e){
                cliListaDE.mostrar("Erro no tipo de dados informado. Tente Novamente.");
            }
        } while (rodando) ;

    }

    private void rodarArvoreBinaria() {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        var cliArvoreBinaria = new CLIArvoreBinaria(estrutura);
        cliArvoreBinaria.pedirRaiz();

        var inicializando = true;
        do {
            try {
                arvoreBinaria = new ArvoreBinaria(cliArvoreBinaria.pegar());
                inicializando = false;
            } catch (IOException | NumberFormatException e) {
                cliArvoreBinaria.mostrar("Erro no tipo de dado informado, tente novamente.");
            }
        }
        while(inicializando);

        var rodando = true;
        do {
            try {
                atrasar(600);
                cliArvoreBinaria.mostrarOperacoes();

                switch (cliArvoreBinaria.pedirOperacao()){
                    case "Inserir elemento":
                        cliArvoreBinaria.pedirElemento();
                        arvoreBinaria.inserir(cliArvoreBinaria.pegar());
                        cliArvoreBinaria.sucesso();
                        break;
                    case "Pesquisar elemento":
                        cliArvoreBinaria.pedirElementoPesquisa();
                        if (arvoreBinaria.pesquisar(cliArvoreBinaria.pegar())){
                            cliArvoreBinaria.mostrar("Elemento existe na árvore.");
                        }
                        else{
                            cliArvoreBinaria.mostrar("Elemento não encontrado.");
                        }
                        break;
                    case "Balancear Árvore":
                        arvoreBinaria.balancear();
                        cliArvoreBinaria.sucesso();
                        break;
                    case "Exibir em ordem":
                        arvoreBinaria.exibirEmOrdem();
                        break;
                    case "Exibir em pré-ordem":
                        arvoreBinaria.exibirPreOrdem();
                        break;
                    case "Exibir em pós-ordem":
                        arvoreBinaria.exibirPosOrdem();
                        break;
                    case "Excluir elemento":
                        cliArvoreBinaria.pedirElementoExcluir();
                        if (arvoreBinaria.excluir(cliArvoreBinaria.pegar())) {
                            cliArvoreBinaria.sucesso();
                            if (arvoreBinaria.ehVazia()){
                                cliArvoreBinaria.mostrar("Raiz excluída, voltando ao menu principal.");
                                rodando = false;
                            }
                        }
                        else{
                            cliArvoreBinaria.mostrar("Não foi possivel excluir o elemento dado.");
                        }
                        break;
                    case "Sair":
                        rodando = false;
                        break;
                    default:
                        cliArvoreBinaria.operacaoNaoEncontrada();
                }
            } catch (IOException | NumberFormatException e) {
                cliArvoreBinaria.mostrar("Erro no tipo de dado informado, tente novamente.");
            }
        } while (rodando);

    }

    private void rodarPilha() throws IOException {
        var cliPilha = new CLIPilha(estrutura);

        var inicializando = true;
        Pilha pilha = null;
        do {
            cliPilha.inicializar();
            try {
                pilha = new Pilha(cliPrincipal.pegarOpcaoEstrutura());
                inicializando = false;
            } catch (IllegalArgumentException e) {
                cliPilha.mostrar(e.getMessage());
            }
        }while(inicializando);

        var rodando = true;
        do {
            atrasar(600);
            cliPilha.mostrarOperacoes();
            String opcao = cliPilha.pedirOperacao();

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