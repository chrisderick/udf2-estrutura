package com.company;

public class TestaLista {

    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.inserirInicio("HeeJin");
        lista.inserirInicio("HyunJin");
        lista.inserirInicio("HaSeul");
        lista.inserirFinal("YeoJin");
        lista.inserirInicio("ViVi");
        lista.imprimir();
        lista.pesquisar("HaSeul");

    }
}
