package br.codes.clebermacieski.estruturasdedados.principal;

import br.codes.clebermacieski.estruturasdedados.arvorebinaria.ArvoreBinController;
import br.codes.clebermacieski.estruturasdedados.fila.FilaController;
import br.codes.clebermacieski.estruturasdedados.listacircular.ListaCircularController;
import br.codes.clebermacieski.estruturasdedados.listadupencadeada.ListaDupEncController;
import br.codes.clebermacieski.estruturasdedados.listasimplesncadeada.ListaSimpleEncadeadaController;
import br.codes.clebermacieski.estruturasdedados.pilha.PilhaController;

public class EstruturasdeDadosController implements ControllerEstruturasdeDados{
	private ViewEstruturas interGUI;
    private ColecaoEstruturaDeDados estruturas;

	public EstruturasdeDadosController(ColecaoEstruturaDeDados estruturas) {
		this.estruturas = estruturas;
		interGUI = new GUIInterfaceTextual(estruturas, this);
		interGUI.pedirOpcaodeEstrutura();
	}

	@Override
	public void exibirInterfaceEspecifica(int interf) {
		int flag = 0;

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
		System.out.println("Programa Encerrado.");

	}
}
