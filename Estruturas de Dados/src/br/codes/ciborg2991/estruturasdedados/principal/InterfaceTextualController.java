package br.codes.ciborg2991.estruturasdedados.principal;

import br.codes.ciborg2991.estruturasdedados.arvorebinaria.ArvoreBinController;
import br.codes.ciborg2991.estruturasdedados.fila.FilaController;
import br.codes.ciborg2991.estruturasdedados.listacircular.ITLstaCircular;
import br.codes.ciborg2991.estruturasdedados.listadupencadeada.ITListaDupEncController;
import br.codes.ciborg2991.estruturasdedados.listasimplesncadeada.ITListaSimpleEncadeadaController;
import br.codes.ciborg2991.estruturasdedados.pilha.PilhaController;

public class InterfaceTextualController {
	private GUIInterfaceTextual interGUI;

	public InterfaceTextualController() {
		this.interGUI = new GUIInterfaceTextual();
	}

	public void verificarOpcao() {
		int flag = 0;

		do{
			this.interGUI.iniciar();
			switch (this.interGUI.getOpcaodeEstrutura()) {
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
				ITListaSimpleEncadeadaController lseController = new ITListaSimpleEncadeadaController();
				lseController.instanciar();
				lseController.verificarOpcao();
				break;

			case 4:
				ITListaDupEncController ldeController = new ITListaDupEncController();
				ldeController.verificarOpcao();
				break;

			case 5:
				ITLstaCircular lcircController = new ITLstaCircular();
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
				System.out.println("Erro estranho");
				break;
			}
		}
		while (flag != 1);
		System.out.println("Programa Encerrado.");
	}
}
