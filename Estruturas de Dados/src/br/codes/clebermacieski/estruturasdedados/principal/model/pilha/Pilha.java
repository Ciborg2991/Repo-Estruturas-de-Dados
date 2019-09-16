package br.codes.clebermacieski.estruturasdedados.principal.model.pilha;

import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;

import java.util.ArrayList;

public class Pilha extends EstruturaDeDados {
    private int tamanhoMaximo;
    private int [] vetor;
    private int indiceAtual;

    public Pilha(int tamanho){
        this.tamanhoMaximo = tamanho;
        this.vetor= new int[this.tamanhoMaximo];
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

    public int getTamanhoMaximo() {
        return tamanhoMaximo;
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

    @Override
    public ArrayList<String> retornarOperacoesDisponiveis() {
        ArrayList operacoes = new ArrayList();
        operacoes.add("getTamanhoMaximo");
        return operacoes;
    }
}
