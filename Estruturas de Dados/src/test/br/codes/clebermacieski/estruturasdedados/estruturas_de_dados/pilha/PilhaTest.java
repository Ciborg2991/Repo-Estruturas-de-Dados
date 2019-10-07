package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados.pilha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaTest {
    @Test
    void isEmpty(){
        Pilha pilha = new Pilha();
        assertTrue(pilha.isEmpty());
    }

    @Test
    void temElementosTest(){
        var pilha = new Pilha(1);
        pilha.push(1);
        assertFalse(pilha.isEmpty());
    }

    @Test
    void testaEmpurrarEmPilhaNaoInicializada() {
        var pilha = new Pilha();
        assertThrows(NullPointerException.class, () -> pilha.push(1));
    }

    @Test
    void push(){
        var pilha = new Pilha(1);
        pilha.push(546125);
    }

    @Test
    void testaEmpurrarAlemdoLimite(){
        var pilha = new Pilha(1);
        pilha.push(123);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> pilha.push(987));
    }

    @Test
    void testaRetirar(){
        var pilha = new Pilha(1);
        pilha.push(546125);

        pilha = new Pilha(15);
        pilha.push(2);
    }

    @Test
    void testaRetirarAlemdoLimite(){
        var pilha = new Pilha(1);
        pilha.push(159);
        pilha.pop();
        assertThrows(ArrayIndexOutOfBoundsException.class, pilha::pop);
    }

    @Test
    void testaCriarPilhaNegativa(){
        assertThrows(NegativeArraySizeException.class, ()-> new Pilha(-1));
    }

    @Test
    void getTamanhoMaximo(){
        var pilha = new Pilha();
        assertEquals(0,pilha.getTamanhoMaximo());
    }

    @Test
    void testaTamanhoInicial(){
        var pilha = new Pilha(1);
        assertEquals(1,pilha.getTamanhoMaximo());

        pilha = new Pilha(22);
        assertEquals(22, pilha.getTamanhoMaximo());
    }

    @Test
    void getTamanhoAtual(){
        var pilha = new Pilha(10);

        pilha.push(159);
        assertEquals(1,pilha.getTamanhoAtual());

        pilha.pop();
        assertEquals(0,pilha.getTamanhoAtual());

        pilha.push(4864684);
        pilha.push(543615);
        pilha.push(5489);
        assertEquals(3,pilha.getTamanhoAtual());

        pilha.pop();
        assertEquals(2,pilha.getTamanhoAtual());
    }

    @Test
    void testaTopPilhaVazia(){
        var pilha = new Pilha(2);
        assertThrows(ArrayIndexOutOfBoundsException.class, pilha::top);

        pilha.push(456);
        pilha.push(753);
        assertEquals(753, pilha.top());
    }

    @Test
    void top(){
        var pilha = new Pilha(2);
        pilha.push(456);
        pilha.push(753);
        assertEquals(753, pilha.top());

        pilha.pop();
        assertEquals(456, pilha.pop());

        assertThrows(ArrayIndexOutOfBoundsException.class, pilha::top);
    }

    @Test
    void clear(){
        var pilha = new Pilha(1);
        assertTrue(pilha.isEmpty());
        pilha.clear();
        assertTrue(pilha.isEmpty());

        pilha.push(1579);
        assertFalse(pilha.isEmpty());

        pilha.clear();
        assertTrue(pilha.isEmpty());
    }

    @Test
    void pop() {
        var pilha = new Pilha(1);
        pilha.push(150);
        assertEquals(150, pilha.pop());
    }
}