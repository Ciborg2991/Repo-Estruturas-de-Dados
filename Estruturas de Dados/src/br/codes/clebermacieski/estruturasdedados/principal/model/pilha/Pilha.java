package br.codes.clebermacieski.estruturasdedados.principal.model.pilha;

import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;

public class Pilha extends EstruturaDeDados {
    private int TAMANHO;
    private int [] vetor;
    private int indiceAtual;

    public Pilha(int tamanho){
        this.TAMANHO = tamanho;
        this.vetor= new int[this.TAMANHO];
        this.indiceAtual = 0;
    }

    public Pilha() {

    }

    public void push(int valor) throws ArrayIndexOutOfBoundsException{
        this.vetor[this.indiceAtual]= valor;
        this.indiceAtual++;
    }

    public int pop() throws ArrayIndexOutOfBoundsException {
        int aux = this.vetor[this.indiceAtual -1];
        this.vetor[this.indiceAtual -1]= 0;
        this.indiceAtual--;
        return aux;
    }

    public int getTAMANHO() {
        return TAMANHO;
    }

    public int getTamanhoAtual(){
        return this.indiceAtual;
    }

    public int top(){
        return this.vetor[this.indiceAtual -1];
    }

    boolean isEmpty(){
        return this.indiceAtual == 0;
    }

    public void clear(){
        if(!this.isEmpty()){
            for (int i = 0; i < this.indiceAtual; i++) {
                this.vetor[i] = 0;
            }
            this.indiceAtual = 0;
        }
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
