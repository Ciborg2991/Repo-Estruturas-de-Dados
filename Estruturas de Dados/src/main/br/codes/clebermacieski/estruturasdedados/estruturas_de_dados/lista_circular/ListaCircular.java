package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.lista_circular;

import br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.Operacao;

public class ListaCircular extends br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.EstruturaDeDados {

    private Nodo inicio;

    public ListaCircular(){
        this.inicio = null;
    }

    @Operacao(posicao = 0, nome = "Inserir no início")
    public void inserirNoInicio(String conteudo) {

        if(this.ehVazia()){
            this.inicio = new Nodo(conteudo, null);
            this.inicio.setProximo(this.inicio);
        }else{
            this.inicio= new Nodo(conteudo, this.inicio);
            var inicioAntigo = this.inicio.getProximo();
            alteraUltimoProximo(inicioAntigo);
        }
    }

    private void alteraUltimoProximo(Nodo inicioAntigo) {
        Nodo percorrer = inicioAntigo;

        do{
            if(percorrer.getProximo() == inicioAntigo){
                percorrer.setProximo(this.inicio);
            }
            percorrer = percorrer.getProximo();
        } while (percorrer != this.inicio);

    }

    @Operacao(posicao = 1,nome = "Inserir no fim")
    public void inserirNoFim(String conteudo){

        if (ehVazia()){ //Lista ainda vazia, inserir substituindo o primeiro nulo
            inserirNoInicio(conteudo);
        }
        else{ //Lista tem elementos, então busca o ultimo e insere depois
            Nodo percorrendo= this.inicio;

            while (percorrendo.getProximo() != this.inicio){
                percorrendo = percorrendo.getProximo();
            }
            percorrendo.setProximo(new Nodo(conteudo , this.inicio));
        }
    }

    @Operacao(posicao = 2,nome = "Inserir após elemento")
    public boolean insereApos (String elemento, String novoConteudo){
        Nodo percorrendo = this.inicio;

        do{
            if (percorrendo.getConteudo().equals(elemento)){
                percorrendo.setProximo(new Nodo(novoConteudo, percorrendo.getProximo()));
                return true;
            }
            percorrendo= percorrendo.getProximo();
        }while (percorrendo != this.inicio);
        return false;
    }

    @Operacao(posicao = 3,nome = "Inserir em posição específica")
    public boolean inserirNaPos(int posicao, String conteudo) {
        // Insere especificamente na posição, a parti de 0
        Nodo percorrendo = this.inicio;
        int cont = -1;

        if (percorrendo != null){
            cont++;
            if (cont == posicao){
                //insere aqui e será o inicio
                inserirNoInicio(conteudo);
                return true;
            }
            else{
                percorrendo= percorrendo.getProximo();
                cont++;
                do{
                    if (cont == posicao){
                        percorrendo = new Nodo(conteudo, percorrendo.getProximo());
                        return true;
                    }
                    percorrendo = percorrendo.getProximo();
                    cont++;
                } while (percorrendo != this.inicio);
            }
        }
        return false;
    }

    @Operacao(posicao = 5,nome = "Remover início da lista")
    public boolean removerOInicio() {
        // Remove o inicio e atualiza com o segundo, se existir
        if (this.inicio != null){
            if (this.inicio.getProximo() != null){
                this.inicio = this.inicio.getProximo();
            }
            else{
                this.inicio = null;
            }
            return true;
        }
        else{
            return false;
        }
    }

    @Operacao(posicao = 6, nome = "Remover fim da lista")
    public boolean removerOFim() {
        Nodo percorrer = this.inicio;

        while(percorrer.getProximo().getProximo() != this.inicio){
            percorrer = percorrer.getProximo();
        }
        percorrer.setProximo(this.inicio);
        return true;
    }

    @Operacao(posicao = 4, nome = "Mostrar lista")
    public void mostrar() {
        if (!ehVazia()) {
            try {
                Nodo percorrer = this.inicio;
                System.out.println(percorrer.getConteudo());
                percorrer = percorrer.getProximo();
                while (!percorrer.equals(this.inicio)){
                    System.out.println(percorrer.getConteudo());
                    percorrer = percorrer.getProximo();
                }
            } catch (NullPointerException e) {
                throw new NullPointerException("Lista Vazia");
            }
        }
    }

    private boolean ehVazia() {
        // Verifica se o inicio é nulo
        return this.inicio == null;
    }
}
