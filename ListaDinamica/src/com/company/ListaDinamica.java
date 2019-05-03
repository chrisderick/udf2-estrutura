package com.company;

public class ListaDinamica {
    private int tamanho = 0;
    private No primeiro;
    private No ultimo;

    public void inserirInicio(String elemento){
        No novo = new No(elemento);

        if(isEmpty()){
           primeiro = novo;
           ultimo = primeiro;
        } else {
            novo.setProximo(primeiro);
            primeiro = novo;
        }

        System.out.println("Elemento " + elemento + " inserido com sucesso");
        tamanho++;
    }

    public void inserirFinal(String elemento){
        if(isEmpty()){
            inserirInicio(elemento);
        } else {
            No novo = new No(elemento);
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    public void imprimir(){
        if (!isEmpty()){
            System.out.println("=========================");
            System.out.println("Lista: ");
            System.out.println();
            No atual = primeiro;
            System.out.println("---> " + atual.getElemento());
            for (int i = 1; i < tamanho; i++){
                atual = atual.getProximo();
                System.out.println("---> " + atual.getElemento());
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public No pesquisar(String valor){
        No retorno = null;
        if(!isEmpty()){
            System.out.println();
            No atual = primeiro;
            for (int i = 1; i < tamanho; i++){
                if(atual.getElemento().equals(valor)){
                    System.out.println("Este elemento existe na lista! :)");
                    retorno = atual;
                    break;
                } else {
                    atual = atual.getProximo();
                }
                if (i == tamanho-1){
                    System.out.println("Este elemento não existe na lista! :(");
                    retorno = atual;
                }
            }
        } else {
            System.out.println("A lista está vazia!");
        }
        return retorno;
    }

    public void remover(String valor){
        No no = pesquisar(valor);

    }

    public boolean isEmpty(){
        return tamanho == 0;
    }
}
