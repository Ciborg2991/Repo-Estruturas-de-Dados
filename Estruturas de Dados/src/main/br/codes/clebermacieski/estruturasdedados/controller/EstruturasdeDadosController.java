package br.codes.clebermacieski.estruturasdedados.controller;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.arvore_binaria.ArvoreBinaria;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_circular.ListaCircular;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_duplamente_encadeada.ListaDuplamenteEncadeada;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_simples_encadeada.ListaEncadeada;
import br.codes.clebermacieski.estruturasdedados.util.Iterador;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.pilha.Pilha;
import br.codes.clebermacieski.estruturasdedados.view.CLIInterfacePrincipal;
import br.codes.clebermacieski.estruturasdedados.view.ViewEstruturas;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_arvore_binaria.CLIArvoreBinaria;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_lista_duplamente_encadeada.CLIListaDuplamenteEncadeada;
import br.codes.clebermacieski.estruturasdedados.view.cli_estrutura.cli_lista_encadeada.CLIListaEncadeada;
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
                if (estrutura.getClass() == ListaEncadeada.class){
                    rodarListaSimplesEncadeada();
                }
                if (estrutura.getClass() == ListaCircular.class){
                    rodarListaCircular();
                }
            } else throw new IOException("Não foi possível encontrar a estrutura solicitada.");
        }
        else{
            throw new RuntimeException("Encerando.");
        }
    }

    private void rodarListaCircular() {
        ListaCircular listaCircular = new ListaCircular();
        CLIListaCircular cliListaCircular = new CLIListaCircular(listaCircular);
        var rodando = true;
        do {
            try {
                atrasar(600);
                cliListaCircular.mostrarOperacoes();
                switch (cliListaCircular.pedirOperacao()) {
                    case "Inserir no início":
                        cliListaCircular.pedirElemento();
                        listaCircular.inserirNoInicio(cliListaCircular.pegarString());
                        break;
                    case "Inserir no fim":
                        cliListaCircular.pedirElemento();
                        listaCircular.inserirNoFim(cliListaCircular.pegarString());
                        break;
                    case "Inserir após elemento":
                        cliListaCircular.pedirElementoReferencia();
                        var referencia = cliListaCircular.pegarString();
                        cliListaCircular.pedirElemento();
                        var elemento = cliListaCircular.pegarString();

                        listaCircular.insereApos(referencia, elemento);
                        break;
                    case "Inserir em posição específica":
                        cliListaCircular.pedirPosição();
                        var posicao = cliListaCircular.pegarInt();

                        cliListaCircular.pedirElemento();
                        elemento = null;
                        elemento = cliListaCircular.pegarString();

                        listaCircular.inserirNaPos(posicao, elemento);
                        break;
                    case "Mostrar lista":
                        listaCircular.mostrar();
                        break;
                    case "Remover início da lista":
                        if (listaCircular.removerOInicio()) cliListaCircular.sucesso();
                        break;
                    case "Remover fim da lista":
                        if (listaCircular.removerOFim()) cliListaCircular.sucesso();
                        break;
                    case "Sair":
                        rodando = false;
                        break;
                    default:
                        cliListaCircular.mostrar("Operação não encontrada.");
                }
            } catch (IOException | NumberFormatException e) {
                cliListaCircular.mostrar("Erro no tipo de dados informado. Tente Novamente.");
            } catch (RuntimeException e) {
                cliListaCircular.mostrar(e.getMessage());
            }
        }while(rodando);
    }

    private void rodarListaSimplesEncadeada() {
        ListaEncadeada listaEnc = new ListaEncadeada();
        CLIListaEncadeada cliListaEnc = new CLIListaEncadeada(listaEnc);

        var rodando = true;
        do {
            try{
                atrasar(600);
                cliListaEnc.mostrarOperacoes();
                switch(cliListaEnc.pedirOperacao()){
                    case "Inserir elemento no ínicio":
                        cliListaEnc.pedirElemento();
                        listaEnc.inserirNoInicio(cliListaEnc.pegarString());
                        break;
                    case "Inserir elemento no fim":
                        cliListaEnc.pedirElemento();
                        listaEnc.inserirNoFim(cliListaEnc.pegarString());
                        break;
                    case "Inserir elemento após outro":
                        cliListaEnc.pedirElementoReferencia();
                        var ref = cliListaEnc.pegarString();

                        cliListaEnc.pedirElemento();
                        var elemento = cliListaEnc.pegarString();
                        listaEnc.insereApos(ref, elemento );
                        break;
                    case "Inserir em posição específica":
                        cliListaEnc.pedirPosicao();
                        var posicao = cliListaEnc.pegarInt();

                        cliListaEnc.pedirElemento();
                        elemento = null;
                        elemento = cliListaEnc.pegarString();

                        listaEnc.inserirNaPos(posicao, elemento);
                        break;
                    case "Exibir":
                        listaEnc.exibir();
                        break;
                    case "Pesquisar elemento":
                        cliListaEnc.pedirElemento();
                        cliListaEnc.mostrar(listaEnc.pesquisar(cliListaEnc.pegarString()));
                        break;
                    case "Remover elemento":
                        cliListaEnc.pedirElemento();
                        if (listaEnc.remover(cliListaEnc.pegarString())) cliListaEnc.sucesso();
                        break;
                    case "Remover início":
                        if (listaEnc.removerOInicio()) cliListaEnc.sucesso();
                        break;
                    case "Remover fim":
                        if (listaEnc.removerOFim()) cliListaEnc.sucesso();
                        break;
                    case "Sair":
                        rodando = false;
                        break;
                    default:
                        cliListaEnc.mostrar("Operação não encontrada.");
                }
            }catch (IOException | NumberFormatException e  ){
                cliListaEnc.mostrar("Erro no tipo de dados informado. Tente Novamente.");
            }catch (RuntimeException e){
                cliListaEnc.mostrar(e.getMessage());
            }
        }while(rodando);
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
                        listDE.adicionarNoInicio(cliListaDE.pegarInt());
                        break;
                    case "Adicionar elemento no fim":
                        cliListaDE.pedirElemento();
                        listDE.adicionarNoFim(cliListaDE.pegarInt());
                        break;
                    case "Mostrar lista":
                        listDE.imprimir();
                        break;
                    case "Buscar elemento":
                        cliListaDE.pedirElemento();
                        listDE.buscar(cliListaDE.pegarInt());
                        break;
                    case "Extrair elemento":
                        cliListaDE.pedirElemento();
                        listDE.extrair(cliListaDE.pegarInt());
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
                arvoreBinaria = new ArvoreBinaria(cliArvoreBinaria.pegarInt());
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
                        arvoreBinaria.inserir(cliArvoreBinaria.pegarInt());
                        cliArvoreBinaria.sucesso();
                        break;
                    case "Pesquisar elemento":
                        cliArvoreBinaria.pedirElementoPesquisa();
                        if (arvoreBinaria.pesquisar(cliArvoreBinaria.pegarInt())){
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
                        if (arvoreBinaria.excluir(cliArvoreBinaria.pegarInt())) {
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
                            cliPilha.pedirElemento();
                            pilha.push(cliPilha.pegarInt());
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