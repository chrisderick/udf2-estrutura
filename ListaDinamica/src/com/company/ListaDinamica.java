package com.company;

public class ListaDinamica {
    private int tamanho = 0;
    private No primeiro;
    private No ultimo;

    public void inserirInicio(String elemento){
        No novo = new No(elemento);
        if (isEmpty()){
            primeiro = novo;
            ultimo = primeiro;
        } else {
            if (!percorrerLista(elemento)) {
                novo.setProximo(primeiro);
                primeiro = novo;
            } else {
                System.out.println("Não foi possível inserir pois " + elemento + " já está na lista!");
                return;
            }
        }
        System.out.println("Elemento " + elemento + " inserido com sucesso");
        tamanho++;
    }

    public void inserirFinal(String elemento){
        if (isEmpty()) {
            inserirInicio(elemento);
        } else {
            if (!percorrerLista(elemento)) {
                No novo = new No(elemento);
                ultimo.setProximo(novo);
                ultimo = novo;
                System.out.println("Elemento " + elemento + " inserido com sucesso");
                tamanho++;
            } else {
                System.out.println("Não foi possível inserir pois " + elemento + " já está na lista!");
            }
        }
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
            System.out.println("=========================");
        } else {
            System.out.println();
            System.out.println("Não foi possível imprimir a lista, pois ela está vazia!");
            System.out.println();
        }
    }

    public void pesquisar(String valor){
        if(!isEmpty()){
            if(percorrerLista(valor)){
                System.out.println(valor + " está na lista!");
            } else {
                System.out.println(valor + " não está na lista!");
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public void remover(String valor){
        if(!isEmpty()){
            boolean foiremovido = false;
            No atual = primeiro;
            No anterior = null;
            for (int i = 0; i < tamanho; i++){
                if(atual.getElemento().equals(valor)){
                    if(atual == primeiro && atual == ultimo){
                        primeiro = ultimo = null;
                        tamanho--;
                        foiremovido = true;
                    } else if(atual == primeiro){
                        primeiro = primeiro.getProximo();
                        tamanho--;
                        foiremovido = true;
                    } else if(atual == ultimo) {
                        ultimo = anterior;
                        tamanho--;
                        foiremovido = true;
                    } else {
                        anterior.setProximo(atual.getProximo());
                        tamanho--;
                        foiremovido = true;
                    }
                    break;
                } else {
                    anterior = atual;
                    atual = atual.getProximo();
                }
            }
            if(foiremovido){
                System.out.println("Elemento removido com sucesso!");
            } else {
                System.out.println("O elemento não existe!");
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    private boolean percorrerLista(String valor){
        boolean existe = false;
        No atual = primeiro;
        for (int i = 0; i < tamanho; i++){
            if(atual.getElemento().equals(valor)){
                existe = true;
            } else {
                atual = atual.getProximo();
            }
        }
        return existe;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }
}
