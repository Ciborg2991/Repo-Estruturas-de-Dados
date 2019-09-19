package br.codes.clebermacieski.estruturasdedados.principal.controller;

import br.codes.clebermacieski.estruturasdedados.principal.model.ColecaoEstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.Iterador;
import br.codes.clebermacieski.estruturasdedados.principal.view.CLIEstrutura;
import br.codes.clebermacieski.estruturasdedados.principal.view.CLIInterfacePrincipal;
import br.codes.clebermacieski.estruturasdedados.principal.view.ViewEstruturas;

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

    public EstruturasdeDadosController() {
    }


    @Override
	public void exibirInterfaceEspecifica(int indiceEstruturaSelecionada) throws IOException {
		int i = 1;
		boolean encontrou = false;
	    for(Iterador iterador = colecaoEstruturas.pegarIterador(); iterador.temProximo();){
	        estrutura = iterador.pegarProximo();
            if (i == indiceEstruturaSelecionada){
                encontrou = true;
                break;
            }
            i++;
        }

	    if (encontrou){
	        CLIEstrutura cliEstrutura = new CLIEstrutura(estrutura, this);
	        cliEstrutura.mostrarOperacoes();
	        cliEstrutura.pegarOpcao();
            //TODO: Tratar escolha. Talvez estender CLIEstrutura
        }else throw new IOException("Não foi possível encontrar a estrutura solicitada.");
	}
}
