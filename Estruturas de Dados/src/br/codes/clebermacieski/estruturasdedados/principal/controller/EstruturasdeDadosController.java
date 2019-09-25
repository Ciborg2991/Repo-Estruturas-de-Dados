package br.codes.clebermacieski.estruturasdedados.principal.controller;

import br.codes.clebermacieski.estruturasdedados.principal.model.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.Iterador;
import br.codes.clebermacieski.estruturasdedados.principal.model.pilha.Pilha;
import br.codes.clebermacieski.estruturasdedados.principal.view.CLIInterfacePrincipal;
import br.codes.clebermacieski.estruturasdedados.principal.view.ViewEstruturas;
import br.codes.clebermacieski.estruturasdedados.principal.view.pilha.CLIPilha;

import java.io.IOException;

public class EstruturasdeDadosController implements ControllerEstruturasdeDados{
	private ViewEstruturas interGUI;
    private ColecaoEstruturaDeDados colecaoEstruturas;
    private EstruturaDeDados estrutura;

	public EstruturasdeDadosController(ColecaoEstruturaDeDados colecaoEstruturas) {
		this.colecaoEstruturas = colecaoEstruturas;
		interGUI = new CLIInterfacePrincipal(colecaoEstruturas, this);
		interGUI.pedirOpcaodeEstrutura();
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
					Pilha pilha = (Pilha) estrutura;
					var cliPilha = new CLIPilha(estrutura);
					cliPilha.inicializar();

					cliPilha.mostrarOperacoes();
					String opcao = cliPilha.pedirOpcao();

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
					}
				}

			} else throw new IOException("Não foi possível encontrar a estrutura solicitada.");
		}
	}
}
