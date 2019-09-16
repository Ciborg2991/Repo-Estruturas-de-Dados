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
        }else throw new IOException("Não foi possível encontrar a estrutura solicitada.");

	    /*int flag = 0;

		do{
			switch (interf) {
				case 1:
					PilhaController pilhaController = new PilhaController();
					pilhaController.instanciar();
					pilhaController.verificarOpcaoPilha();
					break;

				case 2:
					FilaController filaController = new FilaController();
					filaController.verificarOpcao();
					break;

				case 3:
					ListaSimpleEncadeadaController lseController = new ListaSimpleEncadeadaController();
					lseController.instanciar();
					lseController.verificarOpcao();
					break;

				case 4:
					ListaDupEncController ldeController = new ListaDupEncController();
					ldeController.verificarOpcao();
					break;

				case 5:
					ListaCircularController lcircController = new ListaCircularController();
					lcircController.verificarOpcao();
					break;

				case 6:
					ArvoreBinController arvBinController = new ArvoreBinController();
					arvBinController.instanciar();
					arvBinController.verificarOpcao();
				case 0:
					flag = 1;
					break;

				default:
					System.out.println("Erro estranho.");
					break;
			}
		}
		while (flag != 1);
		System.out.println("Programa Encerrado.");*/

	}
}
