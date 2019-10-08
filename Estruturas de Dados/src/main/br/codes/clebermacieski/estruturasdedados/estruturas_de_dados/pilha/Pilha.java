package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.pilha;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados;
import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.Operacao;

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

    @Operacao(posicao= 0 , nome = "Inserir elemento")
    public void push(int valor) throws ArrayIndexOutOfBoundsException{
        this.vetor[this.indiceAtual]= valor;
        this.indiceAtual++;
    }

    @Operacao(posicao = 4, nome = "Remover elemento")
    public int pop() throws ArrayIndexOutOfBoundsException {
        try {
            int aux = this.vetor[this.indiceAtual - 1];
            this.vetor[this.indiceAtual - 1] = 0;
            this.indiceAtual--;
            return aux;
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("Não existe elemento.");
        }
    }

    @Operacao(posicao = 3 , nome = "Mostrar tamanho maximo")
    public int getTamanhoMaximo() {
        return tamanhoMaximo;
    }

    @Operacao(posicao = 2 , nome = "Mostrar tamanho atual")
    public int getTamanhoAtual(){
        return this.indiceAtual;
    }

    @Operacao(posicao = 1 ,nome = "Mostrar elemento do topo")
    public int top(){
        try {
            return this.vetor[this.indiceAtual - 1];
        }catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("Não existe elemento.");
        }
    }

    boolean isEmpty(){
        return this.indiceAtual == 0;
    }

    @Operacao(posicao = 5, nome = "Limpar pilha")
    public void clear(){
        if(!this.isEmpty()){
            for (int i = 0; i < this.indiceAtual; i++) {
                this.vetor[i] = 0;
            }
            this.indiceAtual = 0;
        } else{
            throw new RuntimeException("Pilha vazia.");
        }
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
