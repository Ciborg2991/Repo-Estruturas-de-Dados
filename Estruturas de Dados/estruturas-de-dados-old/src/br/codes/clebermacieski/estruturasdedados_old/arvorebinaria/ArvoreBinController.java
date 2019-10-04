package br.codes.clebermacieski.estruturasdedados_old.arvorebinaria;

import java.util.InputMismatchException;

public class ArvoreBinController {
	private GUIArvoreBin guiArvBin;
	private ArvoreBinaria arvoreBinaria;

	public ArvoreBinController() {
		this.guiArvBin = new GUIArvoreBin();
	}

	public void instanciar() {
		try{
			this.arvoreBinaria = new ArvoreBinaria( this.guiArvBin.pedirRaiz() );
		}
		catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

	public void verificarOpcao() {
		int flag = 0;

		do{
			switch (this.guiArvBin.exibirOpcoes()){
				case 1:
					this.exibir();
					break;
				case 2:
					this.arvoreBinaria.pesquisar(this.guiArvBin.pedirElemento());
					break;
				case 3:
					try{
						this.arvoreBinaria.inserir(this.guiArvBin.pedirElemento());
					}
					catch (InputMismatchException e){
						System.out.println("Elemento digitado do tipo errado");
					}
					break;
				case 4:
					this.arvoreBinaria.balancear();
					break;
				case 5:
					this.arvoreBinaria.excluir(this.guiArvBin.pedirElemento());
					break;
				case 0:
					flag = 1;
					break;
				default:
					System.out.println("Opção não disponível.");
					break;
			}

		} while (flag != 1);
	}

	private void exibir() {
		switch (this.guiArvBin.pedirTipodeExibicao()) {
		case 1:
			this.arvoreBinaria.exibirPreOrdem();
			break;
		case 2:
			this.arvoreBinaria.exibirEmOrdem();
			break;
		case 3:
			this.arvoreBinaria.exibirPosOrdem();
			break;
		default:
			break;
		}
	}
}
