package br.codes.clebermacieski.estruturasdedados.estruturas_de_dados;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Operacao {
    String nome();

    int posicao();
}
