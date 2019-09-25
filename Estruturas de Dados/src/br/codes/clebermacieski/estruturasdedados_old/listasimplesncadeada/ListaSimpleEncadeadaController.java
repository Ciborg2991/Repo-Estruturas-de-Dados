package br.codes.clebermacieski.estruturasdedados_old.listasimplesncadeada;

public class ListaSimpleEncadeadaController {
	private GUIListaSE guiSE;
	private ListaSimplesmenteEncadeada listaSE;
	
	public ListaSimpleEncadeadaController(){
		this.guiSE = new GUIListaSE();
		this.listaSE = new ListaSimplesmenteEncadeada();
	}
	
	public void instanciar() {
		this.listaSE.inserirNoInicio(guiSE.pedirElemento());
		this.verificarOpcao();
		
	}
	
	public void verificarOpcao() {
		int flag = 0;
		do{
			switch (this.guiSE.exibirOpcoes()){
			case 1:
				this.listaSE.exibir();
				break;
			case 2:
				switch (this.guiSE.exibirOpcoesInsercao()){
				case 1:
					this.listaSE.inserirNoInicio(this.guiSE.pedirElemento());
					break;
				case 2:
					this.listaSE.inserirNoFim(this.guiSE.pedirElemento());
					break;
				case 3:
					this.listaSE.insereApos(this.guiSE.pedirElementoReferencia(), this.guiSE.pedirElemento());
					break;
				case 4:
					this.listaSE.inserirNaPos(this.guiSE.pedirPosicao(), this.guiSE.pedirElemento());
					break;
				}
				break;
			case 3:
				this.guiSE.avaliarPesquisa(this.listaSE.pesquisar(this.guiSE.pedirElemento()));
				break;
			case 4:
				this.listaSE.remover(this.guiSE.pedirElemento());
				break;
			case 0:
				//sair
				break;
			default:
				flag = 1;
				break;
			}
		}
		while (flag != 1);
		
	}

}
