package com.company;

public class TestaLista {

    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.inserirInicio("HeeJin");
        lista.inserirFinal("YeoJin");
        lista.imprimir();
        lista.pesquisar("HaSeul");
        lista.remover("HaSeul");
        lista.remover("HeeJin");
        lista.imprimir();

    }
}
