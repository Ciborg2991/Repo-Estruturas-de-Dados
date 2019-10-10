package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.arvore_binaria;

public class Nodo {
    private Nodo esquerdo;
    private Nodo direito;
    private int conteudo;

    public Nodo(int conteudo) {
        this.conteudo = conteudo;
    }

    Nodo getEsquerdo() {
        return esquerdo;
    }

    void setEsquerdo(Nodo esquerdo) {
        this.esquerdo = esquerdo;
    }

    Nodo getDireito() {
        return direito;
    }

    void setDireito(Nodo direito) {
        this.direito = direito;
    }

    int getConteudo() {
        return conteudo;
    }

    void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }
}

