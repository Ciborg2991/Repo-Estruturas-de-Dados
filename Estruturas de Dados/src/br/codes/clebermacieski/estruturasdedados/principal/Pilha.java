package br.codes.clebermacieski.estruturasdedados.principal;

public class Pilha extends EstruturaDeDados {
    private int TAMANHO;
    private int [] vetor;
    private int indice;

    public Pilha(int tamanho){
        this.TAMANHO = tamanho;
        this.vetor= new int[this.TAMANHO];
        this.indice = 0;
    }

    public Pilha() {

    }

    public void push(int valor) throws ArrayIndexOutOfBoundsException{
        this.vetor[this.indice]= valor;
        this.indice++;
    }

    public int top(){
        return this.vetor[this.indice-1];
    }

    public int pop() throws ArrayIndexOutOfBoundsException {
        int aux = this.vetor[this.indice-1];
        this.vetor[this.indice-1]= 0;
        this.indice--;
        return aux;
    }

    public void clear(){
        if(!this.isEmpty()){
            for (int i = 0; i < this.indice; i++) {
                this.vetor[i] = 0;
            }
            this.indice= 0;
        }
    }

    public int getTamanhoAtual(){
        return this.indice;
    }

     boolean isEmpty(){
         return this.indice == 0;
     }

    public int getTAMANHO() {
        return TAMANHO;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
