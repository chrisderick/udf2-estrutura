package br.edu.udf.lista;

public class TestaLista {

    public static void main(String[] args) {
        Lista lista = new Lista(5);

        lista.adicionar("A");
        lista.adicionar("B");
        lista.adicionar("D");
        lista.adicionar("E");

        System.out.println(lista.adicionar(2,"C"));
        System.out.println(lista);
        System.out.println(lista.tamanho());
        System.out.println(lista.adicionar("F"));
        System.out.println(lista);
        System.out.println(lista.tamanho());
        lista.remover(2);
        System.out.println(lista);
    }
}
