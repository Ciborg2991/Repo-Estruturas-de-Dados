package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_duplamente_encadeada;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.Operacao;

public class ListaDuplamenteEncadeada extends br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados {

    private Nodo primeiro;
    private Nodo ultimo;

    public ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public ListaDuplamenteEncadeada(int primeiroDado){
        Nodo nodo= new Nodo(null, primeiroDado, null);
        this.ultimo= null;
        this.primeiro= nodo;
    }

    @Operacao(posicao = 0, nome = "Adicionar elemento no ínicio")
    public void adicionarNoInicio(int i) {
        // Add nodo no começo
        if(this.primeiro == null){
            this.primeiro = new Nodo(null,i,null);
            this.ultimo = this.primeiro;
        }
        else{
            Nodo antigo = this.primeiro;
            this.primeiro= new Nodo(null,i,this.primeiro);
            antigo.setAnterior(this.primeiro);
        }
    }

    @Operacao(posicao = 1, nome= "Adicionar elemento no fim")
    public void adicionarNoFim(int i) {
        // Adiciona no fim manipulando referencia do ultimo, do ultimo nodo

        if (this.primeiro == null) {
            this.adicionarNoInicio(i);
        }
        else{
            Nodo antigo = this.ultimo;
            this.ultimo = new Nodo (this.ultimo,i,null);
            antigo.setProximo(this.ultimo);
        }
    }

    @Operacao(posicao = 2, nome= "Mostrar lista")
    public void imprimir() {
        // Imprime do inicio ao fim
        Nodo percorrendo = this.primeiro;
        if(percorrendo !=null){
            System.out.print("Primeiro: ");
            while (percorrendo != null){
                System.out.print(percorrendo.getConteudo());
                percorrendo= percorrendo.getProximo();
                System.out.print(" = ");
            }
            System.out.println();
        }
        else{
            System.out.println("Lista Vazia");
        }

    }

    public boolean ehvazia() {
        // Verifica o primeiro
        if(this.primeiro != null) return false;
        return true;
    }

    @Operacao(posicao= 3, nome = "Buscar elemento")
    public Nodo buscar(int i) {
        // Busca pelo conteudo
        Nodo percorrendo = this.primeiro;

        while (percorrendo != null && percorrendo.getConteudo() != i){
            percorrendo = percorrendo.getProximo();
        }
        return percorrendo;
    }

    @Operacao(posicao= 4, nome= "Extrair elemento")
    public boolean extrair(int i) {
        // Extrai pesquisando pelo conteudo
        Nodo percorrendo = this.primeiro;
        if(percorrendo != null){
            if(percorrendo.getConteudo() == i) {
                if (percorrendo.getProximo() != null) {percorrendo.getProximo().setAnterior(percorrendo.getAnterior());}
                if (percorrendo.getAnterior() != null) {percorrendo.getAnterior().setProximo(percorrendo.getProximo());}
                return true;
            }
        }
        else{
            return false;
        }
        while (percorrendo.getProximo() != null){
            percorrendo = percorrendo.getProximo();
            if (percorrendo.getConteudo() == i) {
                if (percorrendo.getProximo() != null) {percorrendo.getProximo().setAnterior(percorrendo.getAnterior());}
                if (percorrendo.getAnterior() != null) {percorrendo.getAnterior().setProximo(percorrendo.getProximo());}
                return true;
            }
        }
        return false;
    }

    @Operacao(posicao = 6, nome= "Retirar último elemento")
    public void retiraFim() {
        // Substitui fim pelo anterior, se houver
        if (this.ultimo != null) {
            this.ultimo= this.ultimo.getAnterior();
        }

    }

    @Operacao(posicao = 5, nome= "Remover primeiro elemento")
    public void retiraInicio() {
        // Substitui inicio pelo próximo, se houver inicio
        if (this.primeiro != null) {
            this.primeiro = this.primeiro.getProximo();
        }
    }
}
