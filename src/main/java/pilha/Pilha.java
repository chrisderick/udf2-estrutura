package pilha;

public class Pilha {
    private No top;
    //TODO: Transformar a pilha em uma interface ou fazer herança, dependendo;

    public Pilha() {
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
            System.out.println("A pilha está vazia!");
        } else {
            int lixeira = top.getNum();
            System.out.println("Número " + lixeira + " retirado da pilha com sucesso!");
            top = top.getPrevious();
        }
    }

    public String peek(){
        String stack = "=====================\n";
        if (isEmpty()){
            stack += "A pilha está vazia!";
        } else {
            stack += "Pilha atual:";
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
