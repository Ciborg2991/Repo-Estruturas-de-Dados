package br.codes.ciborg2991.estruturasdedados.fila;

public class FilaController {
	private GUIFila guiFila;
	private Fila fila;
	
	public FilaController() {
		this.guiFila = new GUIFila();
		this.fila = new Fila(10); //create
	}

	public void verificarOpcao() {
		switch (this.guiFila.exibirOpcoes()) {
		case 1:
			//read
			this.fila.exibirFila();
			break;
		case 2:
			//update
			break;
		case 3:
			//delete
			break;
		}
	}
}
