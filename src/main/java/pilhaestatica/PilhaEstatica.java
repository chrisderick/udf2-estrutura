package pilhaestatica;

class PilhaEstatica {
    private No pilha[];
    private int topo = -1;

    PilhaEstatica(int max) { pilha = new No[max]; }

    void push(int valor){
        if(isFull()){
            System.out.println("A pilha está cheia!");
        } else {
            topo++;
            pilha[topo] = new No(valor, topo);
            System.out.println("Número " + valor + " adicionado com sucesso!");
        }
    }

    void pop(){
        if (!isEmpty()){
            System.out.println("Número " + pilha[topo].getValor() + " removido com sucesso!");
            pilha[topo] = null;
            topo--;
        } else {
            System.out.println("A pilha está vazia!");
        }
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
        } else {
            System.out.print("Pilha: ");
            for (int i = (pilha.length-1); i > -1; i--) {
                //Se o nó atual não for nulo, o bloco abaixo será executado
                if (pilha[i] != null) {
                    //Se for o último nó, a seta não será impressa
                    if (i != 0){
                        System.out.print(pilha[i].getValor() + " <- ");
                    } else {
                        System.out.println(pilha[i].getValor());
                    }
                }
            }
        }
    }

    boolean isEmpty(){
        return topo == -1;
    }

    boolean isFull(){
        return topo == pilha.length-1;
    }

}
