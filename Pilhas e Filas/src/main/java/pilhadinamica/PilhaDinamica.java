package pilhadinamica;

class PilhaDinamica {
    private No top;

    PilhaDinamica() {
        this.top = null;
    }

    void push(int valor){
        No novo = new No();
        novo.setNum(valor);
        novo.setPrevious(top);
        top = novo;
        System.out.println("Número " + valor + " adicionado com sucesso!");
    }

    void pop(){
        if (top == null){
            System.out.println("A pilha está vazia!");
        } else {
            int lixeira = top.getNum();
            System.out.println("Número " + lixeira + " removido com sucesso!");
            top = top.getPrevious();
        }
    }

    void peek(){
        System.out.println("=====================");
        if (isEmpty()){
            System.out.println("A pilha está vazia!");
        } else {
            System.out.println("Pilha: ");
            No current = top;
            while (current != null){
                System.out.println(current.getNum());
                current = current.getPrevious();
            }
            System.out.println();
        }
    }

    private boolean isEmpty(){
        return top == null;
    }


}
