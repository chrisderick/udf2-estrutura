package pilhadinamica;

public class PilhaDinamica {
    private No top;

    public PilhaDinamica() {
        this.top = null;
    }

    public void push(int valor){
        No novo = new No();
        novo.setNum(valor);
        novo.setPrevious(top);
        top = novo;
    }

    public void pop(){
        if (top == null){
            System.out.println("A pilha dinâmica está vazia!");
        } else {
            int lixeira = top.getNum();
            System.out.println("Número " + lixeira + " removido com sucesso!");
            top = top.getPrevious();
        }
    }

    public String peek(){
        String stack = "=====================\n";
        if (isEmpty()){
            stack += "A pilha dinâmica está vazia!";
        } else {
            stack += "Pilha Dinâmica atual:";
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
