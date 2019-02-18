package pilhaestatica;

import java.util.Arrays;

class PilhaEstatica {
    private No[] pilha;
    private int topo = 0;

    PilhaEstatica(int max) {
        pilha = new No[max];
    }

    void push(int valor){
        if(!isFull()){
	    //TODO: socorr
            pilha[topo].setValor(valor);
            topo++;
            System.out.println("Número " + valor + " adicionado com sucesso!");
        } else {
            System.out.println("A pilha está cheia!");
        }
    }

    void pop(){
        if (!isEmpty()){
            pilha[(topo-1)].setValor(null);
            System.out.println("Número " + pilha[(topo-1)].getValor() + " removido com sucesso!");
            topo--;
        } else {
            System.out.println("A pilha está vazia!");
        }
    }

    String peek(){
        if (!isEmpty()){
            String stack = Arrays.toString(pilha);
            return stack;
        } else {
            String stack = "A pilha dinamica está vazia!";
            return stack;
        }
    }

    boolean isEmpty(){
        return topo == 0;
    }

    boolean isFull(){
        return topo >= pilha.length;
    }
}
