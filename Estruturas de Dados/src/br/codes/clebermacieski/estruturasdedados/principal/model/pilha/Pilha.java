package br.codes.clebermacieski.estruturasdedados.principal.model.pilha;

import br.codes.clebermacieski.estruturasdedados.principal.model.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.principal.model.Operacao;

import java.util.LinkedHashMap;

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

    @Operacao(nome = "Inserir elemento")
    public void push(int valor) throws ArrayIndexOutOfBoundsException{
        this.vetor[this.indiceAtual]= valor;
        this.indiceAtual++;
    }

    @Operacao(nome = "Remover elemento")
    public int pop() throws ArrayIndexOutOfBoundsException {
        int aux = this.vetor[this.indiceAtual -1];
        this.vetor[this.indiceAtual -1]= 0;
        this.indiceAtual--;
        return aux;
    }

    @Operacao(nome = "Mostrar tamanho maximo")
    public int getTamanhoMaximo() {
        return tamanhoMaximo;
    }

    @Operacao(nome = "Mostrar tamanho atual")
    public int getTamanhoAtual(){
        return this.indiceAtual;
    }

    @Operacao(nome = "Pegar elemento do topo")
    public int top(){
        return this.vetor[this.indiceAtual -1];
    }

    boolean isEmpty(){
        return this.indiceAtual == 0;
    }

    @Operacao(nome = "Limpar pilha")
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
