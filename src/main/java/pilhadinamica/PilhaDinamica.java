package pilhadinamica;
//TODO: Deixar tudo package-private, colocar mensagem nos metódos e editar o retorno do peek!

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

    String peek(){
        String stack = "=====================\n";
        if (isEmpty()){
            stack += "A pilha está vazia!";
        } else {
            stack += "Pilha:";
            No current = top;
            while (current != null){
                stack += "\n" + current.getNum();
                current = current.getPrevious();
            }
        }
        return stack;
    }

    public boolean isEmpty(){
        return top == null;
    }


}
