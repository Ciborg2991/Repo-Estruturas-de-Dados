package br.codes.clebermacieski.estruturasdedados.arvorebinaria;

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
				this.arvoreBinaria.exibir();
				break;
			case 2:
				try{
				this.arvoreBinaria.inserir(this.guiArvBin.pedirElemento());
				}
				catch (InputMismatchException e){
					System.out.println("Elemento digitado do tipo errado");
				}
				break;
			case 3:

				break;
			case 4:

				break;
			case 0:
				flag = 1;
				break;
			default:
				System.out.println("Erro estranho");
				break;
			}

		} while (flag != 1);
	}
}
